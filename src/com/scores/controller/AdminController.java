package com.scores.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scores.pojo.Admin;
import com.scores.service.AdminService;

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
	
}
