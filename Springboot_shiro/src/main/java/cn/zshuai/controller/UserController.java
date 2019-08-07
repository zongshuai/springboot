package cn.zshuai.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		System.out.println("UserController.hello()");
		return "ok";
	}
	
	/**
	 * 增加用户
	 */
	@RequestMapping("/add")
	public String add(){
		return "user/add";
	}
	/**
	 * 更新用户
	 */
	@RequestMapping("/update")
	public String update(){
		return "user/update";
	}
	
	/**
	 * To登录界面
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 登录逻辑处理
	 */
	@RequestMapping("/login")
	public String login(String name,String password, Model model) {
		/**
		 * 使用shiro编写认证操作
		 */
		//1. 获取Subject
		Subject subject = SecurityUtils.getSubject();
		//2. 封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		//3. 执行登录方法
		try {
			subject.login(token);
			
			//没有异常，代表登陆成功
			//跳转到首页，这里就以test页面为例子
			return "redirect:/thymeleaf";
		} catch (UnknownAccountException e) {
			//代表用户名不存在
			model.addAttribute("msg", "用户名不存在");
			return "login";
		} catch (IncorrectCredentialsException e) {
			// 登录失败：密码错误
			model.addAttribute("msg", "密码错误");
			return "login";
		}
	}
	/**
	 * 测试thymeieaf
	 */
	@RequestMapping("/thymeleaf")
	public String testThymeieaf(Model model) {
		//把数据存入model
		model.addAttribute("name","zshuai");
		//返回到指定的页面(test.html)
		return "test";
		
	}

	

}
