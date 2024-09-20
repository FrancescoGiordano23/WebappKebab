package com.advancia.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.advancia.Entity.SecondaryIngredientEntity;

public class SecondaryIngredientDAO {

	public static List<SecondaryIngredientEntity> getAllSecondaryIngredients(EntityManager manager) {

		List<SecondaryIngredientEntity> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllSecondaryIngredients", SecondaryIngredientEntity.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}
	
	public static SecondaryIngredientEntity getSecondaryIngredientById(EntityManager manager, int selectedSecondaryId) {

		SecondaryIngredientEntity secondaryToReturn = null;

		Query query = manager.createNamedQuery("GetSecondaryIngredientById", SecondaryIngredientEntity.class);
		query.setParameter("id", selectedSecondaryId);
		secondaryToReturn = (SecondaryIngredientEntity) query.getSingleResult();

		return secondaryToReturn;
	}

	public static void deleteSecondaryIngredientById(EntityManager manager, int selectedSecondaryId) {
		SecondaryIngredientEntity secondaryToReturn = null;
		secondaryToReturn=getSecondaryIngredientById(manager, selectedSecondaryId);
		manager.remove(secondaryToReturn);

		
	}

		
	public static void deleteAllSecondaryIngredients(EntityManager manager) {
		Query query = manager.createNamedQuery("GetAllSecondaryIngredients", SecondaryIngredientEntity.class);
		for (SecondaryIngredientEntity s : (List<SecondaryIngredientEntity>) query.getResultList())
			manager.remove(s);
	}

	public static void createNewSecondaryIngredient(EntityManager manager, SecondaryIngredientEntity newSecondaryIngredient) {
		manager.persist(newSecondaryIngredient);
	}
}
