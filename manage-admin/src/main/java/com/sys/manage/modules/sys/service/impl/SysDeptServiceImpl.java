package com.sys.manage.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.annotation.DataFilter;
import com.sys.manage.modules.sys.dao.SysDeptDao;
import com.sys.manage.modules.sys.entity.SysDeptEntity;
import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.sys.manage.modules.sys.service.SysDeptService;
import com.sys.manage.modules.sys.service.SysTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Autowired
    private SysTenantService sysTenantService;
    @Override
    @DataFilter(subDept = true, user = false, tableAlias = "t1")
    public List<SysDeptEntity> queryList(Map<String, Object> params) {
        List<SysDeptEntity> sysDeptEntities = baseMapper.queryList(params);
        for (SysDeptEntity sysDeptEntity: sysDeptEntities) {
            SysTenantEntity sysTenantEntity = sysTenantService.getById(sysDeptEntity.getTenantId());
            if (sysTenantEntity != null) {
                sysDeptEntity.setTenantName(sysTenantEntity.getTenantName());
            }
        }
        return sysDeptEntities;
    }

    @Override
    public List<Long> queryDetpIdList(Long parentId) {
        return baseMapper.queryDetpIdList(parentId);
    }

    @Override
    public List<Long> getSubDeptIdList(Long deptId) {
        //部门及子部门ID列表
        List<Long> deptIdList = new ArrayList<>();

        //获取子部门ID
        List<Long> subIdList = queryDetpIdList(deptId);
        getDeptTreeList(subIdList, deptIdList);

        return deptIdList;
    }

    /**
     * 递归
     */
    private void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
        for (Long deptId : subIdList) {
            List<Long> list = queryDetpIdList(deptId);
            if (list.size() > 0) {
                getDeptTreeList(list, deptIdList);
            }

            deptIdList.add(deptId);
        }
    }
}
