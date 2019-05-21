package com.scores.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.Admin;
import com.scores.pojo.Student;
import com.scores.service.AdminService;
import com.scores.service.StudentService;

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
	 * @param stuPj
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("findAllStudent")
	public String getStudentList(javax.servlet.http.HttpServletRequest request){
		java.util.List<Student> stuList = adminServiceImpl.getStudentList();
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
}
