package com.advancia.Utility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.advancia.DAO.UserDAO;
import com.advancia.Modal.User;
import com.advancia.Entity.UserEntity;
import com.advancia.DAO.UserDAO;

public class UserServices {

	public static UserEntity CheckAndGetUserByCredentials(String username, String password) {

		return UserDAO.FindUserInDatabase(username, password);

	}

	public static List<UserEntity> getAllUsers() {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();
			return UserDAO.getAllUsers(manager);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();
			if (manager != null)
				manager.close();
		}
		return null;
	}

	public static UserEntity getUserById(int selectedUserId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();
			return UserDAO.getUserById(manager, selectedUserId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();
			if (manager != null)
				manager.close();
		}
		return null;
	}

	public static boolean deleteUserById(int selectedSecondaryId) {
		boolean deleteSuccessfull = false;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			deleteSuccessfull = UserDAO.deleteUserById(manager, selectedSecondaryId);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null)
				manager.close();
		}
		return deleteSuccessfull;
	}

	public static boolean updateUserById(int selectedUserId, String newUsername, String newPassword) {
		boolean updateSuccessfull = false;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UserEntity UserToUpdate = UserDAO.getUserById(manager, selectedUserId);
			if (UserToUpdate != null) {
				UserToUpdate.setUsername(newUsername);
				UserToUpdate.setPassword(newPassword);
				transaction.commit();
				updateSuccessfull = true;
			} else {
				transaction.rollback();
			}
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null)
				manager.close();
		}
		return updateSuccessfull;
	}

	public static boolean createUser(String newUsername, String newPassword) {

		boolean createSuccessfull = false;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UserEntity newUser = new UserEntity();
			newUser.setUsername(newUsername);
			newUser.setPassword(newPassword);
			createSuccessfull = UserDAO.createNewUser(manager, newUser);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null)
				manager.close();
		}
		return createSuccessfull;
	}
}
