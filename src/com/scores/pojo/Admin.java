package com.scores.pojo;

/**
 * 管理员实体类
 * @author zhang
 *
 */
public class Admin {
	private String admin_id;//管理员工号
	private String admin_name;//姓名
	private String admin_password;//密码
	private int admin_gender;//性别
	private String admin_mail;//邮箱
	private String admin_tel;//手机号
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public int getAdmin_gender() {
		return admin_gender;
	}
	public void setAdmin_gender(int admin_gender) {
		this.admin_gender = admin_gender;
	}
	public String getAdmin_mail() {
		return admin_mail;
	}
	public void setAdmin_mail(String admin_mail) {
		this.admin_mail = admin_mail;
	}
	public String getAdmin_tel() {
		return admin_tel;
	}
	public void setAdmin_tel(String admin_tel) {
		this.admin_tel = admin_tel;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_password=" + admin_password
				+ ", admin_gender=" + admin_gender + ", admin_mail=" + admin_mail + ", admin_tel=" + admin_tel + "]";
	}
	
}
