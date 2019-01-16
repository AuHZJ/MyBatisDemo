package com.briup.bean;

import java.util.Collection;

public class Tutor {
	private int id;
	private String name;
	private String email;
	private PhoneNumber phone;
	/**
	 * 一对一
	 */
	private Address address;

	/**
	 * 一对多：一的一方：对象集合
	 */
	
	private Collection<Course> courses;
	
	public Tutor() {
		super();
	}

	public Tutor(int id, String name, String email, PhoneNumber phone, Address address, Collection<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.courses = courses;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", courses=" + courses + "]";
	}


}
