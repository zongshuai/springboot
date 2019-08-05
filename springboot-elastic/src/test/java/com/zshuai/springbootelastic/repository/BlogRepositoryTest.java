package com.zshuai.springbootelastic.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.zshuai.springbootelastic.entity.Blog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

	@Autowired
	private BlogRepository blogRepository;
	
	@Test
	public void testFindByTitleLikeOrContentLike() {
		System.out.println("start");
		//清空所有
		blogRepository.deleteAll();
		System.out.println("deleteall");
		blogRepository.save(new Blog("1", "寻隐者不遇", "松下问童子，言师采药去。只在此山中，云深不知处。"));
		
		blogRepository.save(new Blog("2", "送方外上人","孤云将野鹤，岂向人间住。莫买沃洲山，时人已知处。"));
		
		blogRepository.save(new Blog("3", "九月九日忆山东兄弟","独在异乡为异客，每逢佳节倍思亲。遥知兄弟登高处，遍插茱萸少一人。"));
		
		blogRepository.save(new Blog("4", " 送崔九", "归山深浅去，须尽丘壑美。莫学武陵人，暂游桃源里。"));
		
		Pageable pageable = new PageRequest(0, 20);
		Page<Blog> pageList = blogRepository.findByTitleLikeOrContentLike("送","人", pageable);
		for (Blog blog : pageList) {
			System.out.println(blog.toString());
		}
		
	}
}
