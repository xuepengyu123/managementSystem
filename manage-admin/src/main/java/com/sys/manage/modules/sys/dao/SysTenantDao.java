package com.sys.manage.modules.sys.dao;

import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户信息表
 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-25 09:30:33
 */
@Mapper
public interface SysTenantDao extends BaseMapper<SysTenantEntity> {
	
}
