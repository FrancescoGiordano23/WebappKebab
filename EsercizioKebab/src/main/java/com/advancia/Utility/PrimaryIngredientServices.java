package com.advancia.Utility;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.advancia.DAO.KebabDAO;
import com.advancia.DAO.PrimaryIngredientDAO;
import com.advancia.Modal.PrimaryIngredient;

public class PrimaryIngredientServices {

	public static List<PrimaryIngredient> getAllPrimaryIngredients() {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			return PrimaryIngredientDAO.getAllPrimaryIngredients(manager);
		} finally {
			if (manager != null)
				manager.close();
		}
	}

	public static PrimaryIngredient getPrimaryIngredientById(int selectedPrimaryId) {
		EntityManager manager = null;
		try {
			manager = JpaUtil.GetEntityManager();
			return PrimaryIngredientDAO.getPrimaryIngredientById(manager, selectedPrimaryId);
		} finally {
			if (manager != null)
				manager.close();
		}
	}

	public static void deletePrimaryIngredientById(int selectedPrimaryId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			PrimaryIngredientDAO.deletePrimaryIngredientById(manager, selectedPrimaryId);
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

	public static void updatePrimaryIngredientById(int selectedPrimaryId, String newName, int newPrice) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			PrimaryIngredient primaryIngredientToUpdate = PrimaryIngredientDAO.getPrimaryIngredientById(manager,
					selectedPrimaryId);
			if (primaryIngredientToUpdate != null) {
				primaryIngredientToUpdate.setName(newName);
				primaryIngredientToUpdate.setPrice(newPrice);
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
	
	public static void createPrimaryIngredient(String name,int price) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			PrimaryIngredient newPrimaryIngredient = new PrimaryIngredient();
			newPrimaryIngredient.setName(name);
			newPrimaryIngredient.setPrice(price);
			PrimaryIngredientDAO.createNewPrimaryIngredient(manager, newPrimaryIngredient);
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
	
	public static void deleteAllPrimaryIngredients() {
		
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();

			PrimaryIngredientDAO.deleteAllPrimaryIngredients(manager);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();
			if (manager != null)
				manager.close();
		}
	}
}
