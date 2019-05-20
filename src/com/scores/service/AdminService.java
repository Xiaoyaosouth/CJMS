package com.scores.service;

import com.scores.pojo.Admin;

public interface AdminService {
	/**
	 * 管理员登录
	 * @param admin实体
	 * @return
	 */
	Admin login(Admin admin);
}
