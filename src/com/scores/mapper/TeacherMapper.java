package com.scores.mapper;

import org.apache.ibatis.annotations.Select;

import com.scores.pojo.*;

public interface TeacherMapper {
	
	@Select("select * from teacher where teacher_id=#{teacher_id} and teacher_password=#{teacher_password}")
	public Teacher selTeacher(Teacher teacher);
	
	/**
	 * 根据ID查询教师
	 * @param stuId
	 * @return
	 * @author 逍遥
	 */
	@Select("select * from teacher where teacher_id=#{teaId}")
	public Teacher selTeacherById(String teaId);
}
