package com.sys.manage.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.sys.entity.TestEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-26 17:20:44
 */
public interface TestService extends IService<TestEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

