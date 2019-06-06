package com.scores.service;

import java.util.*;

import com.scores.pojo.*;

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
	 * @return
	 * @author 逍遥
	 */
	public String updAdminPassword(String admId, String newpwd);
	
	/**
	 * 根据ID查询管理员
	 * @param admId 管理员ID
	 * @return 管理员实体
	 */
	public Admin selAdminById(String admId);
	
	/**
	 * 列出所有学期
	 * @return
	 */
	public List<String> selAllSemester();
	
	/**
	 * 根据学期查询课程
	 * @param semester 学期
	 * @return list
	 */
	public List<Course> selCourseBySemester(String semester);
	
	/**
	 * 添加课程
	 * @param course 课程实体
	 * @return 
	 * @author 逍遥
	 */
	public String insCourse(Course course);
	
	/**
	 * 查询所有课程，按学期降序
	 * @return list
	 */
	public List<Course> selAllCourse();
	
	/**
	 * 根据ID删除课程
	 * @param courseId 课程ID
	 * @return
	 * @author 逍遥
	 */
	public String delCourse(int courseId);
	
	/**
	 * 更新课程数据
	 * @param course 课程实体
	 * @return
	 * @author 逍遥
	 */
	public String updCourse(Course course);
	
	/**
	 * 根据ID查询课程
	 * @param courseId 课程ID
	 * @return 课程实体
	 */
	public Course selCourseById(int courseId);
	
	/**
	 * 根据ID查询教师
	 * @param teaId 教师ID
	 * @return 教师实体
	 */
	public Teacher selTeacherById(String teaId);
	
	/**
	 * 根据ID查询学生
	 * @param stuId 学生ID
	 * @return 学生实体
	 */
	public Student selStudentById(String stuId);
	
	/**
	 * 根据ID查询成绩
	 * @param grdId 成绩ID
	 * @return 成绩实体
	 * @author 逍遥
	 */
	public Grade selGradeById(String grdId);
	
	/**
	 * 修改成绩（需传入成绩ID和成绩）
	 * @param grade 成绩实体
	 * @return
	 */
	public String updGrade(Grade grade);
}
