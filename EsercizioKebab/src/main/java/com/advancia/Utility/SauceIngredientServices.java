package com.advancia.Utility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.advancia.DAO.SauceIngredientDAO;
import com.advancia.Modal.SauceIngredient;

public class SauceIngredientServices {

	public static List<SauceIngredient> getAllSauceIngredients() {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();
			return SauceIngredientDAO.getAllSauceIngredients(manager);
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
	
	public static SauceIngredient getSauceIngredientById(int selectedSauceId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();
			return SauceIngredientDAO.getSauceIngredientById(manager, selectedSauceId);
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
	
	public static void deleteAllSauceIngredient() {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();

			SauceIngredientDAO.deleteAllSauceIngredients(manager);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();
			if (manager != null)
				manager.close();
		}
	}
	
	public static void deleteSauceIngredientById(int selectedSauceId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			SauceIngredientDAO.deleteSauceIngredientById(manager, selectedSauceId);
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
	}

	public static void updateSauceIngredientById(int selectedSauceId, String newName, int newPrice) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			SauceIngredient SauceIngredientToUpdate = SauceIngredientDAO.getSauceIngredientById(manager,
					selectedSauceId);
			if (SauceIngredientToUpdate != null) {
				SauceIngredientToUpdate.setName(newName);
				SauceIngredientToUpdate.setPrice(newPrice);
				transaction.commit();
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
	}
	
	public static void createSauceIngredient(String name, int price) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			SauceIngredient newSauceIngredient = new SauceIngredient();
			newSauceIngredient.setName(name);
			newSauceIngredient.setPrice(price);
			SauceIngredientDAO.createNewSauceIngredient(manager, newSauceIngredient);
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
	}
}
