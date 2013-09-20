package com.pl.mytest.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.pl.mytest.entity.User;

@MapperScan("addressDao")
public interface UserDao {
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long uid);
	/**
	 * @param likeCondition
	 * @param page
	 * @return
	 */
	public List<User> getAllUser(Map<String,Object> likeCondition);
	public User getUser(Long uid);
}
