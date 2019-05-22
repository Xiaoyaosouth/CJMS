package com.scores.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.*;
import com.scores.service.*;

@Controller
public class AdminController {
	
	@Resource
	private AdminService adminServiceImpl;
	
	@RequestMapping("adminLogin")
	public String login(String userId,String password,HttpSession session){
		Admin admin=new Admin();
		admin.setAdmin_id(userId);
		admin.setAdmin_password(password);
		System.out.println(admin.toString());
		Admin adminSession=adminServiceImpl.login(admin);
		
		if(adminSession==null){
			return "UI/error.jsp";
		}else{
			session.setAttribute("admin", adminSession);
			System.out.println(adminSession.toString());
			return "UI/admin/main.jsp";
		}
	}
	
	/**
	 * 查询学生列表
	 * @param request
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("findAllStudent")
	public String getStudentList(javax.servlet.http.HttpServletRequest request){
		List<Student> stuList = adminServiceImpl.getStudentList();
		request.setAttribute("stuList", stuList);
		return "UI/admin/studentManage.jsp";
	}
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("addStudent")
	public ModelAndView addStudent(Student student) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.insStudent(student);
		mv.addObject("msg", str);
		mv.setViewName("findAllStudent");
		return mv;
	}
	
	/**
	 * 删除学生
	 * @param stuId 学生ID
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(String stuId) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.delStudent(stuId);
		mv.addObject("msg", str);
		mv.setViewName("findAllStudent");
		return mv;
	}
	
	/**
	 * 跳转到某页面，用于删除或修改前获得实体数据
	 * @param id 实体ID
	 * @param role 角色，student为学生，teacher为教师，semester为课程
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("redirectView")
	public ModelAndView rediectView(String id, String role) {
		ModelAndView mv = new ModelAndView();
		switch (role) {
		case "student": // 修改学生
			Student student = adminServiceImpl.selStudentById(id);
			mv.addObject("stuPojo", student);
			mv.setViewName("UI/admin/updateStudent.jsp");
			break;
		case "teacher": // 修改教师
			Teacher teacher = adminServiceImpl.selTeacherById(id);
			mv.addObject("teaPojo", teacher);
			mv.setViewName("UI/admin/updateTeacher.jsp");
			break;
		case "course": // 修改课程
			Course course = adminServiceImpl.selCourseById(id);
			mv.addObject("coursePojo", course);
			mv.setViewName("UI/admin/updateCourse.jsp");
			break;
		default:
			break;
		}
		return mv;
	}
	
	/**
	 * 更新学生
	 * @param student
	 * @return
	 */
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.updStudent(student);
		mv.addObject("msg", str);
		mv.setViewName("findAllStudent");
		return mv;
	}
	
	/**
	 * 查询教师列表
	 * @param request
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("findAllTeacher")
	public String getTeacherList(javax.servlet.http.HttpServletRequest request){
		List<Teacher> teaList = adminServiceImpl.getTeacherList();
		request.setAttribute("teaList", teaList);
		return "UI/admin/teacherManage.jsp";
	}
	
	/**
	 * 添加教师
	 * @param teacher
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("addTeacher")
	public ModelAndView addTeacher(Teacher teacher) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.insTeacher(teacher);
		mv.addObject("msg", str);
		mv.setViewName("findAllTeacher");
		return mv;
	}
	
	/**
	 * 删除教师
	 * @param teaId 教师ID
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("deleteTeacher")
	public ModelAndView deleteTeacher(String teaId) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.delTeacher(teaId);
		mv.addObject("msg", str);
		mv.setViewName("findAllTeacher");
		return mv;
	}
	
	/**
	 * 更新教师
	 * @param teacher
	 * @return
	 */
	@RequestMapping("updateTeacher")
	public ModelAndView updateTeacher(Teacher teacher) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.updTeacher(teacher);
		mv.addObject("msg", str);
		mv.setViewName("findAllTeacher");
		return mv;
	}
	
	/**
	 * 修改管理员密码
	 * @author 逍遥
	 */
	@RequestMapping("changeAdminPassword")
	public ModelAndView changeAdminPwd(@RequestParam(value="admin_id") String admId,
			@RequestParam(value="newpwd") String newpwd){
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.updAdminPassword(admId, newpwd);
		mv.addObject("msg", str);
		if (str.equals("Updated admin's password successfully")) {
			mv.setViewName("index.jsp");
		}else { // 修改失败
			mv.setViewName("UI/admin/changePassword.jsp?admId="+admId);
		}
		return mv;
	}
	
	/**
	 * 查询课程（按学期来查，要传入semester参数）
	 * @author 逍遥
	 */
	@RequestMapping("findAllCourse")
	public ModelAndView findAllCourse(@RequestParam(value="semester") String semester){
		ModelAndView mv = new ModelAndView();
		List<String> semesterList = null;
		List<Course> courseList = null;
		semesterList = adminServiceImpl.selAllSemester();
		if (semesterList != null) {
			mv.addObject("semesterList", semesterList);
		}
		if (semester != null &&
				!semester.equals("null")) {
			// 按学期查课程
			courseList = adminServiceImpl.selCourseBySemester(semester);
		}else {
			// 显示所有课程
			courseList = adminServiceImpl.selAllCourse();
		}
		mv.addObject("courseList", courseList);
		mv.setViewName("UI/admin/courseManage.jsp");
		return mv;
	}
	
	/**
	 * 尝试添加课程
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("tryAddCourse")
	public ModelAndView tryAddCourse() {
		ModelAndView mv = new ModelAndView();
		List<Course>courseList = adminServiceImpl.selAllCourse();
		if (courseList != null) {
			mv.addObject("courseListSize", courseList.size());
		}else {
			mv.addObject("courseListSize", 0);
		}
		mv.setViewName("UI/admin/addCourse.jsp");
		return mv;
	}
	
	/**
	 * 添加课程
	 * @param course
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("addCourse")
	public ModelAndView addCourse(Course course) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.insCourse(course);
		if (str.equals("添加失败，已存在相同ID的课程")) {
			List<Course>courseList = adminServiceImpl.selAllCourse();
			if (courseList != null) {
				mv.addObject("courseListSize", courseList.size());
			}else {
				mv.addObject("courseListSize", 0);
			}
			str = new String(str+"【系统建议ID为"+courseList.size()+"】");
			mv.setViewName("UI/admin/addCourse.jsp");
		}else {
			mv.setViewName("findAllCourse?semester=null");
		}
		mv.addObject("msg", str);
		return mv;
	}
	
	/**
	 * 删除课程
	 * @param courseId 课程ID
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("deleteCourse")
	public ModelAndView deleteCourse(String courseId) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.delCourse(courseId);
		mv.addObject("msg", str);
		mv.setViewName("findAllCourse?semester=null");
		return mv;
	}
	
	/**
	 * 更新课程
	 * @param course
	 * @return
	 */
	@RequestMapping("updateCourse")
	public ModelAndView updateCourse(Course course) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.updCourse(course);
		mv.addObject("msg", str);
		mv.setViewName("findAllCourse?semester=null");
		return mv;
	}
}
