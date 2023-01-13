package com.fuse.bo;


public class Fuse_Encapsulation {
	private int loginId;
	
	private String name;
	private String country;
	private String birthday;
	private String gender;
	private String emailId;
	private String pwd;
	private String hobbies;
	
	
		//setter and getter
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	
	 //toString()
	@Override
	public String toString() {
		return "Fuse_Encapsulation [loginId=" + loginId + ", name=" + name + ", country=" + country + ", birthday="
				+ birthday + ", gender=" + gender + ", emailId=" + emailId + ", pwd=" + pwd + ", hobbies=" + hobbies
				+ "]";
	}
	
	

}//class
