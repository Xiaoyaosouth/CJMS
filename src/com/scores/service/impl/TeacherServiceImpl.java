package com.scores.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.scores.mapper.*;
import com.scores.pojo.*;
import com.scores.service.*;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Resource
	private TeacherMapper teacherMapper;

	@Override
	public Teacher login(Teacher teacher) {
		Logger logger=Logger.getLogger(TeacherServiceImpl.class);
		logger.info(teacher.getTeacher_id()+"尝试登录");
		return teacherMapper.selTeacher(teacher);
	}

	/**
	 * 修改教师密码
	 * @param teacher
	 * @param newPwd
	 * @param confirmPwd
	 * @return 修改密码后的教师类
	 */
	@Override
	public Teacher updPassword(Teacher teacher, String pwd) {
		if(0<teacherMapper.updTeacherPwd(teacher.getTeacher_id(), pwd)) {
			teacher.setTeacher_password(pwd);
		}
		return teacher;
	}

	/**
	 * 查找此教师所有未录入成绩的课程
	 * @param tid
	 * @return
	 */
	@Override
	public List<Course> selUninsectCourse(String tid) {
		return teacherMapper.selCourseByTeacher(tid);
	}

	
	/**
	 * 查找此课程所有需要录入的成绩条
	 * @param courseid
	 * @return
	 */
	@Override
	public List<Grade> selGradeByCourse(String courseid) {
		List<Grade> listGrade=teacherMapper.selGradeByCourse(courseid);
		for (Grade grade : listGrade) {
			grade.setStudent(teacherMapper.selStudentById(grade.getGrade_student()));
		}
		return listGrade;
	}

	/**
	 * 批量录入成绩
	 */
	@Override
	public boolean updGradeById(String[] gradeId, String[] fraction) {
		for(int i=0;i<gradeId.length;i++) {
			if(0>teacherMapper.updGradeById(gradeId[i], fraction[i])){
				return false;
			}
		}
		return true;
	}

	/**
	 * 根据关键词查询成绩
	 * @param key
	 * @return
	 */
	@Override
	public List<Grade> selGradeByKey(String key) {
		List<Grade> listGrade=teacherMapper.selGradeByCourseKey(key);
		listGrade.addAll(teacherMapper.selselGradeByStudentKey(key));
		for (Grade grade : listGrade) {
			grade.setStudent(teacherMapper.selStudentById(grade.getGrade_student()));
		}
		return listGrade;
	}

	

}
