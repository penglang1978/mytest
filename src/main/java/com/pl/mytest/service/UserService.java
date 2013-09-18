package com.pl.mytest.service;

import java.util.List;
import java.util.Map;

import com.pl.mytest.entity.User;

public interface UserService {
	public User insertUser(User user);
	public void deleteUser(Long uid);
	public void updateUser(User user);
	
	public List<User> getAllUser(Integer page, Integer pageCount);
	public List<User> getUserNeeded(Map<String, Object> likeCondition);
	public User getOneUser(Long uid);
}
