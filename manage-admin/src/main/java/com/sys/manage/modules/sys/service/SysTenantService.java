package com.sys.manage.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.sys.entity.SysTenantEntity;

import java.util.Map;

/**
 * 租户信息表
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-25 09:30:33
 */
public interface SysTenantService extends IService<SysTenantEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

