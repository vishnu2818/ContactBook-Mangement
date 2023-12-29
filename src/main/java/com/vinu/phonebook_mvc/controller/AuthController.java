package com.vinu.phonebook_mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vinu.phonebook_mvc.dto.LoginDto;
import com.vinu.phonebook_mvc.service.AuthService;

@Controller
public class AuthController {
	@Autowired
	private AuthService service;
	
	@RequestMapping(path = "/login",method = RequestMethod.GET)
	public ModelAndView loginRequest() {
		return service.loginForm();
	}
	
	@RequestMapping(path = "/login",method = RequestMethod.POST)
	public ModelAndView login(LoginDto loginDto, HttpSession session) {
		return service.login(loginDto,session);
	}
}