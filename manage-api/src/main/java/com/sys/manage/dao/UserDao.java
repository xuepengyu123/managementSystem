

package com.sys.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.manage.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author xue
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
