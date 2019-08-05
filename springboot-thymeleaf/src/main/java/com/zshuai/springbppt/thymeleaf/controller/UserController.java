package com.zshuai.springbppt.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zshuai.springbppt.thymeleaf.dao.UserDao;
import com.zshuai.springbppt.thymeleaf.domain.User;


/** 
* <p>Title: UserController</p>  
* <p>Description: 用户控制器 </p>  
* @author zshuai
* @date Aug 1, 2019  
*/  
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	/**  
	 * <p>Title: getUserlist</p>  
	 * <p>Description: 获取用户列表</p>  
	 * @return  
	 */  
	private List<User> getUserlist(){
		return userDao.listUser();
	}
	
	/**  
	 * <p>Title: list</p>  
	 * <p>Description: 查询所有用户</p>  
	 * @param model
	 * @return  
	 */  
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList",getUserlist());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("user/list","userModel",model);
	}
	
	/**  
	 * <p>Title: view</p>  
	 * <p>Description: 根据ID查询用户 </p>  
	 * @param id
	 * @param model
	 * @return  
	 */  
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id,Model model) {
		User user = userDao.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("user/view", "userModel",model);
	}
	
	/**  
	 * <p>Title: createForm</p>  
	 * <p>Description: 获取form表单</p>  
	 * @param model
	 * @return  
	 */  
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "创建用户");
		return new ModelAndView("user/form", "userModel",model);
	}
	
	/**  
	 * <p>Title: create</p>  
	 * <p>Description: 创建用户</p>  
	 * @param user
	 * @return  
	 */  
	@PostMapping
	public ModelAndView create(User user) {
 		user = userDao.saveOrUpdateUser(user);
		return new ModelAndView("redirect:/users");
	}

	
	/**  
	 * <p>Title: delete</p>  
	 * <p>Description: 删除用户</p>  
	 * @param id
	 * @param model
	 * @return  
	 */  
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userDao.deleteUser(id);
 
		model.addAttribute("userList", getUserlist());
		model.addAttribute("title", "删除用户");
		return new ModelAndView("user/list", "userModel", model);
	}

	
	/**  
	 * <p>Title: modifyForm</p>  
	 * <p>Description: 修改用户</p>  
	 * @param id
	 * @param model
	 * @return  
	 */  
	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		User user = userDao.getUserById(id);
 
		model.addAttribute("user", user);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("user/form", "userModel", model);
	}

}
