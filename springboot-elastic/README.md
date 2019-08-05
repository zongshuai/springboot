# SpringBoot使用spring-boot-starter-data-elasticsearch操作elastic2.4版本
Elasticsearch是一个基于Lucene的搜索服务器。
它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。
<br>SpringBoot整合elastic主要两种方法
* ① 经过 SpringData 封装过的，直接在 dao 接口继承 ElasticsearchRepository 即可

```
	BlogRepository extends ElasticsearchRepository<Blog, String>
```

&nbsp;&nbsp;&nbsp;&nbsp;参数：1.实体；2.主键类型
* ② 经过 Spring 封装过的，直接在 Service/Controller 中引入该 bean 即可

```
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
```

### 依赖包注入
唯一比较需要注意的地方就是springboot与elasticsearch的版本对应关系<br>
以及使用的是spring-boot-starter-data-elasticsearch还是spring-data-elasticsearch及版本:

```
	//添加log4j2依赖
	compile('org.springframework.boot:spring-boot-starter-log4j2:1.5.2.RELEASE')
	// 添加  Spring Data Elasticsearch 的依赖
	compile('org.springframework.boot:spring-boot-starter-data-elasticsearch')
	//compile('org.springframework.data:spring-data-elasticsearch:3.1.3.RELEASE')
	// 添加  JNA 的依赖 ，集成es需要这个依赖，不然会报classNotfound错误
	compile('net.java.dev.jna:jna:4.3.0')
```

### application配置

```
	server:
  	 port: 1996 
	logging:
  	 config: classpath:log4j2-spring.xml
	spring:
  	 data:
    	  elasticsearch:
			    # elastic的节点名字
      	 	cluster-name: elastic2.4
      	 	# elastic的节点IP地址
      	 	cluster-nodes: 192.168.32.154:9300
```

### 数据持久层

```
package com.zshuai.springbootelastic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zshuai.springbootelastic.entity.Blog;

public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
	
	Page<Blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);

}

```
重点就是继承以及方法书写。

### Controller直接调用

```
package com.zshuai.springbootelastic.controller;
@RestController
@RequestMapping("/blogs")
public class BlogController {

	public final static Logger logger = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	private BlogRepository blogRepository;

	@RequestMapping("/create")
	public void createBlogs() {
		
		blogRepository.save(new Blog("1", "寻隐者不遇", "松下问童子，言师采药去。只在此山中，云深不知处。"));

		blogRepository.save(new Blog("2", "送方外上人", "孤云将野鹤，岂向人间住。莫买沃洲山，时人已知处。"));

		blogRepository.save(new Blog("3", "九月九日忆山东兄弟", "独在异乡为异客，每逢佳节倍思亲。遥知兄弟登高处，遍插茱萸少一人。"));

		blogRepository.save(new Blog("4", " 送崔九", "归山深浅去，须尽丘壑美。莫学武陵人，暂游桃源里。"));
		logger.info("插入结束===");
		
	}
	@GetMapping("list")
	public List<Blog> list(@RequestParam(value="title",required=false,defaultValue="") String title,
			@RequestParam(value="content",required=false,defaultValue="") String content,
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<Blog> page = blogRepository.findByTitleLikeOrContentLike(title, content, pageable);
		int totalPages = page.getTotalPages();
		System.out.println(totalPages+"totalPages");
		System.out.println(page.getNumber());
		return page.getContent();
	}

	@RequestMapping("/find")
	public void findBlogs() {

		Pageable pageable = new PageRequest(0, 20);
		Page<Blog> pageList = blogRepository.findByTitleLikeOrContentLike("送","人", pageable);
		for (Blog blog : pageList) {
			System.out.println(blog.toString());
		}
	}
}

```

### 对应实体及注解

@Document注解作用在类上，标记实体类为文档对象，常用属性如下：<br>
（1）indexName：对应索引库名称；<br>
（2）type：对应在索引库中的类型；<br>
（3）shards：分片数;<br>
（4) replicas：副本数；<br>
（5) refreshInterval:刷新间隔;<br>
（6) indexStoreType: 索引文件存储类型

```
package com.zshuai.springbootelastic.entity;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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

```
###JPA中的Page与Pageable

* Page是Spring Data提供的一个接口，该接口表示一部分数据的集合以及其相关的下一部分数据、数据总数等相关信息，<br>
通过该接口，可以得到数据的总体信息（数据总数、总页数...）以及当前数据的信息（当前数据的集合、当前页数等）<br>
* Pageable 是Spring Data库中定义的一个接口，该接口是所有分页相关信息的一个抽象，通过该接口，<br>
我们可以得到和分页相关所有信息（例如pageNumber、pageSize等），这样，Jpa就能够通过pageable参数来得到一个带分页信息的Sql语句。

Pageable定义了很多方法，但其核心的信息只有两个：<br>
一是分页的信息（page、size）<br>
二是排序的信息。Spring Data Jpa提供了PageRequest的具体实现<br>


Page接口如下：

```
public interface Page<T> extends Iterable<T> {
    int getNumber();			//当前第几页   返回当前页的数目。总是非负的
    int getSize();			//返回当前页面的大小。
    int getTotalPages();  	        //返回分页总数。
    int getNumberOfElements();   	//返回当前页上的元素数。
    long getTotalElements();    	//返回元素总数。
    boolean hasPreviousPage();  	//返回如果有上一页。
    boolean isFirstPage();      	//返回当前页是否为第一页。
    boolean hasNextPage();      	//返回如果有下一页。
    boolean isLastPage();       	//返回当前页是否为最后一页。
    Iterator<T> iterator();
    List<T> getContent();     		//将所有数据返回为List
    boolean hasContent();     		//返回数据是否有内容。
    Sort getSort();          		//返回页的排序参数。
}
```

Pageable接口：

```
/**
 * 分页信息抽象接口
 * 
 * @author Oliver Gierke
 */
public interface Pageable {
 
	/**
	 * 返回要返回的页面.
	 * @return the page to be returned.
	 */
	int getPageNumber();
 
	/**
	 * 返回要返回的项目的数量。
	 * @return the number of items of that page
	 */
	int getPageSize();
 
	/**
	 * 根据底层页面和页面大小返回偏移量。
	 * @return the offset to be taken
	 */
	int getOffset();
 
	/**
	 * 返回排序参数。
	 * @return
	 */
	Sort getSort();
	............
}
```



