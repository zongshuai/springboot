package com.zshuai.springbootsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.zshuai.springbootsecurity.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
