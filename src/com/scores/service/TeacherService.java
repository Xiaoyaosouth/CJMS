package com.scores.service;

import com.scores.pojo.*;

public interface TeacherService {
	/**
	 * 教师登录
	 * @param Teacher实体
	 * @return
	 */
	Teacher login(Teacher teacher);
	
	/**
	 * 修改教师密码
	 * @param teacher
	 * @param newPwd
	 * @return 修改密码后的教师类
	 */
	Teacher updPassword(Teacher teacher,String pwd);
}
