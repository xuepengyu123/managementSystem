package com.sys.manage.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.annotation.DataFilter;
import com.sys.manage.common.utils.Constant;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;
import com.sys.manage.modules.sys.dao.SysRoleDao;
import com.sys.manage.modules.sys.entity.SysDeptEntity;
import com.sys.manage.modules.sys.entity.SysRoleEntity;
import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.sys.manage.modules.sys.service.*;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @author xue
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private SysTenantService sysTenantService;

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String) params.get("roleName");
        IPage<SysRoleEntity> page = this.page(
                new Query<SysRoleEntity>().getPage(params),
                new QueryWrapper<SysRoleEntity>()
                        .like(StringUtils.isNotBlank(roleName), "role_name", roleName)
                        .apply(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
        );

        for (SysRoleEntity sysRoleEntity : page.getRecords()) {
            // 查询机构名称
            SysDeptEntity sysDeptEntity = sysDeptService.getById(sysRoleEntity.getDeptId());
            if (sysDeptEntity != null) {
                sysRoleEntity.setDeptName(sysDeptEntity.getName());
            }
            // 查询租户名称
            SysTenantEntity sysTenantEntity = sysTenantService.getById(sysRoleEntity.getTenantId());
            if (sysTenantEntity != null) {
                sysRoleEntity.setTenantName(sysTenantEntity.getTenantName());
            }
        }
        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(SysRoleEntity role) {
        List<Long> tenantIdList = role.getTenantIdList();
        if(tenantIdList!=null){
            role.setTenantId(tenantIdList.get(0));
        }
        this.save(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        this.updateById(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        //删除角色
        this.removeByIds(Arrays.asList(roleIds));

        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色与部门关联
        sysRoleDeptService.deleteBatch(roleIds);

        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }


}
