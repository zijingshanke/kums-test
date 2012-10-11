package com.kurui.test.ibatis;

import java.io.Serializable;

public class IBatis implements Serializable {

	private static final long serialVersionUID = 4054639727225043549L;
	private int id;
	private String name;
	private int age;

	public IBatis() {
		super();
	}

	public IBatis(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return id + " " + name + " " + age;
	}
}
