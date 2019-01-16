package com.briup.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.briup.bean.Course;
import com.briup.bean.Tutor;
import com.briup.mapper.One2ManyMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class One2ManyTest {

	@Test
	public void test_findTutorById() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		
		One2ManyMapper mapper = session.getMapper(One2ManyMapper.class);
		Tutor tutor = mapper.findTutorById(2);
		System.out.println(tutor);
	}
	
	@Test
	public void test_findCourseById() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		
		One2ManyMapper mapper = session.getMapper(One2ManyMapper.class);
		Course course = mapper.findCourseById(1);
		System.out.println(course);
	}
	
}
