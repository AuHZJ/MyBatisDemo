package com.briup.mapper;

import com.briup.bean.Course;
import com.briup.bean.Tutor;

public interface One2ManyMapper {
	
	//ͨ��Id��ѯ��ʦ��Ϣ
	public Tutor findTutorById(int id);
	
	//ͨ��Id��ѯ�γ���Ϣ
	public Course findCourseById(int id);
}
