package com.sys.manage.modules.sys.dao;

import com.sys.manage.modules.sys.entity.TestEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-26 17:20:44
 */
@Mapper
public interface TestDao extends BaseMapper<TestEntity> {
	
}
