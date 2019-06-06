package com.scores.controller;

import java.util.*;

import javax.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.scores.pojo.*;
import com.scores.service.*;

@Controller
public class AdminController {

	@Resource
	private AdminService adminServiceImpl;

	@Resource
	private TeacherService teacherServiceImpl;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 管理员登录
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping("adminLogin")
	public ModelAndView adminLogin(String userId, String password) {
		ModelAndView mv = new ModelAndView();
		Admin admin = new Admin();
		admin.setAdmin_id(userId);
		admin.setAdmin_password(password);
		admin = adminServiceImpl.login(admin);
		if (admin == null) {
			request.setAttribute("msg", "登录失败，Admin实体不存在");
			mv.setViewName("UI/error.jsp");
			return mv;
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			System.out.println(admin.toString());
			mv.setViewName("UI/admin/main.jsp");
			return mv;
		}
	}

	/**
	 * 查询学生列表
	 * 
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("findAllStudent")
	public ModelAndView getStudentList() {
		ModelAndView mv = new ModelAndView();
		List<Student> stuList = adminServiceImpl.getStudentList();
		request.setAttribute("stuList", stuList);
		mv.setViewName("UI/admin/studentManage.jsp");
		return mv;
	}

	/**
	 * 添加学生
	 * 
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
	 * 
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
	 * 
	 * @param id   实体ID
	 * @param role student为学生，teacher为教师，semester为课程，grade为成绩
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
			Course course = adminServiceImpl.selCourseById(Integer.parseInt(id));
			mv.addObject("coursePojo", course);
			mv.setViewName("UI/admin/updateCourse.jsp");
			break;
		case "gradeInStuPage": // 修改成绩
			Grade sgrade = adminServiceImpl.selGradeById(id);
			mv.addObject("gradePojo", sgrade);
			mv.setViewName("UI/admin/updateGradeInStuPage.jsp");
			break;
		case "gradeInCourPage": // 修改成绩
			Grade cgrade = adminServiceImpl.selGradeById(id);
			mv.addObject("gradePojo", cgrade);
			mv.setViewName("UI/admin/updateGradeInCourPage.jsp");
			break;
		default:
			break;
		}
		return mv;
	}

	/**
	 * 更新学生
	 * 
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
	 * 
	 * @param request
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("findAllTeacher")
	public String getTeacherList(javax.servlet.http.HttpServletRequest request) {
		List<Teacher> teaList = adminServiceImpl.getTeacherList();
		request.setAttribute("teaList", teaList);
		return "UI/admin/teacherManage.jsp";
	}

	/**
	 * 添加教师
	 * 
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
	 * 
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
	 * 
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
	 * 
	 * @author 逍遥
	 */
	@RequestMapping("changeAdminPassword")
	public ModelAndView changeAdminPwd(@RequestParam(value = "admin_id") String admId,
			@RequestParam(value = "newpwd") String npwd, @RequestParam(value = "confirmpwd") String cpwd) {
		ModelAndView mv = new ModelAndView();
		if (!npwd.equals(cpwd)) {
			mv.addObject("msg", "【错误】两次输入的密码不相同，请重新输入");
		} else {
			String str = adminServiceImpl.updAdminPassword(admId, npwd);
			mv.addObject("msg", str);
		}
		mv.setViewName("UI/admin/changePassword.jsp?admId=" + admId);
		return mv;
	}

	/**
	 * 查询课程（按学期来查，要传入semester参数）
	 * 
	 * @author 逍遥
	 */
	@RequestMapping("findAllCourse")
	public ModelAndView findAllCourse(@RequestParam(value = "semester", required = false) String semester) {
		ModelAndView mv = new ModelAndView();
		List<String> semesterList = null;
		List<Course> courseList = null;
		semesterList = adminServiceImpl.selAllSemester();
		if (semesterList != null) {
			mv.addObject("semesterList", semesterList);
		}
		if (semester != null && !semester.equals("null")) {
			// 按学期查课程
			courseList = adminServiceImpl.selCourseBySemester(semester);
		} else {
			// 显示所有课程
			courseList = adminServiceImpl.selAllCourse();
		}
		mv.addObject("courseList", courseList);
		mv.setViewName("UI/admin/courseManage.jsp");
		return mv;
	}

