package com.zshuai.springbppt.thymeleaf.dao;


import org.springframework.data.repository.CrudRepository;

import com.zshuai.springbppt.thymeleaf.domain.User;

public interface UserDao extends CrudRepository<User, Long> {

}
