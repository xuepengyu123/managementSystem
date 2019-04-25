package com.sys.manage.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;

import com.sys.manage.modules.sys.dao.SysTenantInfoDao;
import com.sys.manage.modules.sys.entity.SysTenantInfoEntity;
import com.sys.manage.modules.sys.service.SysTenantInfoService;


@Service("sysTenantInfoService")
public class SysTenantInfoServiceImpl extends ServiceImpl<SysTenantInfoDao, SysTenantInfoEntity> implements SysTenantInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysTenantInfoEntity> page = this.page(
                new Query<SysTenantInfoEntity>().getPage(params),
                new QueryWrapper<SysTenantInfoEntity>()
        );

        return new PageUtils(page);
    }

}
