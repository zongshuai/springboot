package com.zshuai.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zshuai.shiro.realm.UserRealm;

@Configuration
public class ShiroConfig {
	/**
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 添加Shiro内置过滤器
		/**
		 * Shiro内置过滤器，可以实现权限相关的拦截器 常用的拦截器：
		 * anon: 无需认证（登录）就可以访问 ;
		 * authc: 必须认证才可以进行访问 ;
		 * user:  如果使用rememberMe的功能可以直接访问 ;
		 * perms:该资源必须得到资源权限才可以访问 ;
		 * role:该资源必须得到角色权限才可以访问
		 */
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		// 拦截的都是请求路径，并不是直接拦截资源位置
		filterMap.put("/thymeleaf", "anon");// 不拦截
		// 放行login.html页面
		filterMap.put("/login", "anon");
		filterMap.put("/*", "authc");// 拦截所有请求
		// 两种拦截形式
		shiroFilterFactoryBean.setLoginUrl("/toLogin");// 被拦截后的跳转路径
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	/**
	 * 创建DefaultWebSecurityManager
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	/**
	 * 创建Realm
	 */
	@Bean(name = "userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
}
