package com.zshuai.shiro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zshuai.shiro.entity.SysUser;

public interface UserDao extends JpaRepository<SysUser, Long> {
	SysUser findUserInfoByUserName(String name);

}
