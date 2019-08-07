package cn.zshuai.service;

import java.util.List;

import cn.zshuai.entity.SysUser;

public interface UserService {
	
	public List<SysUser> findByName(String name);

	public SysUser findById(Long userId);

}
