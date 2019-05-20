package com.scores.mapper;

import org.apache.ibatis.annotations.Select;

import com.scores.pojo.*;

public interface StudentMapper {
	
	@Select("select * from student where student_id=#{student_id} and student_password=#{student_password}")
	public Student selStudent(Student student);
}