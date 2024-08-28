package com.advancia.DAO;

import com.advancia.java.User;

import javax.persistence.*;
import com.advancia.Utility.JpaUtil;

public class UserDAO {

	public static User FindUserInDatabase(String username, String password) {
		EntityManager entityManager = null;
		User userToReturn = null;

		try {
			entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();			
	        Query query=entityManager.createNamedQuery("FindUserByUsernamePassword", User.class);       
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        userToReturn= (User) query.getSingleResult();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return userToReturn;
	}
}
