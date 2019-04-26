package com.sys.manage.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;

import com.sys.manage.modules.sys.dao.SysTenantDao;
import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.sys.manage.modules.sys.service.SysTenantService;


@Service("sysTenantService")
public class SysTenantServiceImpl extends ServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysTenantEntity> page = this.page(
                new Query<SysTenantEntity>().getPage(params),
                new QueryWrapper<SysTenantEntity>()
        );

        return new PageUtils(page);
    }

}
