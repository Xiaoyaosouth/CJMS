package com.scores.service;

import com.scores.pojo.*;

public interface StudentService {
	/**
	 * 学生登录
	 * @param Student实体
	 * @return
	 */
	Student login(Student student);
	
	/**
	 * 根据学生ID查询学生
	 * @param stuId
	 * @return
	 */
	public Student selStudentById(String stuId);

	/**
	 * 更新密码
	 * @param student
	 * @param newpwd
	 * @return
	 */
	Student updPassword(Student student, String newpwd);
}
