package com.scores.pojo;

/**
 * 学生实体类
 * @author zhang
 *
 */
public class Student {
	private String student_id;//学号
	private String student_name;//姓名
	private String student_password;//密码
	private String student_department;//班级
	private int student_gender;//性别
	private String student_mail;//邮箱
	private String student_tel;//手机号
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_department() {
		return student_department;
	}
	public void setStudent_department(String student_department) {
		this.student_department = student_department;
	}
	public int getStudent_gender() {
		return student_gender;
	}
	public void setStudent_gender(int student_gender) {
		this.student_gender = student_gender;
	}
	public String getStudent_mail() {
		return student_mail;
	}
	public void setStudent_mail(String student_mail) {
		this.student_mail = student_mail;
	}
	public String getStudent_tel() {
		return student_tel;
	}
	public void setStudent_tel(String student_tel) {
		this.student_tel = student_tel;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_password="
				+ student_password + ", student_department=" + student_department + ", student_gender=" + student_gender
				+ ", student_mail=" + student_mail + ", student_tel=" + student_tel + "]";
	}
	
	
	
}
