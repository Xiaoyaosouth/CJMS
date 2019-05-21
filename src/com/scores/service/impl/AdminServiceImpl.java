package com.scores.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.scores.mapper.*;
import com.scores.pojo.*;
import com.scores.service.*;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	@Resource
	private StudentMapper studentMapper;

	@Override
	public Admin login(Admin admin) {
		Logger logger=Logger.getLogger(AdminServiceImpl.class);
		logger.info(admin.getAdmin_id()+"尝试登录");
		return adminMapper.selAdmin(admin);
	}

	@Override
	public List<Student> getStudentList() {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		List<Student> stuList = adminMapper.findAllStudent();
		logger.info("查询学生表，共"+stuList.size()+"条数据");
		return stuList;
	}

	@Override
	public String insStudent(Student student) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		// 先从数据库查找是否已存在该ID的学生
		logger.info("尝试查找ID为"+student.getStudent_id()+"的学生");
		Student tempStudent = studentMapper.selStudentById(student.getStudent_id());
		if (tempStudent != null &&
				tempStudent.getStudent_id().equals(student.getStudent_id())) {
			return "添加失败，已存在相同ID的学生";
		}else {
			logger.info("尝试添加学生数据");
			int result = adminMapper.insertStudent(student);
			if (result > 0) {
				return "Added successfully";
			}else {
				return "error";
			}
		}
	}

	@Override
	public String delStudent(String stuId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的学生
		logger.info("尝试查找ID为"+stuId+"的学生");
		Student tempStudent = studentMapper.selStudentById(stuId);
		if (tempStudent == null) {
			str = "删除失败，学生不存在";
		}else {
			logger.info("尝试删除学生");
			int result = adminMapper.deleteStudentById(stuId);
			if (result > 0) {
				str = "Deleted successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public String updStudent(Student student) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的学生
		logger.info("尝试查找ID为"+student.getStudent_id()+"的学生");
		Student tempStudent = studentMapper.selStudentById(student.getStudent_id());
		if (tempStudent == null) {
			str = "修改失败，学生不存在";
		}else {
			logger.info("尝试修改学生数据");
			int result = adminMapper.updateStudent(student);
			if (result > 0) {
				str = "Updated successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

}
