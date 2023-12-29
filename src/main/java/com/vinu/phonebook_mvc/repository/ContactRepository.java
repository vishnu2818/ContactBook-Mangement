package com.vinu.phonebook_mvc.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinu.phonebook_mvc.entity.Contact;

@Repository
public class ContactRepository {
	@Autowired
	private EntityManagerFactory managerFactory;
	
	public void saveContact(Contact contact) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(contact);
		transaction.commit();
		
		manager.close();
	}
	public void updateContact(Contact contact) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.merge(contact);
		transaction.commit();
		
		manager.close();
	}
	public void deleteContact(Contact contact) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.remove(contact);
		transaction.commit();
		
		manager.close();
	}
}











