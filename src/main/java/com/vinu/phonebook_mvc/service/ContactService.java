package com.vinu.phonebook_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.vinu.phonebook_mvc.entity.Contact;
import com.vinu.phonebook_mvc.entity.User;
import com.vinu.phonebook_mvc.repository.ContactRepository;
import com.vinu.phonebook_mvc.repository.UserRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository repo;
	@Autowired
	UserRepository userRepo;
	
	public ModelAndView saveContactRequest(int userId) {
		User user = userRepo.getUserById(userId);
		
		Contact contact = new Contact();
		contact.setUser(user);
		contact.setContactEmail(user.getEmail());
		return new ModelAndView("add-contact.jsp","contact",contact);
	}

	public ModelAndView saveContact(Contact contact) {
		repo.saveContact(contact);
		
		return new ModelAndView("home.jsp","msg","Successfully Saved Your Contact..!!");
	}
}