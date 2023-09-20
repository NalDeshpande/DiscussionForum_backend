package com.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Post;

public interface PostRepository extends JpaRepository<Post ,Integer>{

	List<Post> findByTopic(String topic);
	
	
	
	
//	@Query("Select u from User u where u.email=:email")
//	User findUserByEmail(@Param("email") String email)

	
}
