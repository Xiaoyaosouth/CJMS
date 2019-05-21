package com.scores.pojo;

/**
 * 成绩实体类
 * @author zhang
 *
 */
public class Grade {
	private String grade_id;//成绩编号
	private String grade_course;//课程编号
	private String grade_student;//学号
	private int grade_fraction;//分数
	private int grade_semester;//学期
	private Student student;//学生
	public String getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}
	public String getGrade_course() {
		return grade_course;
	}
	public void setGrade_course(String grade_course) {
		this.grade_course = grade_course;
	}
	public String getGrade_student() {
		return grade_student;
	}
	public void setGrade_student(String grade_student) {
		this.grade_student = grade_student;
	}
	public int getGrade_fraction() {
		return grade_fraction;
	}
	public void setGrade_fraction(int grade_fraction) {
		this.grade_fraction = grade_fraction;
	}
	public int getGrade_semester() {
		return grade_semester;
	}
	public void setGrade_semester(int grade_semester) {
		this.grade_semester = grade_semester;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Grade [grade_id=" + grade_id + ", grade_course=" + grade_course + ", grade_student=" + grade_student
				+ ", grade_fraction=" + grade_fraction + ", grade_semester=" + grade_semester +", student=" + student + "]";
	}
	
	
}
