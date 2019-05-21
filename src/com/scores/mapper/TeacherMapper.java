package com.scores.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.scores.pojo.*;

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
	
}
