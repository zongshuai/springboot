package com.zshuai.springbootelastic.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/*@Document注解作用在类上，标记实体类为文档对象，常用属性如下：
（1）indexName：对应索引库名称；
（2）type：对应在索引库中的类型；
（3）shards：分片数
（4）replicas：副本数；*/

@Document(indexName = "blog" , type = "blog", shards =1, replicas =0, refreshInterval ="-1")
public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;//用户唯一标识
	
	private String title;
	
	private String content;
	
	protected  Blog() { //JPA 的规范要求无参构造函数；设为protected防止直接使用
	}
	
	public Blog( String title, String content) {
		this.title = title;
		this.content = content;
	}

	public Blog(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
