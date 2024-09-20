package com.advancia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.advancia.Entity.SauceIngredientEntity;

public class SauceIngredientDAO {

	public static List<SauceIngredientEntity> getAllSauceIngredients(EntityManager manager) {

		List<SauceIngredientEntity> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllSauceIngredients", SauceIngredientEntity.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static SauceIngredientEntity getSauceIngredientById(EntityManager manager, int selectedSauceId) {

		SauceIngredientEntity sauceToReturn = null;

		Query query = manager.createNamedQuery("GetSauceIngredientById", SauceIngredientEntity.class);
		query.setParameter("id", selectedSauceId);
		sauceToReturn = (SauceIngredientEntity) query.getSingleResult();

		return sauceToReturn;

	}

	public static void deleteAllSauceIngredients(EntityManager manager) {
		Query query = manager.createNamedQuery("GetAllSauceIngredients", SauceIngredientEntity.class);
		for (SauceIngredientEntity s : (List<SauceIngredientEntity>) query.getResultList())
			manager.remove(s);
	}

	public static void deleteSauceIngredientById(EntityManager manager, int selectedSauceId) {
		SauceIngredientEntity sauceToReturn = null;
		sauceToReturn = getSauceIngredientById(manager, selectedSauceId);
		manager.remove(sauceToReturn);

	}

	public static void createNewSauceIngredient(EntityManager manager, SauceIngredientEntity newsauceIngredient) {
		manager.persist(newsauceIngredient);
	}

}
