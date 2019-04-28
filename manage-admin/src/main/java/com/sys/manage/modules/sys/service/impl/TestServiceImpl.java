package com.sys.manage.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;

import com.sys.manage.modules.sys.dao.TestDao;
import com.sys.manage.modules.sys.entity.TestEntity;
import com.sys.manage.modules.sys.service.TestService;


@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestDao, TestEntity> implements TestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestEntity> page = this.page(
                new Query<TestEntity>().getPage(params),
                new QueryWrapper<TestEntity>()
        );

        return new PageUtils(page);
    }

}
