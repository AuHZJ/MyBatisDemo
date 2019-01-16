package com.briup.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.many2many.Course;
import com.briup.many2many.Student;

public interface Many2ManyMapper {
	
	//保存student信息
	public void saveStudent(Student student);
	//保存course信息
	public void saveCourse(Course course);
	
	//通过Id查询student 
	public Student findStudentById(int id);
	//通过Id查询course
	public Course findCourseById(int id);
	
	//学生选课
	//1.传参有多个，默认参数据列表(param1,param2,......)
	//2.使用注解
	public void studentSelectCourse(@Param("student") Student student,@Param("course") Course course);
	
	//通过Id 查询学生完整信息---包括选课信息
	public Student findStudentAndCourseById();
	
	//查询所有学生对应的所有课程
	public List<Student> findAllStudentAndCourse();
}
