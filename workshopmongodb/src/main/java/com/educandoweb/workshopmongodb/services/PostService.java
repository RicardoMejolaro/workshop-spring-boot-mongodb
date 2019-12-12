package com.educandoweb.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshopmongodb.domain.Post;
import com.educandoweb.workshopmongodb.repository.PostRepository;
import com.educandoweb.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		
		Optional<Post> post = postRepository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public void deletePost(String id) {
		findById(id);
		postRepository.deleteById(id);
	}
}