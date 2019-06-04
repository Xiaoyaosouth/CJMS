package com.scores.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.scores.pojo.*;

public interface AdminMapper {
	
	@Select("select * from admin where admin_id=#{admin_id} and admin_password=#{admin_password}")
	public Admin selAdmin(Admin admin);
	
	/**
	 * 查询学生表
	 * @return list对象
	 * @author 逍遥
	 */
	@Select("select * from student")
	public List<Student> findAllStudent();
	
	/**
	 * 根据ID查询学生
	 * @param stuId 学生ID
	 * @return 学生实体
	 * @author 逍遥
	 */
	@Select("SELECT * FROM student WHERE student_id=#{stuId}")
	public Student selStudentById(String stuId);
	
	/**
	 * 插入学生数据
	 * @param student 学生实体
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Insert("insert into student("
			+ "student_id,student_name,student_password,student_department,student_gender,student_mail,student_tel"
			+ ") values("
			+ "#{student_id},#{student_name},#{student_password},#{student_department},"
			+ "#{student_gender},#{student_mail},#{student_tel}"
			+ ")")
	public int insertStudent(Student student);
	
	/**
	 * 根据ID删除学生
	 * @param stuId 学生ID
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Delete("delete from student where student_id = #{stuId}")
	public int deleteStudentById(String stuId);
	
	/**
	 * 更新学生数据（要注意处理传入的ID不能为空）
	 * @param student 学生实体
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Update("update student set("
			+ "student_name=#{student_name},"
			+ "student_password=#{student_password},student_department=#{student_department},"
			+ "student_gender=#{student_gender},student_mail=#{student_mail},"
			+ "student_tel=#{student_tel}"
			+ ") where student_id=#{student_id}")
	public int updateStudent(Student student);
	
	/**
	 * 根据ID查询教师
	 * @param teaId 教师ID
	 * @return 教师实体
	 * @author 逍遥
	 */
	@Select("SELECT * FROM teacher WHERE teacher_id=#{teaId}")
	public Teacher selTeacherById(String teaId);
	
	/**
	 * 查询教师表
	 * @return list对象
	 * @author 逍遥
	 */
	@Select("select * from teacher")
	public List<Teacher> findAllTeacher();
	
	/**
	 * 插入教师数据
	 * @param teacher 教师实体
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Insert("insert into teacher("
			+ "teacher_id,teacher_name,teacher_password,teacher_gender,teacher_mail,teacher_tel"
			+ ") values("
			+ "#{teacher_id},#{teacher_name},#{teacher_password},"
			+ "#{teacher_gender},#{teacher_mail},#{teacher_tel}"
			+ ")")
	public int insertTeacher(Teacher teacher);
	
	/**
	 * 根据ID删除教师
	 * @param teaId 教师ID
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Delete("delete from teacher where teacher_id = #{teaId}")
	public int deleteTeacherById(String teaId);
	
	/**
	 * 更新教师数据（要注意处理传入的ID不能为空）
	 * @param teacher 教师实体
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Update("UPDATE teacher SET "
			+ "teacher_name=#{teacher_name},teacher_password=#{teacher_password},"
			+ "teacher_gender=#{teacher_gender},teacher_mail=#{teacher_mail},"
			+ "teacher_tel=#{teacher_tel}"
			+ " WHERE teacher_id=#{teacher_id}")
	public int updateTeacher(Teacher teacher);
	
	/**
	 * 修改管理员密码
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Update("UPDATE admin SET admin_password=#{admin_password} WHERE admin_id=#{admin_id}")
	public int updAdminPwd(Admin admin);
	
	/**
	 * 根据ID查找管理员
	 * @param admId 管理员ID
	 * @return 管理员实体
	 */
	@Select("SELECT * FROM admin WHERE admin_id=#{admId}")
	public Admin selAdminById(String admId);
	
	/**
	 * 查询课程表中的所有学期，按学期降序（从大到小）
	 * @return 
	 */
	@Select("SELECT DISTINCT course_semester FROM course ORDER BY course_semester DESC")
	public List<String> selAllSemester();
	
	/**
	 * 根据学期查询课程
	 * @param semester 学期
	 * @return list
	 */
	@Select("SELECT * FROM course WHERE course_semester=#{semester}")
	public List<Course> selCourseBySemester(String semester);
	
	/**
	 * 插入课程数据
	 * @param course 课程实体
	 * @return 成功记录数
	 */
	@Insert("INSERT INTO course("
			+ "course_id,course_name,course_teacher,course_credit,course_semester"
			+ ") VALUES("
			+ "#{course_id},#{course_name},#{course_teacher},"
			+ "#{course_credit},#{course_semester}"
			+ ")")
	public int insertCourse(Course course);
	
	/**
	 * 根据ID查询课程
	 * @param courseId 课程ID
	 * @return 课程实体
	 * @author 逍遥
	 */
	@Select("SELECT * FROM course WHERE course_id=#{courseId}")
	public Course selCourseById(int courseId);
	
	/**
	 * 查询所有课程，按学期降序
	 * @return
	 */
	@Select("SELECT * FROM course ORDER BY course_semester DESC")
	public List<Course> selAllCourse();
	
	/**
	 * 根据ID删除课程
	 * @param courseId 课程ID
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Delete("DELETE FROM course where course_id = #{courseId}")
	public int deleteCourseById(int courseId);
	
	/**
	 * 更新课程数据（要注意处理传入的ID不能为空）
	 * @param course 课程实体
	 * @return 成功记录数
	 * @author 逍遥
	 */
	@Update("UPDATE course SET "
			+ "course_name=#{course_name},course_credit=#{course_credit},"
			+ "course_semester=#{course_semester},is_done=#{is_done}"
			+ " WHERE course_id=#{course_id}")
	public int updateCourse(Course course);
	
	/**
	 * 由成绩ID查询成绩
	 * @param grdId 成绩ID
	 * @return 成绩实体
	 */
	@Select("SELECT * FROM grade WHERE grade_id=#{grdId}")
	public Grade selGradeByGradeId(int grdId);
}
