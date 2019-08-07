package com.zshuai.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zshuai.shiro.dao.UserDao;
import com.zshuai.shiro.entity.SysUser;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;

	// 执行授权逻辑
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		return null;
	}

	// 执行认证逻辑
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		// 编写shiro判断逻辑，判断用户名和密码
		// 1.判断用户名
		UsernamePasswordToken tokens = (UsernamePasswordToken) token;
		SysUser user = userDao.findUserInfoByUserName(tokens.getUsername());
		System.out.println(user+"====");
		if (user== null || !tokens.getUsername().equals(user.getUserName())) {
			// 用户名不存在
			return null;// shiro底层会抛出UnKnowAccountException
		}
		// 2.判断密码
		return new SimpleAuthenticationInfo(user, user.getUserPassword(), "");

	}

}
