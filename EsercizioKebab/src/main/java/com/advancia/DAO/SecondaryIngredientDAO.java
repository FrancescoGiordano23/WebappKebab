package com.advancia.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.advancia.Modal.SecondaryIngredient;

public class SecondaryIngredientDAO {

	public static List<SecondaryIngredient> getAllSecondaryIngredients(EntityManager manager) {

		List<SecondaryIngredient> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllSecondaryIngredients", SecondaryIngredient.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}
	
	public static SecondaryIngredient getSecondaryIngredientById(EntityManager manager, int selectedSecondaryId) {

		SecondaryIngredient secondaryToReturn = null;

		Query query = manager.createNamedQuery("GetSecondaryIngredientById", SecondaryIngredient.class);
		query.setParameter("id", selectedSecondaryId);
		secondaryToReturn = (SecondaryIngredient) query.getSingleResult();

		return secondaryToReturn;
	}

	public static void deleteSecondaryIngredientById(EntityManager manager, int selectedSecondaryId) {
		SecondaryIngredient secondaryToReturn = null;
		secondaryToReturn=getSecondaryIngredientById(manager, selectedSecondaryId);
		manager.remove(secondaryToReturn);

		
	}

		
	public static void deleteAllSecondaryIngredients(EntityManager manager) {
		Query query = manager.createNamedQuery("GetAllSecondaryIngredients", SecondaryIngredient.class);
		for (SecondaryIngredient s : (List<SecondaryIngredient>) query.getResultList())
			manager.remove(s);
	}

	public static void createNewSecondaryIngredient(EntityManager manager, SecondaryIngredient newSecondaryIngredient) {
		manager.persist(newSecondaryIngredient);
	}
}
