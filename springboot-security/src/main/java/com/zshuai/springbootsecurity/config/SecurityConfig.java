package com.zshuai.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/** 
* <p>Title: SecurityConfig</p>  
* <p>Description: 安全配置类 </p>  
* @author zshuai
* @date Aug 7, 2019  
*/ 

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/* (non-Javadoc)
	 * 自定义配置
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //都可以访问
			.antMatchers("/users/**").hasRole("ADMIN") //需要相应的角色才能够访问
			.and()
			.formLogin() //基于form表单登录验证
			.loginPage("/login").failureUrl("/login-error"); //自定义登录界面
	}
	
	/**  
	 * <p>Title: configureGlobal</p>  
	 * <p>Description: 认证信息管理 </p>  
	 * @param auth
	 * @throws Exception  
	 */  
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication() //认证信息存储在内存中
				.withUser("zshuai").password("123").roles("ADMIN");
		
	}
}
