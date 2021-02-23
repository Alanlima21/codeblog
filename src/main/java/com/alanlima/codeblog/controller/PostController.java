package com.alanlima.codeblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alanlima.codeblog.model.Post;
import com.alanlima.codeblog.services.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping(value = "/posts")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("posts"); // pagina html q ele retorna
		List<Post> posts = service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	@GetMapping(value = "/posts/{id}")
	public ModelAndView findById(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = service.findById(id);
		mv.addObject("post", post);
		return mv;
	}

	@GetMapping(value = "/newpost" )
	public ModelAndView getPostForm() {
		ModelAndView mv = new ModelAndView("postForm");
		return mv;
	}

	@PostMapping(value = "/newpost")
	public ModelAndView insert(@Valid Post obj, BindingResult result, RedirectAttributes atributes) {
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("redirect:/newpost");
			atributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos !");
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:posts");
		service.insert(obj);
		return mv;
	}
}
