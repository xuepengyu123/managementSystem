package com.sys.manage.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.modules.sys.entity.SysTenantExtendEntity;

/**
 * 租户扩展表

 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-28 13:56:40
 */
public interface SysTenantExtendService extends IService<SysTenantExtendEntity> {

    /**
     * 通过租户id查询租户扩展内容
     * @param tenantId
     * @return
     */
    SysTenantExtendEntity getByTenantId(Long tenantId);
}

