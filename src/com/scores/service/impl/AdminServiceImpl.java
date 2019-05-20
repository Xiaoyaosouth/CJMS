package com.scores.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.scores.mapper.AdminMapper;
import com.scores.pojo.Admin;
import com.scores.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper adminMapper;

	@Override
	public Admin login(Admin admin) {
		Logger logger=Logger.getLogger(AdminServiceImpl.class);
		logger.info(admin.getAdmin_id()+"尝试登录");
		return adminMapper.selAdmin(admin);
	}

	

}
