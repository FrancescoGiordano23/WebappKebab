package com.advancia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.advancia.Entity.KebabEntity;
import com.advancia.Entity.PrimaryIngredientEntity;

public class PrimaryIngredientDAO {

	public static List<PrimaryIngredientEntity> getAllPrimaryIngredients(EntityManager manager) {

		List<PrimaryIngredientEntity> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllPrimaryIngredients", PrimaryIngredientEntity.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static PrimaryIngredientEntity getPrimaryIngredientById(EntityManager manager, int selectedPrimaryId) {

		PrimaryIngredientEntity primaryToReturn = null;

		Query query = manager.createNamedQuery("GetPrimaryIngredientById", PrimaryIngredientEntity.class);
		query.setParameter("id", selectedPrimaryId);
		primaryToReturn = (PrimaryIngredientEntity) query.getSingleResult();

		return primaryToReturn;
	}
	
	public static void deletePrimaryIngredientById(EntityManager manager, int selectedPrimaryId) {

		PrimaryIngredientEntity primaryToDelete = getPrimaryIngredientById(manager, selectedPrimaryId);
		manager.remove(primaryToDelete);
		
	}

	public static void createNewPrimaryIngredient(EntityManager manager, PrimaryIngredientEntity newPrimaryIngredient) {
		manager.persist(newPrimaryIngredient);
		
	}

	public static void deleteAllPrimaryIngredients(EntityManager manager) {
		Query query = manager.createNamedQuery("GetAllPrimaryIngredients", PrimaryIngredientEntity.class);
		for (PrimaryIngredientEntity p : (List<PrimaryIngredientEntity>) query.getResultList())
			manager.remove(p);
		
	}

}
