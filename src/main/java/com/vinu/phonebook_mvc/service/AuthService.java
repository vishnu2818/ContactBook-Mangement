package com.vinu.phonebook_mvc.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.vinu.phonebook_mvc.dto.LoginDto;
import com.vinu.phonebook_mvc.entity.User;
import com.vinu.phonebook_mvc.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository repo;
 
	public ModelAndView loginForm() {
		return new ModelAndView("login.jsp").addObject("login",new LoginDto());
	}

	public ModelAndView login(LoginDto loginDto, HttpSession session) {
		User user = repo.getUserByEmail(loginDto.getEmail());
		ModelAndView mav = new ModelAndView("home.jsp");
		if(user != null) {
			if(user.getPassword().equals(loginDto.getPassword())) {
				session.setAttribute("user",user);
				return mav;
			}
		}
		mav.addObject("error", "authenticatin Failed..!");
		return mav;
	}
}
