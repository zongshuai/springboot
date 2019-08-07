package cn.zshuai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zshuai.entity.SysUser;
import cn.zshuai.entity.SysUserExample;
import cn.zshuai.entity.SysUserExample.Criteria;
import cn.zshuai.mapper.SysUserMapper;
import cn.zshuai.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	//注入mapper
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public List<SysUser> findByName(String name) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(name);
		List<SysUser> userList = userMapper.selectByExample(example);
		return userList;
	}

	@Override
	public SysUser findById(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

}
