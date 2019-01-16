package com.briup.mapper;

import java.util.List;

import com.briup.bean.Student;

/**
 *  一对一
 * @author 26503
 *
 */
public interface StudentAndAddressMapper {
	
	//通过id查询学生信息
	public Student findStudentAndAddressById(int id);
	//查询所有的学生信息
	public List<Student> findAllStudents();
}
