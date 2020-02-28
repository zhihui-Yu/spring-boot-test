package com.yzh.pojo;

public class Users {
	private String name;
	private String pass;
	private int age;
	public Users(String name, String pass, int age) {
		super();
		this.name = name;
		this.pass = pass;
		this.age = age;
	}
/*	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
