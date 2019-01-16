package com.briup.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.briup.bean.Student;
import com.briup.mapper.StudentAndAddressMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class One2OneTest {

	@Test
	public void test_findStudentAndAddressById() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		
		StudentAndAddressMapper mapper = session.getMapper(StudentAndAddressMapper.class);
		Student stu = mapper.findStudentAndAddressById(2);
		System.out.println(stu);
	}
	
}
