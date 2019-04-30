package com.sys.manage.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.annotation.DataFilter;
import com.sys.manage.common.utils.Constant;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;
import com.sys.manage.modules.sys.dao.SysUserDao;
import com.sys.manage.modules.sys.entity.SysDeptEntity;
import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.sys.manage.modules.sys.entity.SysUserChannelEntity;
import com.sys.manage.modules.sys.entity.SysUserEntity;
import com.sys.manage.modules.sys.service.*;
import com.sys.manage.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 * @author xue
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private SysTenantService sysTenantService;
    @Autowired
    private SysUserChannelService sysUserChannelService;

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return baseMapper.queryAllMenuId(userId);
    }

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String) params.get("username");

        IPage<SysUserEntity> page = this.page(
                new Query<SysUserEntity>().getPage(params),
                new QueryWrapper<SysUserEntity>()
                        .like(StringUtils.isNotBlank(username), "username", username)
                        .apply(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
        );

        for (SysUserEntity sysUserEntity : page.getRecords()) {
            SysDeptEntity sysDeptEntity = sysDeptService.getById(sysUserEntity.getDeptId());
            sysUserEntity.setDeptName(sysDeptEntity.getName());

            SysTenantEntity sysTenantEntity = sysTenantService.getById(sysUserEntity.getTenantId());
            if (sysTenantEntity != null) {
                sysUserEntity.setTenantName(sysTenantEntity.getTenantName());
            }
        }

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(SysUserEntity user) {
        // 保存用户信息
        this.save(user);

        //sha256加密
        SysUserChannelEntity sysUserChannelEntity = new SysUserChannelEntity();
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUserChannelEntity.setSalt(salt);
        sysUserChannelEntity.setPassword(ShiroUtils.sha256(user.getPassword(), salt));
        sysUserChannelEntity.setUserId(user.getUserId());
        sysUserChannelEntity.setStatus(1);
        // 保存用户渠道信息
        sysUserChannelService.save(sysUserChannelEntity);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(SysUserEntity user) {
        // 更新用户表
        this.updateById(user);
        // 更新用户渠道表
        SysUserChannelEntity userChannelEntity = sysUserChannelService.getByUserId(user.getUserId());
        if (StringUtils.isNotBlank(user.getPassword())) {
            userChannelEntity.setPassword(ShiroUtils.sha256(user.getPassword(), userChannelEntity.getSalt()));
        }
        sysUserChannelService.updateById(userChannelEntity);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }


    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new QueryWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
    }

}
