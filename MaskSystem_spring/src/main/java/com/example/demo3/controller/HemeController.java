package com.example.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo3.model.User;
import com.example.demo3.repository.UserRepository;
import com.example.demo3.service.UserService;

@Controller
public class HemeController {
	@Autowired
	private UserService uservice;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String home() {
		System.out.println("home");
		return "home";
	}
	//회원가입폼
	@GetMapping("register")
	public String register() {
		return "/user/join";
	}
	
	//로그인폼
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}
	//회원가입
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody User user) {
		if(userRepository.findByUsername(user.getUsername())!=null) {
			return "fail";
		}
		uservice.register(user);
		return "success";
	}
	
	
	
	
}
