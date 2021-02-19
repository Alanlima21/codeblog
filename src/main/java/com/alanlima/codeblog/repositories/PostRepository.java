package com.alanlima.codeblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alanlima.codeblog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
