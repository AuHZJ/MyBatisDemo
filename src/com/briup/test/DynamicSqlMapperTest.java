package com.briup.test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Course;
import com.briup.mapper.DynamicSqlMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class DynamicSqlMapperTest {
	
	@Test
	public void test_searchCourses_if(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("id", 1); 
//			map.put("courseName", "%Java%"); 
//			map.put("courseName", null); 
			map.put("startDate", new Date()); 
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_searchCourses_choose(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("tutorId", 1); 
			map.put("courseName", "%Java%"); 
			map.put("startDate", new Date()); 
			map.put("searchBy", "Tutor");
			map.put("searchBy", "CourseName");
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_searchCourses_where(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("tutorId", 1); 
			map.put("courseName", "%Java%"); 
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void test_searchCourses_trim(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("tutorId", 1); 
			map.put("courseName", "%Java%"); 
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	
	@Test
	public void test_searchCourses_foreach(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			
			
			map.put("tutorIds", Arrays.asList(1,3,2));
			
			List<Course> list = mapper.searchCoursesByTutors(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void test_searchCourses_set(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Course course = new Course();
			course.setId(3);
		//	course.setName("SpringCloud");
			course.setDescription("Spring生态圈最难的一部分");
			
			mapper.updateCourse(course);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
}
