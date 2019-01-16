package com.briup.mapper;

import com.briup.bean.Course;
import com.briup.bean.Tutor;

public interface One2ManyMapper {
	
	//通过Id查询导师信息
	public Tutor findTutorById(int id);
	
	//通过Id查询课程信息
	public Course findCourseById(int id);
}
