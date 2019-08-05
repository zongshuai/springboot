package com.zshuai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zshuai.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/add")
	public  String addUser() {
		try {
			userService.addUser();
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "fasle";
		}
		
	}
}
