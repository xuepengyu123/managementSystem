package com.sys.manage.modules.sys.dao;

import com.sys.manage.modules.sys.entity.SysTenantExtendEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户扩展表

 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-28 13:56:40
 */
@Mapper
public interface SysTenantExtendDao extends BaseMapper<SysTenantExtendEntity> {

    /**
     * 通过租户id查询租户扩展内容
     * @param tenantId
     * @return
     */
    SysTenantExtendEntity getByTenantId(Long tenantId);
}
