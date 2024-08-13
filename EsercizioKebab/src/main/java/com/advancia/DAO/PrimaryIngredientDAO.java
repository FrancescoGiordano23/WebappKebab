package com.advancia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.advancia.Modal.Kebab;
import com.advancia.Modal.PrimaryIngredient;

public class PrimaryIngredientDAO {

	public static List<PrimaryIngredient> getAllPrimaryIngredients(EntityManager manager) {

		List<PrimaryIngredient> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllPrimaryIngredients", PrimaryIngredient.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static PrimaryIngredient getPrimaryIngredientById(EntityManager manager, int selectedPrimaryId) {

		PrimaryIngredient primaryToReturn = null;

		Query query = manager.createNamedQuery("GetPrimaryIngredientById", PrimaryIngredient.class);
		query.setParameter("id", selectedPrimaryId);
		primaryToReturn = (PrimaryIngredient) query.getSingleResult();

		return primaryToReturn;
	}
	
	public static void deletePrimaryIngredientById(EntityManager manager, int selectedPrimaryId) {

		PrimaryIngredient primaryToDelete = getPrimaryIngredientById(manager, selectedPrimaryId);
		manager.remove(primaryToDelete);
		
	}

	public static void createNewPrimaryIngredient(EntityManager manager, PrimaryIngredient newPrimaryIngredient) {
		manager.persist(newPrimaryIngredient);
		
	}

	public static void deleteAllPrimaryIngredients(EntityManager manager) {
		Query query = manager.createNamedQuery("GetAllPrimaryIngredients", PrimaryIngredient.class);
		for (PrimaryIngredient p : (List<PrimaryIngredient>) query.getResultList())
			manager.remove(p);
		
	}

}
