package com.scores.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scores.pojo.*;
import com.scores.service.*;

@Controller
public class TeacherController {
	
	@Resource
	private TeacherService teacherServiceImpl;
	
	@RequestMapping("teacherLogin")
	public String login(String userId,String password,HttpSession session){
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(userId);
		teacher.setTeacher_password(password);
		System.out.println(teacher.toString());
		Teacher teacherSession = teacherServiceImpl.login(teacher);
		
		if(teacherSession==null){
			return "UI/error.jsp";
		}else{
			session.setAttribute("teacher", teacherSession);
			System.out.println(teacherSession.toString());
			return "UI/teacher/main.jsp";
		}
			
	}
	
}
