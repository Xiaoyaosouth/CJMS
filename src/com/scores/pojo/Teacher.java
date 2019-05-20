package com.scores.pojo;

/**
 * 教师实体类
 * @author zhang
 *
 */
public class Teacher {
	private String teacher_id;//教师工号
	private String teacher_name;//姓名
	private String teacher_password;//密码
	private int teacher_gender;//性别
	private String teacher_mail;//邮箱
	private String teacher_tel;//手机号
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_password() {
		return teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}
	public int getTeacher_gender() {
		return teacher_gender;
	}
	public void setTeacher_gender(int teacher_gender) {
		this.teacher_gender = teacher_gender;
	}
	public String getTeacher_mail() {
		return teacher_mail;
	}
	public void setTeacher_mail(String teacher_mail) {
		this.teacher_mail = teacher_mail;
	}
	public String getTeacher_tel() {
		return teacher_tel;
	}
	public void setTeacher_tel(String teacher_tel) {
		this.teacher_tel = teacher_tel;
	}
	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_password="
				+ teacher_password + ", teacher_gender=" + teacher_gender + ", teacher_mail=" + teacher_mail
				+ ", teacher_tel=" + teacher_tel + "]";
	}
	
	
	
}
