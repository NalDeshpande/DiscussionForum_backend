package com.service;

import java.util.List;

import com.model.Post;
import com.model.User;

public interface UserServiceInterface {

	public User addUser(User user);

	// Create Method on UserRepository
	public User getUserByEmail(String email);

	public User findByEmailIdAndPassword(String email, String password);

	public User getUserById(int userId);

	public Post addPost(Post post);
	
	public Post getOnePost(int postId);
	
	List<Post> getAllPost();

	List <Post> getOneTopic(String topic);

	public Post addComment(Post comment);
	
	List <Post> getOneComment(String comment);
	
	public Post updatePost(Post post);

	
	
	
	
	
	
	
	
	
	
	


}
