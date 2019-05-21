package com.scores.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.Course;
import com.scores.pojo.Grade;
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
	
	@RequestMapping("selcourse")
	public ModelAndView selCourse(HttpSession session,ModelAndView mv) {
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		List<Course> listcourse=teacherServiceImpl.selUninsectCourse(teacher.getTeacher_id());
		for (Course course : listcourse) {
			System.out.println(course);
		}
		if(null==listcourse) {
			mv.addObject("msg", "无未录入的课程");
		}else {
			mv.addObject("listcourse",listcourse);
		}
		mv.setViewName("UI/teacher/selcourse.jsp");
		return mv;
	}
	
	@RequestMapping("selgrade")
	public ModelAndView selGrade(String courseid,ModelAndView mv){
		List<Grade> listGrade=teacherServiceImpl.selGradeByCourse(courseid);
		if(!listGrade.toString().equals("[]")) {
			mv.addObject("listGrade", listGrade);
			System.out.println(listGrade);
		}else {
			System.out.println(listGrade);
			mv.addObject("msg", "无待录入成绩");
			mv.setViewName("selcourse");
			return mv;
		}
		mv.setViewName("UI/teacher/allgrade.jsp");
		return mv;
	}
	
	@RequestMapping("insgrade")
	public ModelAndView insGrade(String gradeid,String fraction,ModelAndView mv){
		String[] listGradeId=gradeid.split(",");
		String[] listFraction=fraction.split(",");
		if(teacherServiceImpl.updGradeById(listGradeId, listFraction)) {
			mv.addObject("msg", "录入成功");
		}else {
			mv.addObject("msg", "录入失败，请重新录入。");
		}
		mv.setViewName("selcourse");
		return mv;
	}
	
	@RequestMapping("searchgrade")
	public ModelAndView searchGrade(String key,ModelAndView mv){
		List<Grade> listGrade=teacherServiceImpl.selGradeByKey(key);
		if(listGrade.toString().equals("[]")) {
			mv.addObject("msg", "error,请输入学号或课程号");
		}else {
			mv.addObject("listGrade", listGrade);
		}
		mv.setViewName("UI/teacher/searchgrade.jsp");
		return mv;
	}
	
	
	
}
