package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PostRepository;
import com.dao.UserRepository;
import com.model.Post;
import com.model.User;
@Service
public class UserServiceImp implements UserServiceInterface {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;
	

	
	
	public User addUser(User user) {

		return userRepo.save(user);
	}

	public User findByEmailIdAndPassword(String email, String password) {

		return userRepo.findByEmailIdAndPassword(email, password);
	}

	public User getUserByEmail(String email) {

		return userRepo.findUserByEmail(email);
	}

	public User getUserById(int userId) {

		return userRepo.findById(userId).get();
	}
	
	

	@Override
	public Post addPost(Post post) {
		
		return postRepo.save(post);
	}

	@Override
	public Post getOnePost(int postId) {
		
		return postRepo.findById(null).orElse(null);
	}

	

	@Override
	public List<Post> getOneTopic(String topic) {
		
		return postRepo.findByTopic(topic);
	}

	@Override
	public List<Post> getAllPost() {
		return postRepo.findAll();
	}

	@Override
	public Post addComment(Post comment) {
		
		return postRepo.save(comment);
	}

	@Override
	public List<Post> getOneComment(String comment) {
		
		return postRepo.findByTopic(comment);
	}

	@Override
	public Post updatePost(Post post) {
		Post existingPost=postRepo.findById(post.getPostId()).orElse(null);
		existingPost.setComment(post.getComment());
		return postRepo.save(existingPost);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	

}
