package com.advancia.DAO;

import java.util.List;

import javax.persistence.*;
import com.advancia.Utility.JpaUtil;
import com.advancia.Entity.UserEntity;

public class UserDAO {

	public static UserEntity FindUserInDatabase(String username, String password) {
		EntityManager entityManager = null;
		UserEntity userToReturn = null;

		try {
			entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();			
	        Query query=entityManager.createNamedQuery("FindUserByUsernamePassword", UserEntity.class);       
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        userToReturn= (UserEntity) query.getSingleResult();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return userToReturn;
	}

	public static UserEntity getUserById(EntityManager manager, int selectedUserId) {

		UserEntity userToReturn = null;

		Query query = manager.createNamedQuery("GetUserById", UserEntity.class);
		query.setParameter("id", selectedUserId);
		userToReturn = (UserEntity) query.getSingleResult();

		return userToReturn;
	}

	public static List<UserEntity> getAllUsers(EntityManager manager) {

		List<UserEntity> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllUsers", UserEntity.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}
	
	public static boolean deleteUserById(EntityManager manager, int selectedUserId) {
		try {
			UserEntity userToReturn = null;
			userToReturn = getUserById(manager, selectedUserId);
			manager.remove(userToReturn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean createNewUser(EntityManager manager, UserEntity newUser) {
		try {
			manager.persist(newUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
