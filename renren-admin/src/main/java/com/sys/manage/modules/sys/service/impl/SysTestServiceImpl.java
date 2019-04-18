package com.sys.manage.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;

import com.sys.manage.modules.sys.dao.SysTestDao;
import com.sys.manage.modules.sys.entity.SysTestEntity;
import com.sys.manage.modules.sys.service.SysTestService;


@Service("sysTestService")
public class SysTestServiceImpl extends ServiceImpl<SysTestDao, SysTestEntity> implements SysTestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysTestEntity> page = this.page(
                new Query<SysTestEntity>().getPage(params),
                new QueryWrapper<SysTestEntity>()
        );

        return new PageUtils(page);
    }

}
