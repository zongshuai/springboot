package com.zshuai.springbppt.thymeleaf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.zshuai.springbppt.thymeleaf.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	//原子类，保证ID唯一性
	private static AtomicLong counter = new AtomicLong();
	
	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();
	
	
	public UserDaoImpl() {
		User user = new User();
		user.setAge(24);
		user.setName("zshuai");
		this.saveOrUpdateUser(user);
	}
	@Override
	public User saveOrUpdateUser(User user) {
		Long id = user.getId();
		if (id <= 0 ){
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		this.userMap.remove(id);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userMap.get(id);
	}

	@Override
	public List<User> listUser() {
		return new ArrayList<User>(this.userMap.values());
	}

}
