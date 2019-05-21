package com.scores.service;

import java.util.*;

import com.scores.pojo.Admin;
import com.scores.pojo.Student;
import com.scores.pojo.Teacher;

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
	 * @author 逍遥
	 */
	public String insStudent(Student student);
	
	/**
	 * 根据ID删除学生
	 * @param stuId 学生ID
	 * @return
	 * @author 逍遥
	 */
	public String delStudent(String stuId);
	
	/**
	 * 更新学生数据
	 * @param student 学生实体
	 * @return
	 * @author 逍遥
	 */
	public String updStudent(Student student);
	
	/**
	* 查询教师列表
	* @author 逍遥
	*/
	public List<Teacher> getTeacherList();
	
	/**
	 * 添加教师
	 * @param teacher 教师实体
	 * @return 
	 * @author 逍遥
	 */
	public String insTeacher(Teacher teacher);
	
	/**
	 * 根据ID删除教师
	 * @param teaId 教师ID
	 * @return
	 * @author 逍遥
	 */
	public String delTeacher(String teaId);
	
	/**
	 * 更新教师数据
	 * @param teacher 教师实体
	 * @return
	 * @author 逍遥
	 */
	public String updTeacher(Teacher teacher);
	
	/**
	 * 修改管理员密码
	 * @param admin 管理员实体
	 * @param pwd 新密码
	 * @return
	 */
	public Admin updAdminPassword(Admin admin, String pwd);
}
