package com.scores.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.*;
import com.scores.service.*;

@Controller
public class StudentController {
	
	@Resource
	private StudentService studentServiceImpl;
	
	@RequestMapping("studentLogin")
	public String login(String userId,String password,HttpSession session){
		Student student = new Student();
		student.setStudent_id(userId);
		student.setStudent_password(password);
		System.out.println(student.toString());
		Student studentSession = studentServiceImpl.login(student);
		
		if(studentSession==null){
			return "UI/error.jsp";
		}else{
			session.setAttribute("student", studentSession);
			System.out.println(studentSession.toString());
			return "UI/student/main.jsp";
		}
	}
	
}
