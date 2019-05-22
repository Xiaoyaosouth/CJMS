package com.scores.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.scores.mapper.*;
import com.scores.pojo.*;
import com.scores.service.*;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper adminMapper;

	@Override
	public Admin login(Admin admin) {
		Logger logger=Logger.getLogger(AdminServiceImpl.class);
		logger.info(admin.getAdmin_id()+"尝试登录");
		return adminMapper.selAdmin(admin);
	}

	@Override
	public List<Student> getStudentList() {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		List<Student> stuList = adminMapper.findAllStudent();
		logger.info("查询学生表，共"+stuList.size()+"条数据");
		return stuList;
	}

	@Override
	public String insStudent(Student student) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		// 先从数据库查找是否已存在该ID的学生
		logger.info("尝试查找ID为"+student.getStudent_id()+"的学生");
		Student tempStudent = selStudentById(student.getStudent_id());
		if (tempStudent != null &&
				tempStudent.getStudent_id().equals(student.getStudent_id())) {
			return "添加失败，已存在相同ID的学生";
		}else {
			logger.info("尝试添加学生数据");
			int result = adminMapper.insertStudent(student);
			if (result > 0) {
				return "Added successfully";
			}else {
				return "error";
			}
		}
	}

	@Override
	public String delStudent(String stuId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的学生
		logger.info("尝试查找ID为"+stuId+"的学生");
		Student tempStudent = selStudentById(stuId);
		if (tempStudent == null) {
			str = "删除失败，学生不存在";
		}else {
			logger.info("尝试删除学生");
			int result = adminMapper.deleteStudentById(stuId);
			if (result > 0) {
				str = "Deleted successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public String updStudent(Student student) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的学生
		logger.info("尝试查找ID为"+student.getStudent_id()+"的学生");
		Student tempStudent = selStudentById(student.getStudent_id());
		if (tempStudent == null) {
			str = "修改失败，学生不存在";
		}else {
			logger.info("尝试修改学生数据");
			int result = adminMapper.updateStudent(student);
			if (result > 0) {
				str = "Updated successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public List<Teacher> getTeacherList() {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		List<Teacher> teaList = adminMapper.findAllTeacher();
		logger.info("查询教师表，共"+teaList.size()+"条数据");
		return teaList;
	}

	@Override
	public String insTeacher(Teacher teacher) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		// 先从数据库查找是否已存在该ID的教师
		logger.info("尝试查找ID为"+teacher.getTeacher_id()+"的教师");
		Teacher tempTeacher = selTeacherById(teacher.getTeacher_id());
		if (tempTeacher != null &&
				tempTeacher.getTeacher_id().equals(teacher.getTeacher_id())) {
			return "添加失败，已存在相同ID的教师";
		}else {
			logger.info("尝试添加教师数据");
			int result = adminMapper.insertTeacher(teacher);
			if (result > 0) {
				return "Added teacher successfully";
			}else {
				return "error";
			}
		}
	}

	@Override
	public String delTeacher(String teaId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的教师
		logger.info("尝试查找ID为"+teaId+"的教师");
		Teacher tempTeacher = selTeacherById(teaId);
		if (tempTeacher == null) {
			str = "删除失败，教师不存在";
		}else {
			logger.info("尝试删除教师");
			int result = adminMapper.deleteTeacherById(teaId);
			if (result > 0) {
				str = "Deleted teacher successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public String updTeacher(Teacher teacher) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的教师
		logger.info("尝试查找ID为"+teacher.getTeacher_id()+"的教师");
		Teacher tempTeacher = selTeacherById(teacher.getTeacher_id());
		if (tempTeacher == null) {
			str = "修改失败，教师不存在";
		}else {
			logger.info("尝试修改教师数据");
			int result = adminMapper.updateTeacher(teacher);
			if (result > 0) {
				str = "Updated teacher successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public String updAdminPassword(String admId, String newpwd) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的管理员
		Admin admin = selAdminById(admId);
		if (admin == null) {
			str = "修改密码失败，管理员不存在";
		}else {
			if (newpwd !=null && 
					newpwd.equals(admin.getAdmin_password())) {
				str = "修改密码失败，新密码与旧密码相同";
			}else {
				logger.info("尝试修改管理员密码");
				admin.setAdmin_password(newpwd);
				int result = adminMapper.updAdminPwd(admin);
				if (result > 0) {
					str = "Updated admin's password successfully";
				}else {
					str = "error";
				}
			}
		}
		return str;
	}

	@Override
	public Admin selAdminById(String admId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		logger.info("尝试查找ID为"+admId+"的管理员");
		Admin admin = adminMapper.selAdminById(admId);
		if (admin != null) {
			return admin;
		}
		return null;
	}

	@Override
	public List<String> selAllSemester() {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		logger.info("尝试查询所有学期");
		List<String> semesterList = adminMapper.selAllSemester();
		if (semesterList != null) {
			return semesterList;
		}
		return null;
	}

	@Override
	public List<Course> selCourseBySemester(String semester) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		logger.info("尝试查询学期为"+semester+"的课程");
		List<Course> courseList = adminMapper.selCourseBySemester(semester);
		if (courseList != null) {
			return courseList;
		}
		return null;
	}

	@Override
	public String insCourse(Course course) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的课程
		int courseId = course.getCourse_id();
		if (courseId != 0) {
			logger.info("尝试查找ID为"+courseId+"的课程");
			Course tempCourse = selCourseById(String.valueOf(courseId));
			if (tempCourse != null &&
					tempCourse.getCourse_id() == courseId) {
				str = "添加失败，已存在相同ID的课程";
			}else {
				logger.info("尝试添加课程数据");
				int result = adminMapper.insertCourse(course);
				if (result > 0) {
					str = "Added course successfully";
				}else {
					str = "error";
				}
			}
		}
		return str;
	}

	@Override
	public List<Course> selAllCourse() {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		logger.info("尝试查询所有课程");
		List<Course> courseList = adminMapper.selAllCourse();
		if (courseList != null) {
			return courseList;
		}
		return null;
	}

	@Override
	public String delCourse(String courseId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		// 先从数据库查找是否已存在该ID的课程
		logger.info("尝试查找ID为"+courseId+"的课程");
		Course tempCourse = selCourseById(courseId);
		if (tempCourse == null) {
			str = "删除失败，课程不存在";
		}else {
			logger.info("尝试删除课程");
			int result = adminMapper.deleteCourseById(courseId);
			if (result > 0) {
				str = "Deleted course successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public String updCourse(Course course) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		String str = null;
		String courseId = null;
		// 先从数据库查找是否已存在该ID的课程
		courseId = String.valueOf(course.getCourse_id());
		logger.info("尝试查找ID为"+courseId+"的课程");
		Course tempCourse = selCourseById(courseId);
		if (tempCourse == null) {
			str = "修改失败，课程不存在";
		}else {
			logger.info("尝试修改课程数据");
			int result = adminMapper.updateCourse(course);
			if (result > 0) {
				str = "Updated course successfully";
			}else {
				str = "error";
			}
		}
		return str;
	}

	@Override
	public Course selCourseById(String courseId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		logger.info("尝试查找ID为"+courseId+"的课程");
		Course course = adminMapper.selCourseById(courseId);
		if (course != null) {
			return course;
		}
		return null;
	}

	@Override
	public Teacher selTeacherById(String teaId) {
		Logger logger = Logger.getLogger(AdminServiceImpl.class);
		logger.info("尝试查找ID为"+teaId+"的教师");
		Teacher teacher = adminMapper.selTeacherById(teaId);
		if (teacher != null) {
			return teacher;
		}
		return null;
	}
	
	@Override
	public Student selStudentById(String stuId) {
		Logger logger=Logger.getLogger(StudentServiceImpl.class);
		logger.info("尝试由学生ID查找学生");
		return adminMapper.selStudentById(stuId);
	}

}
