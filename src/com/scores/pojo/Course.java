package com.scores.pojo;

/**
 * 课程实体类
 * @author zhang
 *
 */
public class Course {
	private int course_id;//课程编号
	private String course_name;//课程名
	private String course_teacher;//教师
	private int course_credit;//学分
	private int course_semester;//学期
	private boolean is_done;//是否录入完成
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_teacher() {
		return course_teacher;
	}
	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}
	public int getCourse_credit() {
		return course_credit;
	}
	public void setCourse_credit(int course_credit) {
		this.course_credit = course_credit;
	}
	public int getCourse_semester() {
		return course_semester;
	}
	public void setCourse_semester(int course_semester) {
		this.course_semester = course_semester;
	}
	
	public boolean isIs_done() {
		return is_done;
	}
	public void setIs_done(boolean is_done) {
		this.is_done = is_done;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_teacher=" + course_teacher
				+ ", course_credit=" + course_credit + ", course_semester=" + course_semester + ", is_done=" + is_done +"]";
	}
	
	
}
