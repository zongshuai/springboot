## 项目使用h2内存数据库
* 在build.gradle文件中添加依赖:

	runtime ('com.h2database:h2:1.4.192')

* 在application.yml中打开web页面查看h2数据库:

	sprinmg.h2.console.enabled=true

浏览器输入IP+项目端口/h2-console即可查看（默认为mem:testdb数据库）

##  项目使用jpa
* 添加jpa依赖

	// 添加 Spring Data JPA 的依赖
	compile('org.springframework.boot:spring-boot-starter-data-jpa')

* 对应的实体类以及持久层修改
	添加如下注解做到跟数据库表字段对应
	
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
	
## 项目结合hibernate使用MySQL
* 添加对应的依赖
	
	// 添加 MySQL连接驱动 的依赖
	compile('mysql:mysql-connector-java:6.0.5')
	// 自定义  Hibernate 的版本
	ext['hibernate.version'] = '5.2.8.Final'

* application.yml文件配置相应的数据库信息

	spring: 
		datasource:
		    url: jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
		    username: root
		    password: rootzs
		    driver-class-name: com.mysql.cj.jdbc.Driver
		  jpa:
		    show-sql: true
		    # ddl-auto:create----每次运行该程序，没有表格会新建表格，表内有数据会清空,先删除再新建
		    # ddl-auto:create-drop----每次程序结束的时候会清空表
		    # ddl-auto:update----每次运行程序，没有表格会新建表格，表内有数据不会清空，只会更新
		    # ddl-auto:validate----运行程序会校验数据与数据库的字段类型是否相同，不同会报错
		    hibernate:
		      ddl-auto: create-drop 
		      
当yml文件中同时配置了MySQL和h2数据库时候，会优先使用MySQL这种类型的数据库