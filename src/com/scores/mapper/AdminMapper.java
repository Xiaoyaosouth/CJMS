package com.scores.mapper;

import org.apache.ibatis.annotations.Select;

import com.scores.pojo.Admin;

public interface AdminMapper {
	
	@Select("select * from admin where admin_id=#{admin_id} and admin_password=#{admin_password}")
	public Admin selAdmin(Admin admin);
}
