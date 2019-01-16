package com.briup.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Student;
import com.briup.mapper.StudentMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class CacheTest {
	
	//测试mybatis缓存  一级缓存
	@Test
	public void test_cache1(){
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
			Student student = mapper.findStudentById(1);
			System.out.println(student);
			
			session.commit();
			
			Student student2 = mapper.findStudentById(1);
			System.out.println(student2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//测试mybatis缓存  二级缓存
	@Test
	public void test_cache2(){
		SqlSession session1 = null;
		SqlSession session2 = null;
		try {
			session1 = MyBatisSqlSessionFactory.openSession();
			session2 = MyBatisSqlSessionFactory.openSession();
			
			StudentMapper mapper1 = session1.getMapper(StudentMapper.class);
			StudentMapper mapper2 = session2.getMapper(StudentMapper.class);
			
			Student student = mapper1.findStudentById(1);
			System.out.println(student);
			
			session1.commit();
			
			Student student2 = mapper2.findStudentById(1);
			System.out.println(student2);
			session2.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session1!=null)session1.close();
			if(session2!=null)session2.close();
		}
	}
}

