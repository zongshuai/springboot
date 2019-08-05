package com.zshuai.springbootelastic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zshuai.springbootelastic.entity.Blog;
import com.zshuai.springbootelastic.repository.BlogRepository;

@RestController
@RequestMapping("/blogs")
public class BlogController {

	public final static Logger logger = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	private BlogRepository blogRepository;

	@RequestMapping("/create")
	public void createBlogs() {
		
		logger.info("开始删除===");
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
		// 数据在 Test 里面先初始化了，这里只管取数据
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
