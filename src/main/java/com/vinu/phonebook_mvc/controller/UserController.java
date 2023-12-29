package com.vinu.phonebook_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vinu.phonebook_mvc.entity.User;
import com.vinu.phonebook_mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(path = "/add-user",method = RequestMethod.GET)
	public ModelAndView saveUserRequest() {
		return service.saveUserRequest();
	}
	@RequestMapping(path = "/add-user",method = RequestMethod.POST)
	public ModelAndView saveUser(User user) {
		return service.saveUser(user);
	}
	
	@RequestMapping(value = "/update-user",method = RequestMethod.GET)
	public ModelAndView updateUserRequest(@RequestParam int userId) {
		return service.updateUserRequest(userId);
	}
	
	@RequestMapping(value = "/update-user",method = RequestMethod.POST)
	public ModelAndView updateUser(User user) {
		return service.updateUser(user);
	}
	
	
}
