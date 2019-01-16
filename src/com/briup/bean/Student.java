package com.briup.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * ѧ����
 * @author 26503
 * com.briup.bean.Student@
 */

public class Student extends Object implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * ���
	 */
	private int id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ����
	 */
	private String email;
	/**
	 * ����
	 */
	private Date dob;
	/**
	 * �绰����
	 */
	private PhoneNumber phone;
	
	/**
	 * ������ϵ�� һ��һ
	 */
	private Address address;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String email, Date dob, PhoneNumber phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone=" + phone
				+ ", address=" + address + "]";
	}


/*	public static void main(String[] args) {
		Student student = new Student();
		student.setId(1001);
		student.setName("����");
		//byte short int long float double char boolean
		//String
		System.out.println(student);
		System.out.println(student.toString());
	}*/
}
