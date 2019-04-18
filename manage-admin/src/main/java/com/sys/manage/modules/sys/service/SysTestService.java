package com.sys.manage.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.sys.entity.SysTestEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-18 16:14:26
 */
public interface SysTestService extends IService<SysTestEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

