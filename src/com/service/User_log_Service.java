package com.service;

import com.spring.entity.LoginLog;

/**
 * 登录日志业务操作接口
 * @author Flyaway
 *
 */
public interface User_log_Service {
	/**
	 * 保存登录日志
	 * @param loginLog
	 */
	public void sava(LoginLog loginLog);

}
