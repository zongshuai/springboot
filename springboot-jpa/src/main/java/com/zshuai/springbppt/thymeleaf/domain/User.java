package com.zshuai.springbppt.thymeleaf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serializableUID = 1L;
	
	@Id //主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
	private long id; // 用户的唯一标识
	
	@Column(nullable = false)  //映射字段，值不可为空
 	private String name;
	
	@Column(nullable = false)
	private int age;

	protected User() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用 
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
}