package com.vinu.phonebook_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinu.phonebook_mvc.entity.User;

@Repository
public class UserRepository {

	@Autowired
	private EntityManagerFactory managerFactory;

	public void saveUser(User user) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(user);
		transaction.commit();

		manager.close();
	}
	public User updateUser(User user) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		User updatedUser = manager.merge(user);
		transaction.commit();

		manager.close();
		return updatedUser;
	}
	
	public void deleteUser(User user) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.remove(user);
		transaction.commit();

		manager.close();
	}
	public User getUserById(int userId) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		User user = manager.find(User.class, userId);
		transaction.commit();

		manager.close();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		Query query =  manager.createQuery("from User",User.class);
		List<User> list = query.getResultList();
		transaction.commit();

		manager.close();
		return list;
	}
	public User getUserByEmail(String email) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		Query query = manager.createQuery("FROM User WHERE email=:e");
		query.setParameter("e", email);
		User user =  (User) query.getSingleResult();
		transaction.commit();

		manager.close();
		return user;
	}
}
 




