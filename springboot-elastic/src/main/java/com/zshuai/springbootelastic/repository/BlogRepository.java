package com.zshuai.springbootelastic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zshuai.springbootelastic.entity.Blog;

public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
	
	Page<Blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);

}
