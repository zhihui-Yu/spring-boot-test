package com.pojo;

public class Users {
	private String name;
	private String password;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String name, String password, Integer age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
}
