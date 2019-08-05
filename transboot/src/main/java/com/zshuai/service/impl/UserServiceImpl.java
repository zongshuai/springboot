package com.zshuai.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zshuai.TransbootApplication;
import com.zshuai.dao.UserInfoMapper;
import com.zshuai.pojo.UserInfo;
import com.zshuai.service.UserService;

@Component //@service都可以
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserInfoMapper userMapper;

	@Transactional
	public void addUser() {
		try {
			UserInfo pojo = new UserInfo();
			pojo.setUid(1);
			pojo.setName("zshuai");
			pojo.setPassword("aaaaaaa");
			pojo.setSex(1);
			pojo.setAddress("北京市海淀区");
			userMapper.insert(pojo);
			System.out.println("插入完毕");
			int i = 1 / 0;
			UserInfo entity = userMapper.selectByPrimaryKey(1);
			System.out.println(entity.getName() + "查询的名字");
		} catch (Exception e) {
			logger.info("出现异常", e);
			throw new RuntimeException("除数为0");
		}

	}

}
