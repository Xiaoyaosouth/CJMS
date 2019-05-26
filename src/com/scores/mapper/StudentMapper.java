package com.scores.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.scores.pojo.*;

public interface StudentMapper {
	
	@Select("select * from student where student_id=#{student_id} and student_password=#{student_password}")
	public Student selStudent(Student student);
	
	/**
	 * 根据学生ID查询学生
	 * @param stuId
	 * @return
	 * @author 逍遥
	 */
	@Select("select * from student where student_id=#{stuId}")
	public Student selStudentById(String stuId);

	/**
	 * 修改学生密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	@Update("UPDATE student SET student_password = #{pwd} WHERE student_id = #{id}")
	public int updStudentPwd(@Param("id") String id,@Param("pwd")String pwd);
}