package com.scores.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.*;
import com.scores.service.*;

@Controller
public class AdminController {
	
	@Resource
	private AdminService adminServiceImpl;
	
	@Resource
	private StudentService studentServiceImpl;
	
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
	 * 跳转到某页面，用于删除或修改前输入实体数据
	 * @param id 实体ID
	 * @param role 角色，student为学生，teacher为教师
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("redirectView")
	public ModelAndView rediectView(String id, String role) {
		ModelAndView mv = new ModelAndView();
		switch (role) {
		case "student":
			Student student = studentServiceImpl.selStudentById(id);
			mv.addObject("stuPojo", student);
			mv.setViewName("UI/admin/updateStudent.jsp");
			break;
		case "teacher":
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
		String str = adminServiceImpl.delStudent(teaId);
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
	
//	/**
//	 * 修改管理员密码
//	 * @param newpwd
//	 * @param confirmpwd
//	 * @param session
//	 * @param mv
//	 * @return
//	 */
//	@RequestMapping("changeAdminPassword")
//	public ModelAndView changeAdminPwd(@PathVariable String admId,String newpwd){
//		Admin admin = (Admin)session.get
//		if(newpwd.equals(null) || newpwd.equals("")) {
//			mv.addObject("msg", "密码不能为空！");
//		}else {
//			if(newpwd.equals(confirmpwd)) { // 如果密码确认无误
//				admin = adminServiceImpl.updAdminPassword(admin, newpwd); // 得到修改密码后的对象
//				session.setAttribute("admin", admin);
//				if(admin.getAdmin_password().equals(newpwd)) { // 检验修改是否正确
//					mv.addObject("msg", "修改密码成功！");
//				}else {
//					mv.addObject("msg", "修改密码失败！");
//				}
//			}else {
//				mv.addObject("msg", "前后密码输入不一致，请重新填写！");
//			}
//		}
//		mv.setViewName("UI/admin/changePassword.jsp");
//		return mv;
//	}
}
