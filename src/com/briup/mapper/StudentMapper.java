package com.briup.mapper;

import java.util.List;

import com.briup.bean.Student;

/**
 * student映射接口
 * @author 26503
 *
 */
public interface StudentMapper {
	//保存学生信息
	public void saveStudent(Student student);
	//查询学生信息
	public Student findStudentById(int id);
	public List<Student> findAllStudents();
	
	//删除学生信息
	public void deleteStudentById(int id);
	//修改学生信息
	public void updateStudentById(Student student);
	
}
