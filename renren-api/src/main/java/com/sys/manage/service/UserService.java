

package com.sys.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.entity.UserEntity;
import com.sys.manage.form.LoginForm;

import java.util.Map;

/**
 * 用户
 *
 * @author xue
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回登录信息
	 */
	Map<String, Object> login(LoginForm form);
}
