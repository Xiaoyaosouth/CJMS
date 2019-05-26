package com.scores.aspect;

import javax.servlet.http.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.Admin;

/**
 * Spring AOP切面，用于管理员执行业务前检查Session，防止不登录就操作
 * @author 逍遥
 */
@Component
@Aspect
public class AdminServiceAspect {
	
	/**
	 * 排除login方法
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(String com.scores.service.impl.AdminServiceImpl.*(..))"
			+ "&& !execution(* com.scores.service.impl.AdminServiceImpl.login(..))")
	public Object sessionCheck(ProceedingJoinPoint pjp) throws Throwable{
		String targetClassName = pjp.getTarget().getClass().getSimpleName();
		String targetMethodName = pjp.getSignature().getName();
		System.out.println("目标类：" + targetClassName);
		System.out.println("目标方法：" + targetMethodName);
		// 获得request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
		// 获得session
		HttpSession session = request.getSession();
		// 获取session中的Admin实体
		Admin tempAdmin = (Admin)session.getAttribute("admin");
		if (tempAdmin == null || tempAdmin.getAdmin_id() == null) {
			System.err.println("切面：Session中没有AdminId，不能执行业务");
			return "【提示】请先登录再继续操作！";
		}else {
			System.out.println("切面：继续执行业务");
			Object tempObj = pjp.proceed(); // 继续执行业务
			// 处理返回值，这里对应serviceImpl的返回值，可匹配其它值
			if (tempObj.equals("Updated password successfully")) {
				tempObj = new String("修改密码成功，请重新登录！");
				session.removeAttribute("admin"); // 修改成功则移除session（需重新登录）
			}
			
			System.out.println("切面：将返回的值是" + tempObj);
			return tempObj;
		}
	}
	
}
