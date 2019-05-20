package com.scores.mapper;

import org.apache.ibatis.annotations.Select;

import com.scores.pojo.*;

public interface TeacherMapper {
	
	@Select("select * from teacher where teacher_id=#{teacher_id} and teacher_password=#{teacher_password}")
	public Teacher selTeacher(Teacher teacher);
}
