package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.annotation.Person;
import com.briup.mapper.AnnotationMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class AnnotationMapperTest {
	

	@Test
	public void test_insertPerson(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			Person person = new Person(1,"tom1",20);
			mapper.insertPerson(person);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_insertPersonAutoId(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			Person person = new Person("tom2",25);
			mapper.insertPersonAutoId(person);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_updatePerson(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			Person person = new Person(52,"zs",40);
			mapper.updatePerson(person);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void test_deletePersonById(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			mapper.deletePersonById(53);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void test_findPersonById(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			Person person = mapper.findPersonById(1);
			
			System.out.println(person);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void test_findAllPerson(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			List<Person> list = mapper.findAllPerson();
			for(Person p:list){
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_findAllPerson_ResultMap(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			List<Person> list = mapper.findAllPerson_ResultMap();
			for(Person p:list){
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_findAllPerson_ResultMap_xml(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
			
			List<Person> list = mapper.findAllPerson_ResultMap_xml();
			for(Person p:list){
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
}
