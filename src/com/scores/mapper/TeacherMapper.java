package com.scores.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.scores.pojo.Course;
import com.scores.pojo.Grade;
import com.scores.pojo.Student;
import com.scores.pojo.Teacher;

public interface TeacherMapper {
	
	@Select("select * from teacher where teacher_id=#{teacher_id} and teacher_password=#{teacher_password}")
	public Teacher selTeacher(Teacher teacher);
	
	/**
	 * 根据ID查询教师
	 * @param stuId
	 * @return
	 * @author zhang
	 */
	@Select("select * from teacher where teacher_id=#{teaId}")
	public Teacher selTeacherById(String teaId);
	
	/**
	 * 修改教师密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	@Update("UPDATE teacher SET teacher_password = #{pwd} WHERE teacher_id = #{id}")
	public int updTeacherPwd(@Param("id") String id,@Param("pwd")String pwd);
	
	/**
	 * 查找教师需要录入成绩的所有课程
	 * @param tid
	 * @return
	 */
	@Select("select * from course where course_teacher=#{tid} and is_done=0")
	public List<Course> selCourseByTeacher(@Param("tid")String tid);
	
	/**
	 * 查找此课程所有需要录入的成绩条
	 * @param tid
	 * @return
	 */
	@Select("select * from grade where grade_course=#{courseid} and grade_fraction=0")
	public List<Grade> selGradeByCourse(@Param("courseid")String courseid);
	
	/**
	 * 根据学生学号搜索学生
	 * @param id
	 * @return
	 */
	@Select("select * from student where student_id=#{id}")
	public Student selStudentById(@Param("id")String id);
	
	/**
	 * 根据成绩ID录入成绩
	 * @param gradeid
	 * @param fraction
	 * @return
	 */
	@Update("UPDATE grade SET grade_fraction = #{fraction} WHERE grade_id = #{gradeid}")
	public int updGradeById(@Param("gradeid")String gradeid,@Param("fraction")String fraction);
	
	
	/**
	 * 查找此课程所有的成绩条
	 * @param tid
	 * @return
	 */
	@Select("select * from grade where grade_course=#{courseid}")
	public List<Grade> selGradeByCourseKey(@Param("courseid")String courseid);
	
	/**
	 * 查找此学生所有的成绩条
	 * @param tid
	 * @return
	 */
	@Select("select * from grade where grade_student=#{studentid}")
	public List<Grade> selselGradeByStudentKey(@Param("studentid")String studentid);
	
	//==============学生统计================//
	@Select("SELECT avg(grade_fraction) FROM grade WHERE grade_student=#{studentid}")
	public float selAvg(@Param("studentid")String studentid);
	
	@Select("SELECT sum(course_credit) FROM course WHERE course_id IN"
			+ "(select grade_course FROM grade where grade_student=#{studentid} AND grade_fraction>=60)")
	public int selCredit(@Param("studentid")String studentid);
	
	@Select("SELECT COUNT(grade_course) FROM grade WHERE grade_student=#{studentid}")
	public int selCourse(@Param("studentid")String studentid);
	
	@Select("SELECT COUNT(*) FROM grade WHERE grade_student=#{studentid} and grade_fraction<60")
	public int selFail(@Param("studentid")String studentid);
	
	//==============学生统计================//
	
	//==============课程统计================//
	/* <td>课程总人数：平均成绩：最高分：最低分：优秀数：挂科数：*/
	@Select("SELECT COUNT(*) FROM grade WHERE grade_course=2")
	public int selStuNum(@Param("courseId")String courseId);
	
	@Select("SELECT avg(grade_fraction) FROM grade WHERE grade_course=2")
	public float selCourseAvg(@Param("courseId")String courseId);
	
	@Select("SELECT max(grade_fraction) FROM grade WHERE grade_course=2")
	public int selCourseMax(@Param("courseId")String courseId);
	
	@Select("SELECT min(grade_fraction) FROM grade WHERE grade_course=2")
	public int selCourseMin(@Param("courseId")String courseId);
	
	@Select("SELECT COUNT(*) FROM grade WHERE grade_course=2 AND grade_fraction>=80")
	public int selCourseGoodNum(@Param("courseId")String courseId);
	
	@Select("SELECT COUNT(*) FROM grade WHERE grade_course=2 AND grade_fraction<60")
	public int selCourseFailNum(@Param("courseId")String courseId);
	//==============课程统计================//
	
	
}


















