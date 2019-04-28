package com.sys.manage.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;

import com.sys.manage.modules.sys.dao.SysTenantExtendDao;
import com.sys.manage.modules.sys.entity.SysTenantExtendEntity;
import com.sys.manage.modules.sys.service.SysTenantExtendService;


@Service("sysTenantExtendService")
public class SysTenantExtendServiceImpl extends ServiceImpl<SysTenantExtendDao, SysTenantExtendEntity> implements SysTenantExtendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysTenantExtendEntity> page = this.page(
                new Query<SysTenantExtendEntity>().getPage(params),
                new QueryWrapper<SysTenantExtendEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public SysTenantExtendEntity getByTenantId(Long tenantId) {
        return baseMapper.getByTenantId(tenantId);
    }

}
