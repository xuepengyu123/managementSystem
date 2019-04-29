package com.sys.manage.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.modules.sys.dao.SysTenantExtendDao;
import com.sys.manage.modules.sys.entity.SysTenantExtendEntity;
import com.sys.manage.modules.sys.service.SysTenantExtendService;
import org.springframework.stereotype.Service;


@Service("sysTenantExtendService")
public class SysTenantExtendServiceImpl extends ServiceImpl<SysTenantExtendDao, SysTenantExtendEntity> implements SysTenantExtendService {

    @Override
    public SysTenantExtendEntity getByTenantId(Long tenantId) {
        return baseMapper.selectOne(new QueryWrapper<SysTenantExtendEntity>().eq("tenant_id", tenantId));
    }

}
