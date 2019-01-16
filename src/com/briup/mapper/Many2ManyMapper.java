package com.briup.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.many2many.Course;
import com.briup.many2many.Student;

public interface Many2ManyMapper {
	
	//����student��Ϣ
	public void saveStudent(Student student);
	//����course��Ϣ
	public void saveCourse(Course course);
	
	//ͨ��Id��ѯstudent 
	public Student findStudentById(int id);
	//ͨ��Id��ѯcourse
	public Course findCourseById(int id);
	
	//ѧ��ѡ��
	//1.�����ж����Ĭ�ϲ������б�(param1,param2,......)
	//2.ʹ��ע��
	public void studentSelectCourse(@Param("student") Student student,@Param("course") Course course);
	
	//ͨ��Id ��ѯѧ��������Ϣ---����ѡ����Ϣ
	public Student findStudentAndCourseById();
	
	//��ѯ����ѧ����Ӧ�����пγ�
	public List<Student> findAllStudentAndCourse();
}
