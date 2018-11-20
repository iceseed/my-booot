package com.hxe.core.api.service;


import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.hxe.core.api.entity.UserEntity;
import com.hxe.core.api.form.LoginForm;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
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
