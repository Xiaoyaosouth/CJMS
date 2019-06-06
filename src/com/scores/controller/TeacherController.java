package com.scores.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.Course;
import com.scores.pojo.Grade;
import com.scores.pojo.Student;
import com.scores.pojo.Teacher;
import com.scores.service.TeacherService;

@Controller
public class TeacherController {
	
	@Resource
	private TeacherService teacherServiceImpl;
	
	/**
	 * 教师登录
	 * @param userId
	 * @param password
	 * @param session
	 * @return
	 */
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
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletResponse response,HttpSession session,ModelAndView mv){
		if(session!=null) {
			session.removeAttribute("teacher");
			session.removeAttribute("admin");
			session.removeAttribute("student");
			session.invalidate();
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.err.println("PrintWriter out 错误");
			e.printStackTrace();
		}
		out.print("<script> window.top.location.replace('http://localhost:8080/CJMS/index.jsp');</script>");
		out.flush();
		return null;
	}
	
	
	/**
	 * 修改教师密码
	 * @param newpwd
	 * @param confirmpwd
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("changeteacherpwd")
	public ModelAndView changeTeacherPwd(String newpwd,String confirmpwd,
			HttpSession session,ModelAndView mv){
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String msg=teacherServiceImpl.updPassword(teacher,newpwd,confirmpwd);
		if(msg.contains("请重新登录")) {
			mv.addObject("msg", msg);
			mv.setViewName("logout");
		}else {
			mv.addObject("msg", msg);
			mv.setViewName("UI/teacher/changePassword.jsp");
		}
		return mv;
	}
	
	/**
	 * 根据教师搜索待录入成绩的课程
	 * @param session
	 * @param mv
	 * @return
	 */
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
	
	/**
	 * 根据课程搜索待录入成绩
	 * @param courseid
	 * @param mv
	 * @return
	 */
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
	
	/**
	 * 录入成绩
	 * @param gradeid
	 * @param fraction
	 * @param mv
	 * @return
	 */
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
	/**
	 * 根据关键词搜索学生成绩信息
	 * @param key
	 * @param mv
	 * @return
	 */
	@RequestMapping("searchstugrade")
	public ModelAndView searchStuGrade(String key,ModelAndView mv){
		List<Grade> listGrade=teacherServiceImpl.selGradeByStu(key);
		
		String[] str=teacherServiceImpl.selStuStatistics(key);
		String avg=str[0];//平均成绩
		String avgpot=str[1];//平均绩点
		String cridit=str[2];//已修学分
		String courseNum=str[3];//已修课程
		String fileNum=str[4];//挂科数
		mv.addObject("avg", avg);
		mv.addObject("avgpot", avgpot);
		mv.addObject("cridit", cridit);
		mv.addObject("courseNum", courseNum);
		mv.addObject("fileNum", fileNum);//统计信息
		
		if(listGrade.toString().equals("[]")) {
			mv.addObject("msg", "error,请输入学号");
		}else {
			mv.addObject("listGrade", listGrade);
		}
		mv.setViewName("UI/teacher/stugrade.jsp");
		return mv;
	}
	
	/**
	 * 根据关键词搜索课程成绩信息
	 * @param key
	 * @param mv
	 * @return
	 */
	@RequestMapping("searchcoursegrade")
	public ModelAndView searchCourseGrade(String key,ModelAndView mv){
		List<Grade> listGrade=teacherServiceImpl.selGradeLogByCourse(key);
		String[] str=teacherServiceImpl.selCourseStatistics(key);
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
		mv.addObject("failNum", failNum);//统计信息
		
		if(listGrade.toString().equals("[]")) {
			mv.addObject("msg", "error,请输入课程号");
		}else {
			mv.addObject("listGrade", listGrade);
		}
		mv.setViewName("UI/teacher/coursegrade.jsp");
		return mv;
	}
	
	/**
	 * 学生统计控制信息
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
	
	/**
	 * 课程成绩统计信息
	 * @param id
	 * @param mv
	 * @return
	 */
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
	/**
	 * 查询需要管理的课程
	 * @param mv
	 * @return
	 */
	@RequestMapping("managercourse")
	public ModelAndView managerCourse(HttpSession session,ModelAndView mv) {
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		mv.addObject("listCourse", teacherServiceImpl.selCourseByTid(teacher.getTeacher_id()));
		mv.setViewName("UI/teacher/managerCourse.jsp");
		return mv;
	}
	
	/**
	 * 为课程添加学生前
	 * @param courseid
	 * @param mv
	 * @return
	 */
	@RequestMapping("addstudentfirst")
	public ModelAndView addStudentFirst(String courseid,ModelAndView mv) {
		mv.addObject("courseid", courseid);
		mv.setViewName("UI/teacher/addStudent.jsp");
		return mv;
	}
	
	/**
	 * 为课程添加学生
	 * @param courseid
	 * @param mv
	 * @return
	 */
	@RequestMapping("addstudent")
	public ModelAndView addStudent(String courseid,String strdentStr,ModelAndView mv) {
		String [] listStrdent=strdentStr.split(",");
		System.out.println("课程：【"+courseid+"】。");
		for (String string : listStrdent) {
			System.out.println("学生：【"+string+"】。");
		}
		int result=teacherServiceImpl.insGrade(courseid, listStrdent);
		if(result==listStrdent.length) {
			mv.addObject("msg", "添加成功");
		}else {
			mv.addObject("msg", "添加失败");
		}
		mv.setViewName("managercourse");
		return mv;
	}
	
	
}
