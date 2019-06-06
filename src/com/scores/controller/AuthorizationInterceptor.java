package com.scores.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.Admin;
import com.scores.pojo.Student;
import com.scores.pojo.Teacher;

public class AuthorizationInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		String servletPath=arg0.getServletPath();
		if(servletPath.contains("/login")||
				servletPath.contains("Login")||
				servletPath.contains("/logout")){
			System.out.println("====== login ======");
			return true;
		}
		
		Teacher teacher=(Teacher)arg0.getSession().getAttribute("teacher");
		Student student=(Student)arg0.getSession().getAttribute("student");
		Admin admin=(Admin)arg0.getSession().getAttribute("admin");
		
		if(null==teacher&&null==student&&null==admin){
			arg0.getRequestDispatcher("/logout").forward(arg0,arg1);
			System.out.println("====== personSession is null ======");
			return false;
		}else{
			System.out.println("====== personSession is not null ======");
			return true;
		}
	}

}
