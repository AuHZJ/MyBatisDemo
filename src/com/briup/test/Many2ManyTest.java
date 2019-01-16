package com.briup.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.briup.many2many.Course;
import com.briup.many2many.Student;
import com.briup.mapper.Many2ManyMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class Many2ManyTest {


	@Test
	public void test_saveStudent() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		
		Student stu = new Student();
		//stu.setId(1);
		stu.setName("李斯");
		stu.setGender("男");
		stu.setMajor("政治");
		stu.setGrade("大一");
		mapper.saveStudent(stu);
		
		session.commit();
		
	}
	
	@Test
	public void test_saveCourse() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		
		Course course = new Course(null,"1004E","SpringCloud",null);
		
		mapper.saveCourse(course);
		session.commit();
		
	}

	@Test
	public void test_findStudentById() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		
		Student student = mapper.findStudentById(15);
		System.out.println(student);
		
		Course course = mapper.findCourseById(18);
		System.out.println(course);
	}

	@Test
	public void test_studentSelectCourse() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		
		Student student = mapper.findStudentById(15);
		Course course = mapper.findCourseById(24);
		
		mapper.studentSelectCourse(student, course);
		
		session.commit();
	}

	@Test
	public void test_findAll() {
		SqlSessionFactory sessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		
		Student student = mapper.findStudentAndCourseById();
		System.out.println(student);
	}

}
