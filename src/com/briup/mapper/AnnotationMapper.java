package com.briup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.briup.annotation.Person;

public interface AnnotationMapper {
	
	
	@Insert("insert into person(id,name,age) values(#{id},#{name},#{age})")
	public void insertPerson(Person person);
	
	@Insert("insert into person(id,name,age) values(#{id},#{name},#{age})")
	@SelectKey(statement="select my_seq.nextval from dual",resultType=int.class,keyProperty="id",before=true)
	public void insertPersonAutoId(Person person);
	
	@Update("update person set name=#{name},age=#{age} where id=#{id}")
	public void updatePerson(Person person);
	
	@Delete("delete from person where id=#{id}")
	public void deletePersonById(Integer id);
	
	@Select("select id,name,age from person where id=#{id}")
	public Person findPersonById(Integer id);
	
	@Select("select id,name,age from person")
	public List<Person> findAllPerson();
	
	
	@Select("select id as pid,name,age from person")
	@Results({
		@Result(id=true,property="id",column="pid"),
		@Result(property="name",column="name"),
		@Result(property="age",column="age")
	})
	public List<Person> findAllPerson_ResultMap();
	
	
	@Select("select id as pid,name,age from person")
	@ResultMap("com.briup.mapper.AnnotationMapper.PersonResult")
	public List<Person> findAllPerson_ResultMap_xml();
}
