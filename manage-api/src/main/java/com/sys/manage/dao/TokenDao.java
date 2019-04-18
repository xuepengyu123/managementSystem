

package com.sys.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.manage.entity.TokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 *
 * @author xue
 */
@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
	
}
