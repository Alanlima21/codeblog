package com.alanlima.codeblog.utils;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alanlima.codeblog.model.Post;
import com.alanlima.codeblog.repositories.PostRepository;

@Component
public class Data {

	@Autowired
	private PostRepository repo;
	
	//@PostConstruct   //Vai ser executado quando a aplicação subir
	public void savePosts() {
		
		Post p1 = new Post(null, "Teste", "Alan Lima", LocalDate.now(), "Olá, post teste");
		Post p2 = new Post(null, "Esporte Clube Bahia", "GE", LocalDate.now(), "Bahia campeão mundial!");
		Post p3 = new Post(null, "API REST com Spring MVC", "Michelli", LocalDate.now(), "Curso de spring REST MVC, muito bom !");
		
		repo.saveAll(Arrays.asList(p1,p2, p3));
	}
}
