package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Post;
import com.model.User;
import com.service.UserServiceImp;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("forum")
@RestController
//@RequestMapping("forum")
public class UserController {
	
	@Autowired
	UserServiceImp userService;
	
	
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) throws Exception
	{
		String tempEmail =user.getEmail();
		if(tempEmail !=null && !"".equals(tempEmail)) {
			User userObj=userService.getUserByEmail(tempEmail);
			if(userObj!=null) {
				throw new Exception("User with "+tempEmail+" is already exit");
			}
		}
		User userObj1=null;
		userObj1=userService.addUser(user);
		return userObj1;
	}
	@PostMapping("/loginUser")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		String tempPass=user.getPassword();
		User userObj=null;
		if(tempEmail !=null && tempPass!=null) {
			userObj=userService.findByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Bad Creadentials");
		}
		return userObj;
		
	}
	
	@GetMapping("/getUser/{id}")
	ResponseEntity<User> getUser(@PathVariable("id") int id)
	{
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	

	@PostMapping("/savePost")
	public Post savePost(@RequestBody Post post) {
		
		return userService.addPost(post);
	}

	@GetMapping("/get/{postId}")
	public Post findPost(@PathVariable int postId) {
		// TODO Auto-generated method stub
		return userService.getOnePost(postId);
	}

	

	@GetMapping("/get/{topic}")
	public List<Post> findtopic(@PathVariable String topic) {
		
		return userService.getOneTopic(topic);
	}
	
	@GetMapping("/getAllPost")
	public List<Post> getAllPost(){
			
		return userService.getAllPost();
	}
	
	@PostMapping("/saveComment")
    public Post addComment(@RequestBody Post comment) {
		
		return userService.addComment(comment);
	}
	
	@GetMapping("/getComment/{topic}")
	public List<Post> getOneComment(String comment) {
		
		return userService.getOneComment(comment);
		}
	
	@PutMapping("/update")
	public Post updatepost(@RequestBody Post post) {

		return userService.updatePost(post);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	}
//	@PostMapping("/addComment/{postId}/content")
//	public String addComment(int postId,String content) {
//		// TODO Auto-generated method stub
//		return userService.addComment(postId,content);
//	}
		
		
	
}
