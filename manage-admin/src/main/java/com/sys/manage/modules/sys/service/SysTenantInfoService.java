package com.sys.manage.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.sys.entity.SysTenantInfoEntity;

import java.util.Map;

/**
 * 租户信息表
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-25 09:30:33
 */
public interface SysTenantInfoService extends IService<SysTenantInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

