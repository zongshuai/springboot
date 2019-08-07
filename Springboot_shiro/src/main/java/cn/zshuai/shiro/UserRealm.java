package cn.zshuai.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zshuai.entity.SysUser;
import cn.zshuai.service.UserService;

public class UserRealm extends AuthorizingRealm {

	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("执行授权逻辑");
		// 给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		// 添加资源的授权字符串
		//info.addStringPermission("add");
		//到数据库查询当前登录用户的授权字符串
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		SysUser user = (SysUser)subject.getPrincipal();
		if (user.getUserName().equals("admin")) {
			//管理员，赋予全部权限
			info.addStringPermission("add");
			info.addStringPermission("update");
		}else {
			SysUser dbUser = userSerivce.findById(user.getUserId());
			
			info.addStringPermission(dbUser.getUserCode());
		}
		return info;
	}

	/**
	 * 执行认证逻辑
	 */
	@Autowired
	private UserService userSerivce;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("执行认证逻辑");
		// 1. 编写shiro判断逻辑，判断用户名和密码
		UsernamePasswordToken pojo = (UsernamePasswordToken) token;
		List<SysUser> userList = userSerivce.findByName(pojo.getUsername());
		if (userList.size() == 0) {
			// 用户名字不存在
			return null;// shiro底层会抛出UnKnowAccountException

		}
		// 2. 判断密码 空参即可
		return new SimpleAuthenticationInfo(userList.get(0), userList.get(0).getUserPassword(), "");
	}

}