	/**
	 * 尝试添加课程
	 * 
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("tryAddCourse")
	public ModelAndView tryAddCourse() {
		ModelAndView mv = new ModelAndView();
		List<Course> courseList = adminServiceImpl.selAllCourse();
		if (courseList != null) {
			mv.addObject("courseListSize", courseList.size());
		} else {
			mv.addObject("courseListSize", 0);
		}
		mv.setViewName("UI/admin/addCourse.jsp");
		return mv;
	}

	/**
	 * 添加课程
	 * 
	 * @param course
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("addCourse")
	public ModelAndView addCourse(Course course) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.insCourse(course);
		if (str.equals("添加失败，已存在相同ID的课程")) {
			List<Course> courseList = adminServiceImpl.selAllCourse();
			if (courseList != null) {
				mv.addObject("courseListSize", courseList.size());
			} else {
				mv.addObject("courseListSize", 0);
			}
			str = new String(str + "【系统建议ID为" + courseList.size() + "】");
			mv.setViewName("UI/admin/addCourse.jsp");
		} else {
			mv.setViewName("findAllCourse?semester=null");
		}
		mv.addObject("msg", str);
		return mv;
	}

	/**
	 * 删除课程
	 * 
	 * @param courseId 课程ID
	 * @return
	 * @author 逍遥
	 */
	@RequestMapping("deleteCourse")
	public ModelAndView deleteCourse(String courseId) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.delCourse(Integer.parseInt(courseId));
		mv.addObject("msg", str);
		mv.setViewName("findAllCourse?semester=null");
		return mv;
	}

	/**
	 * 修改课程
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping("updateCourse")
	public ModelAndView updateCourse(Course course) {
		ModelAndView mv = new ModelAndView();
		String str = adminServiceImpl.updCourse(course);
		mv.addObject("msg", str);
		mv.setViewName("findAllCourse");
		return mv;
	}

	/**
	 * 帮助页面
	 * 
	 * @return
	 */
	@RequestMapping("help")
	public ModelAndView adminHelp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UI/help.jsp");
		return mv;
	}

	/**
	 * 【查询成绩】管理员查询成绩（需传入类型：stu表示学号，cour表示课程号）
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping("adminSearchGrade")
	public ModelAndView adminSearchGrade(String id, @RequestParam(value = "type", required = false) String type) {
		ModelAndView mv = new ModelAndView();
		if (type.equals("stu")) { // 由学号查询成绩
			List<Grade> listGrade = teacherServiceImpl.selGradeByStu(id);
			String[] str = teacherServiceImpl.selStuStatistics(id);
			String avg = str[0];// 平均成绩
			String avgpot = str[1];// 平均绩点
			String cridit = str[2];// 已修学分
			String courseNum = str[3];// 已修课程
			String fileNum = str[4];// 挂科数
			mv.addObject("avg", avg);
			mv.addObject("avgpot", avgpot);
			mv.addObject("cridit", cridit);
			mv.addObject("courseNum", courseNum);
			mv.addObject("fileNum", fileNum);// 统计信息
			if (listGrade.toString().equals("[]")) {
				mv.addObject("msg", "【错误】请输入学号");
				mv.setViewName("error.jsp");
			} else {
				mv.addObject("stuId", id);
				mv.addObject("listGrade", listGrade);
				mv.setViewName("UI/admin/stuGrade.jsp");
			}

		} else if (type.equals("cour")) { // 由课程号查询成绩
			List<Grade> listGrade = teacherServiceImpl.selGradeLogByCourse(id);
			String[] str = teacherServiceImpl.selCourseStatistics(id);
			String stuNum = str[0];
			String avg = str[1];
			String max = str[2];
			String min = str[3];
			String goodNum = str[4];
			String failNum = str[5];
			mv.addObject("stuNum", stuNum);
			mv.addObject("avg", avg);
			mv.addObject("max", max);
			mv.addObject("min", min);
			mv.addObject("goodNum", goodNum);
			mv.addObject("failNum", failNum);// 统计信息
			if (listGrade.toString().equals("[]")) {
				mv.addObject("msg", "【错误】请输入课程号");
				mv.setViewName("error.jsp");
			} else {
				mv.addObject("listGrade", listGrade);
				mv.addObject("courId", id);
				mv.setViewName("UI/admin/courseGrade.jsp");
			}
		}
		return mv;
	}

	/**
	 * 跳转到searchGradeByCourId.jsp（在输入课程号前将课程显示到页面）
	 * 
	 * @param key
	 * @param mv
	 * @return
	 */
	@RequestMapping("trySearchGradeByCourId")
	public ModelAndView trySearchGradeByCourId() {
		ModelAndView mv = new ModelAndView();
		// 查询所有课程
		List<Course> courseList = adminServiceImpl.selAllCourse();
		if (courseList != null) {
			mv.addObject("courseList", courseList);
		} else {
			mv.addObject("msg", "【错误】显示所有课程失败");
		}
		mv.setViewName("UI/admin/searchGradeByCourId.jsp");
		return mv;
	}

	/**
	 * 管理员修改成绩
	 * 
	 * @param grade
	 * @return
	 */
	@RequestMapping("adminUpdateStuGrade")
	public ModelAndView updateStuGrade(Grade grade,
			@RequestParam(value = "backPage", required = false) String backPage) {
		ModelAndView mv = new ModelAndView();
		String stuId = grade.getGrade_student();
		int courId = grade.getGrade_course();
		String str = adminServiceImpl.updGrade(grade);
		if (str.equals("success")) {
			str = new String("【成功】修改成绩");
		} else {
			str = new String("【失败】修改失败，未知错误");
		}
		mv.addObject("msg", str);
		if (backPage.equals("stu")) {
			mv.setViewName("adminSearchGrade?id=" + stuId + "&type=stu");
		} else if (backPage.equals("cour")) {
			mv.setViewName("adminSearchGrade?id=" + courId + "&type=cour");
		} else {
			mv.setViewName("error.jsp");
		}
		return mv;
	}
}
