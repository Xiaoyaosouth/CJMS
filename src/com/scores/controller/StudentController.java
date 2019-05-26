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
		if(newpwd.equals(null)||newpwd.equals("")) {
			mv.addObject("msg", "密码不能为空！");
		}else {
			if(newpwd.equals(confirmpwd)) {
				student=studentServiceImpl.updPassword(student, newpwd);
				session.setAttribute("student", student);
				if(student.getStudent_password().equals(newpwd)){
					mv.addObject("msg", "修改成功！");
					mv.setViewName("logout");
				}else {
					mv.addObject("msg", "修改失败！");
					mv.setViewName("UI/student/changePassword.jsp");
				}
			}else {
				mv.addObject("msg", "前后密码输入不一致，请重新填写！");
				mv.setViewName("UI/student/changePassword.jsp");
			}
		}
		return mv;
	}
}
