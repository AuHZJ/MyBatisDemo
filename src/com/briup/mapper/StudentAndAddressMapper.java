package com.briup.mapper;

import java.util.List;

import com.briup.bean.Student;

/**
 *  һ��һ
 * @author 26503
 *
 */
public interface StudentAndAddressMapper {
	
	//ͨ��id��ѯѧ����Ϣ
	public Student findStudentAndAddressById(int id);
	//��ѯ���е�ѧ����Ϣ
	public List<Student> findAllStudents();
}
