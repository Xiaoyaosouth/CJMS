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
	@RequestMapping("logout")
	public String logout(HttpSession session){
		if(session!=null) {
			session.removeAttribute("teacher");
			session.removeAttribute("admin");
			session.removeAttribute("student");
			session.invalidate();
		}
		return "index.jsp";
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
	
	@RequestMapping("searchstugrade")
	public ModelAndView searchStuGrade(String key,ModelAndView mv){
		List<Grade> listGrade=teacherServiceImpl.selGradeByKey(key);
		if(listGrade.toString().equals("[]")) {
			mv.addObject("msg", "error,请输入学号或课程号");
		}else {
			mv.addObject("listGrade", listGrade);
		}
		mv.setViewName("UI/teacher/searchgrade.jsp");
		return mv;
	}
	
	@RequestMapping("searchcoursegrade")
	public ModelAndView searchCourseGrade(String key,ModelAndView mv){
		List<Grade> listGrade=teacherServiceImpl.selGradeByKey(key);
		if(listGrade.toString().equals("[]")) {
			mv.addObject("msg", "error,请输入学号或课程号");
		}else {
			mv.addObject("listGrade", listGrade);
		}
		mv.setViewName("UI/teacher/searchgrade.jsp");
		return mv;
	}
	
	/**
	 * 学生统计控制方法
	 * @param mv
	 * @return
	 */
	@RequestMapping("stustatistics")
	public ModelAndView stuStatistics(String id,ModelAndView mv) {
		String[] str=teacherServiceImpl.selStuStatistics(id);
		String avg=str[0];//平均成绩
		String avgpot=str[1];//平均绩点
		String cridit=str[2];//已修学分
		String courseNum=str[3];//已修课程
		String fileNum=str[4];//挂科数
		
		mv.addObject("avg", avg);
		mv.addObject("avgpot", avgpot);
		mv.addObject("cridit", cridit);
		mv.addObject("courseNum", courseNum);
		mv.addObject("fileNum", fileNum);
		
		mv.setViewName("UI/teacher/stuStatistics.jsp");
		return mv;
	}
	
	@RequestMapping("coursestatistics")
	public ModelAndView courseStatistics(String id,ModelAndView mv) {
		String[] str=teacherServiceImpl.selCourseStatistics(id);
		String stuNum=str[0];
		String avg=str[1];
		String max=str[2];
		String min=str[3];
		String goodNum=str[4];
		String failNum=str[5];
		mv.addObject("stuNum", stuNum);
		mv.addObject("avg", avg);
		mv.addObject("max", max);
		mv.addObject("min", min);
		mv.addObject("goodNum", goodNum);
		mv.addObject("failNum", failNum);
		mv.setViewName("UI/teacher/courseStatistics.jsp");
		return mv;
	}
	
	
	
}
