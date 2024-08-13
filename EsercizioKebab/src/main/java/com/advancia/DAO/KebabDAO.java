package com.advancia.DAO;

import java.util.List;

import com.advancia.Modal.*;

import javax.persistence.*;

public class KebabDAO {

	public static void AddNewKebab(EntityManager manager, Kebab kebabToAdd) {
		manager.persist(kebabToAdd);

	}

	public static List<Kebab> GetAllKebabsOfUser(EntityManager manager, User user) {
		List<Kebab> kebabsToReturn = null;

		Query query = manager.createNamedQuery("GetAllKebabsOfUser", Kebab.class);
		query.setParameter("user", user);
		kebabsToReturn = query.getResultList();

		System.out.println(kebabsToReturn);
		return kebabsToReturn;
	}

	public static void DeleteAllUserKebab(EntityManager manager, User user) {

		Query query = manager.createNamedQuery("GetAllKebabsOfUser", Kebab.class);
		query.setParameter("user", user);
		for (Kebab k : (List<Kebab>) query.getResultList())
			manager.remove(k);

	}
}
