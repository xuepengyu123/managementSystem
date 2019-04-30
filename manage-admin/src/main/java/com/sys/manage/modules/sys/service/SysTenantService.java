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

    /**
     * 通过租户id，查询租户信息
     *
     * @param tenantId
     * @return
     */
    SysTenantEntity info(Long tenantId);

    /**
     * 保存租户信息
     *
     * @param sysTenant
     */
    void saveSysTenant(SysTenantEntity sysTenant);

    /**
     * 更新租户信息
     *
     * @param sysTenant
     */
    void updateSysTenantEntityById(SysTenantEntity sysTenant);

}

