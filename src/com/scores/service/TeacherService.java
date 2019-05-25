package com.scores.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scores.pojo.Course;
import com.scores.pojo.Grade;
import com.scores.pojo.Teacher;

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
	
	/**
	 * 查找此教师所有未录入成绩的课程
	 * @param tid
	 * @return
	 */
	List<Course> selUninsectCourse(String tid);
	
	/**
	 * 查找此课程所有需要录入的成绩条
	 * @param courseid
	 * @return
	 */
	List<Grade> selGradeByCourse(String courseid);
	
	/**
	 * 批量录入成绩
	 * @param id
	 * @param fraction
	 * @return
	 */
	boolean updGradeById(String[] gradeId,String[] fraction);
	
	/**
	 * 根据关键词查询成绩
	 * @param key
	 * @return
	 */
	List<Grade> selGradeByKey(String key);
	
	/**
	 * 根据学生id搜索成绩统计信息
	 * @param stuId
	 * @return
	 */
	String[] selStuStatistics(String stuId);
	
	/**
	 * 根据课程id搜索成绩统计信息
	 * @param stuId
	 * @return
	 */
	String[] selCourseStatistics(String CourseId);
}
















