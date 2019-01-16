package com.briup.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.briup.special.User;
import com.briup.special.UserPic;

public interface SpecialMapper {
	public void insertUser(User user);
	
	public User findUserById_test(Integer id);
	
	public void insertUserPic(UserPic userPic);
	
	public UserPic getUserPicById(Integer id);
	
	public List<User> findAllUsers();
	
	public List<User> findAllUsers(RowBounds rowBounds);
	
	public User findUserById(Integer id);
}
