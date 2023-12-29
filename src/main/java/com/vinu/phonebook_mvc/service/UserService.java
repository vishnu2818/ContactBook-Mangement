package com.vinu.phonebook_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.vinu.phonebook_mvc.entity.User;
import com.vinu.phonebook_mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;
	
	public ModelAndView saveUserRequest() {
		return new ModelAndView("add-user.jsp","user",new User());
	}
	public ModelAndView saveUser(User user) {
		repo.saveUser(user);
		return new ModelAndView("home.jsp");
	}
	
	public ModelAndView updateUserRequest(int userId) {
		User user = repo.getUserById(userId);
		return new ModelAndView("update-user.jsp","userUpdate",user);
	}
	public ModelAndView updateUser(User user) {
		User updateUser = repo.updateUser(user);
		return new ModelAndView("home.jsp","user",updateUser);
	}
}