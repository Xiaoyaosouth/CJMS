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
	 * 根据学号查询成绩
	 * @param key
	 * @return
	 */
	@Override
	public List<Grade> selGradeByStu(String stuId) {
		List<Grade> listGrade=teacherMapper.selselGradeByStudentKey(stuId);
		for (Grade grade : listGrade) {
			grade.setStudent(teacherMapper.selStudentById(grade.getGrade_student()));
			Course course=teacherMapper.selCourseById(grade.getGrade_course());
			course.setTeacher(teacherMapper.selTeacherById(course.getCourse_teacher()));
			grade.setCourse(course);
		}
		return listGrade;
	}
	
	/**
	 * 根据课程号查询成绩
	 * @param key
	 * @return
	 */
	@Override
	public List<Grade> selGradeLogByCourse(String courseId) {
		List<Grade> listGrade=teacherMapper.selGradeByCourseKey(courseId);
		for (Grade grade : listGrade) {
			grade.setStudent(teacherMapper.selStudentById(grade.getGrade_student()));
			Course course=teacherMapper.selCourseById(grade.getGrade_course());
			course.setTeacher(teacherMapper.selTeacherById(course.getCourse_teacher()));
			grade.setCourse(course);
		}
		return listGrade;
	}

	
	@Override
	public String[] selStuStatistics(String stuId) {
		float avg=0;//平均成绩
		float avgpot=0;//平均绩点
		int cridit=0;//已修学分
		int courseNum=0;//已修课程
		int fileNum=0;//挂科数
		avg=teacherMapper.selAvg(stuId);
		if(avg>60) {
			avgpot=(avg/10)-5;
		}
		cridit=teacherMapper.selCredit(stuId);
		courseNum=teacherMapper.selCourse(stuId);
		fileNum=teacherMapper.selFail(stuId);
		String [] str=new String[] {""+avg,""+avgpot,""+cridit,""+courseNum,""+fileNum};
		return str;
	}

	@Override
	public String[] selCourseStatistics(String courseId) {
		/* <td>课程总人数：平均成绩：最高分：最低分：优秀数：挂科数：*/
		int stuNum=0;
		float avg=0;
		int max=0;
		int min=0;
		int goodNum=0;
		int failNum=0;
		stuNum=teacherMapper.selStuNum(courseId);
		avg=teacherMapper.selCourseAvg(courseId);
		max=teacherMapper.selCourseMax(courseId);
		min=teacherMapper.selCourseMin(courseId);
		goodNum=teacherMapper.selCourseGoodNum(courseId);
		failNum=teacherMapper.selCourseFailNum(courseId);
		String [] str=new String[] {""+stuNum,""+avg,""+max,
				""+min,""+goodNum,""+failNum};
		return str;
	}

	

}
