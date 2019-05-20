package com.scores.service.impl;

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

	

}
