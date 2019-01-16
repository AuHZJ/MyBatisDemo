package com.briup.mapper;

import java.util.List;

import com.briup.bean.Student;

/**
 * studentӳ��ӿ�
 * @author 26503
 *
 */
public interface StudentMapper {
	//����ѧ����Ϣ
	public void saveStudent(Student student);
	//��ѯѧ����Ϣ
	public Student findStudentById(int id);
	public List<Student> findAllStudents();
	
	//ɾ��ѧ����Ϣ
	public void deleteStudentById(int id);
	//�޸�ѧ����Ϣ
	public void updateStudentById(Student student);
	
}
