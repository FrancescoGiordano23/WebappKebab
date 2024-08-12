package com.advancia.DAO;

import java.util.List;

import com.advancia.Modal.*;

import javax.persistence.*;

public class KebabDAO {

	public static List<Container> GetAllContainers(EntityManager manager) {

		List<Container> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllContainers", Container.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static List<PrimaryIngredient> GetAllPrimaryIngredients(EntityManager manager) {

		List<PrimaryIngredient> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllPrimaryIngredients", PrimaryIngredient.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static List<SecondaryIngredient> GetAllSecondaryIngredients(EntityManager manager) {

		List<SecondaryIngredient> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllSecondaryIngredients", SecondaryIngredient.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static List<SauceIngredient> GetAllSauceIngredients(EntityManager manager) {

		List<SauceIngredient> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllSauceIngredients", SauceIngredient.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static Container GetContainerById(EntityManager manager, int selectedContainerId) {

		Container containerToReturn = null;

		Query query = manager.createNamedQuery("GetContainerById", Container.class);
		query.setParameter("id", selectedContainerId);
		containerToReturn = (Container) query.getSingleResult();

		return containerToReturn;
	}

	public static PrimaryIngredient GetPrimaryIngredientById(EntityManager manager, int selectedPrimaryId) {

		PrimaryIngredient primaryToReturn = null;

		Query query = manager.createNamedQuery("GetPrimaryIngredientById", PrimaryIngredient.class);
		query.setParameter("id", selectedPrimaryId);
		primaryToReturn = (PrimaryIngredient) query.getSingleResult();

		return primaryToReturn;
	}

	public static SecondaryIngredient GetSecondaryIngredientById(EntityManager manager, int selectedSecondaryId) {

		SecondaryIngredient secondaryToReturn = null;

		Query query = manager.createNamedQuery("GetSecondaryIngredientById", SecondaryIngredient.class);
		query.setParameter("id", selectedSecondaryId);
		secondaryToReturn = (SecondaryIngredient) query.getSingleResult();

		return secondaryToReturn;
	}

	public static SauceIngredient GetSauceIngredientById(EntityManager manager, int selectedSauceId) {

		SauceIngredient sauceToReturn = null;

		Query query = manager.createNamedQuery("GetSauceIngredientById", SauceIngredient.class);
		query.setParameter("id", selectedSauceId);
		sauceToReturn = (SauceIngredient) query.getSingleResult();

		return sauceToReturn;
	}

	public static void AddNewKebab(EntityManager manager, Kebab kebabToAdd) {
		manager.persist(kebabToAdd);

	}

	public static List<Kebab> GetAllKebabsOfUser(EntityManager manager, User user) {
		List<Kebab> kebabsToReturn=null;
		
		Query query = manager.createNamedQuery("GetAllKebabsOfUser",Kebab.class);
		query.setParameter("user", user);
		kebabsToReturn = query.getResultList();
		
		System.out.println(kebabsToReturn);
		return kebabsToReturn;
	}

	public static void DeleteAllUserKebab(EntityManager manager, User user) {
		
		Query query = manager.createNamedQuery("GetAllKebabsOfUser",Kebab.class);
		query.setParameter("user", user);
		for(Kebab k: (List<Kebab>)query.getResultList())
			manager.remove(k);
		
	}
}
