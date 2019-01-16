package com.briup.mapper;

import java.util.List;
import java.util.Map;

import com.briup.bean.Course;

public interface DynamicSqlMapper {
	
	List<Course> searchCourses(Map<String, Object> map);
	
	List<Course> searchCoursesByTutors(Map<String, Object> map);
	
	void updateCourse(Course course);
	
}
