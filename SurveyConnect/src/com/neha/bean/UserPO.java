package com.neha.bean;

import java.io.Serializable;

public class UserPO implements Serializable {
	private String email;
	private String password;
	private String repeatPassword;
	private String accountType;
	private String department;
	private String position;
	private String major;
	private String gradYear;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGradYear() {
		return gradYear;
	}
	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}
	@Override
	public String toString() {
		return "UserPO [email=" + email + ", password=" + password + ", repeatPassword=" + repeatPassword
				+ ", accountType=" + accountType + ", department=" + department + ", position=" + position + ", major="
				+ major + ", gradYear=" + gradYear + "]";
	}
	
	
	
}
