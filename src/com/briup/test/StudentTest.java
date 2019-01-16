package com.briup.test;

import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.bean.PhoneNumber;
import com.briup.bean.Student;
import com.briup.mapper.StudentMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class StudentTest {
	
	//��ȡsqlSessionFactory����
	SqlSessionFactory factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	//��ȡsqlSession����
	SqlSession sqlSession = factory.openSession();
	
	//��ȡִ�з����Ķ���----�ӿڵ�ʵ�������
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

	@Test
	public void before() {
		System.out.println("in before");
	}
	
	@Test
	public void middle() {
		System.out.println("in middle");
	}
	
	@Test
	public void after() {
		System.out.println("in after");
	}
	
	@Test
	public void test_insert() throws Exception {
		String resource = "mybatis-config.xml"; 
		Reader reader = Resources.getResourceAsReader(resource); 
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader); 
		
		SqlSession session = factory.openSession();
		
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		
		try {
			
			Student student = new Student();
			student.setName("����");
			student.setEmail("1234567@qq.com");
			student.setDob(new Date());
			//�ȹ���PhoneNumber����
			PhoneNumber phone = new PhoneNumber("021-3859-7763");
			student.setPhone(phone);
			
			mapper.saveStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.commit();
	}
	
	@Test
	public void test_select() throws Exception {
		try {
			Student student = studentMapper.findStudentById(1);
			System.out.println(student);
			
			Student student2 = studentMapper.findStudentById(1);
			System.out.println(student2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void test_selectAll() throws Exception {
		//���÷���
		List<Student> students = studentMapper.findAllStudents();
		//��������
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void test_delete() throws Exception {
		studentMapper.deleteStudentById(1001);
		sqlSession.commit();
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void test_update() throws Exception {
		Student student = new Student();
		student.setId(3);
		student.setName("��˹");
		student.setEmail("lisi@qq.com");
		student.setDob(new Date());
		student.setPhone(new PhoneNumber("011-1234-2234"));
		
		studentMapper.updateStudentById(student);
		sqlSession.commit();
	}
}
