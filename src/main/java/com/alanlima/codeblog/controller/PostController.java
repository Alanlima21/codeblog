package com.alanlima.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alanlima.codeblog.model.Post;
import com.alanlima.codeblog.services.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/posts")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
}