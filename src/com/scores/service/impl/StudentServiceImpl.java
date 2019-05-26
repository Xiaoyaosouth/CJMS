package com.scores.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.scores.mapper.*;
import com.scores.pojo.*;
import com.scores.service.*;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentMapper studentMapper;

	@Override
	public Student login(Student student) {
		Logger logger=Logger.getLogger(StudentServiceImpl.class);
		logger.info(student.getStudent_id()+"尝试登录");
		return studentMapper.selStudent(student);
	}

	@Override
	public Student selStudentById(String stuId) {
		Logger logger=Logger.getLogger(StudentServiceImpl.class);
		logger.info("尝试由学生ID查找学生");
		return studentMapper.selStudentById(stuId);
	}

	
	@Override
	public Student updPassword(Student student, String pwd) {
		if(0<studentMapper.updStudentPwd(student.getStudent_id(), pwd)) {
			student.setStudent_password(pwd);
		}
		return student;
	}
}
