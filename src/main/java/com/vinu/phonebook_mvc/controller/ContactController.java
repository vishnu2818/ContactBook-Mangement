package com.vinu.phonebook_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vinu.phonebook_mvc.entity.Contact;
import com.vinu.phonebook_mvc.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService service;
	
	@RequestMapping(path = "/add-contact",method = RequestMethod.GET)
	public ModelAndView saveContactRequest(int userId) {
		System.out.println(userId);
		return service.saveContactRequest(userId);
	} 
	
	@RequestMapping(path = "/add-contact",method = RequestMethod.POST)
	public ModelAndView saveContact(Contact contact) {
		
		return service.saveContact(contact);
	}
}
