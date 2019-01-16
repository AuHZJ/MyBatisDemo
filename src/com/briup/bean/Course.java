package com.briup.bean;

import java.util.Date;

public class Course {
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	/**
	 * 多对一： 多的一方：一个对象
	 */
	private Tutor tutor;

	public Course() {
		super();
	}

	public Course(int id, String name, String description, Date startDate, Date endDate, Tutor tutor) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tutor = tutor;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", tutor=" + tutor + "]";
	}

}
