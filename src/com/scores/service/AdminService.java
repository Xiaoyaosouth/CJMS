package com.scores.service;

import java.util.*;

import com.scores.pojo.Admin;
import com.scores.pojo.Student;

public interface AdminService {
	/**
	 * 管理员登录
	 * @param admin实体
	 * @return
	 */
	Admin login(Admin admin);
	
	/**
	* 查询学生列表
	* @author 逍遥
	*/
	public List<Student> getStudentList();
	
	/**
	 * 添加学生
	 * @param student 学生实体
	 * @return 
	 */
	public String insStudent(Student student);
	
	/**
	 * 根据ID删除学生
	 * @param stuId 学生ID
	 * @return
	 */
	public String delStudent(String stuId);
	
	/**
	 * 更新学生数据
	 * @param student 学生实体
	 * @return
	 */
	public String updStudent(Student student);
}
