package com.scores.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
	 * @param student
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
	 * 查询教师表
	 * @return list对象
	 * @author 逍遥
	 */
	@Select("select * from teacher")
	public List<Student> findAllTeacher();
	
}
