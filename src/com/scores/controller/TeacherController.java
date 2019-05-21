package com.scores.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.Teacher;
import com.scores.service.TeacherService;

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
	
	@RequestMapping("changeteacherpwd")
	public ModelAndView changeTeacherPwd(String newpwd,String confirmpwd,
			HttpSession session,ModelAndView mv){
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		if(newpwd.equals(null)||newpwd.equals("")) {
			mv.addObject("msg", "密码不能为空！");
		}else {
			if(newpwd.equals(confirmpwd)) {
				teacher=teacherServiceImpl.updPassword(teacher, newpwd);
				session.setAttribute("teacher", teacher);
				if(teacher.getTeacher_password().equals(newpwd)) {
					mv.addObject("msg", "修改成功！");
				}else {
					mv.addObject("msg", "修改失败！");
				}
			}else {
				mv.addObject("msg", "前后密码输入不一致，请重新填写！");
			}
		}
		mv.setViewName("UI/teacher/changePassword.jsp");
		return mv;
	}
	
}
