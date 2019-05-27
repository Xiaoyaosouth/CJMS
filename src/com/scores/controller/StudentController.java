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
	/**
	 * 学生登录
	 * @param userId
	 * @param password
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 修改学生密码
	 * @param newpwd
	 * @param confirmpwd
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("changestupwd")
	public ModelAndView changeTeacherPwd(String newpwd,String confirmpwd,
			HttpSession session,ModelAndView mv){
		Student student = (Student)session.getAttribute("student");
		String msg=studentServiceImpl.updPassword(student,newpwd,confirmpwd);
		if(msg.contains("请重新登录")) {
			mv.addObject("msg", msg);
			mv.setViewName("logout");
		}else {
			mv.addObject("msg", msg);
			mv.setViewName("UI/student/changePassword.jsp");
		}	
		return mv;
	}
}
