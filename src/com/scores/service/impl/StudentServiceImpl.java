package com.scores.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
	public String updPassword(Student student, String newpwd, String confirmpwd){
		if(newpwd.equals(null)||newpwd.equals("")) {
			return "密码不能为空！";
		}
		if(!newpwd.equals(confirmpwd)) {
			return "前后密码不一致，请重新填写！";
		}
		
		int i=0;
		try {
			i=studentMapper.updStudentPwd(student.getStudent_id(), newpwd);
		} catch (Exception e) {
			e.printStackTrace();
			return "会话已超时，请重新登录！";
		}
		if(i>0) {
			return "密码修改成功，请重新登录！";
		}else {
			return "会话已超时，请重新登录！";
		}
		
	}

	
	
}
