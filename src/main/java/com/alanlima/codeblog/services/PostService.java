package com.alanlima.codeblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanlima.codeblog.model.Post;
import com.alanlima.codeblog.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(Integer id) {
		return repo.findById(id).get()	;
	}
	
	public Post insert(Post obj) {
		return repo.save(obj);
	}
}
