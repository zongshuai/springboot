package com.zshuai.springbppt.thymeleaf.dao;

import java.util.List;

import com.zshuai.springbppt.thymeleaf.domain.User;

public interface UserDao {

	
	/**  
	 * <p>Title: saveOrUpdateUser</p>  
	 * <p>Description:新增或修改用户 </p>  
	 * @param user
	 * @return  
	 */  
	User saveOrUpdateUser(User user);
	
	/**  
	 * <p>Title: deleteUser</p>  
	 * <p>Description: 删除用户</p>  
	 * @param id  
	 */  
	void deleteUser(Long id );
	
	/**  
	 * <p>Title: getUserById</p>  
	 * <p>Description: 根据ID获取用户 </p>  
	 * @param id
	 * @return  
	 */  
	User getUserById(Long id);
	
	/**  
	 * <p>Title: listUser</p>  
	 * <p>Description: 获取所有用户列表</p>  
	 * @return  
	 */  
	List<User> listUser();
}
