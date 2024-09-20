package com.advancia.DAO;

import java.util.List;

import com.advancia.Modal.*;
import com.advancia.Entity.KebabEntity;
import com.advancia.Entity.UserEntity;

import javax.persistence.*;

public class KebabDAO {

	public static void AddNewKebab(EntityManager manager, KebabEntity kebabToAdd) {
		manager.persist(kebabToAdd);

	}

	public static List<KebabEntity> GetAllKebabsOfUser(EntityManager manager, UserEntity user) {
		List<KebabEntity> kebabsToReturn = null;

		Query query = manager.createNamedQuery("GetAllKebabsOfUser", KebabEntity.class);
		query.setParameter("user", user);
		kebabsToReturn = query.getResultList();

		System.out.println(kebabsToReturn);
		return kebabsToReturn;
	}

	public static void DeleteAllUserKebab(EntityManager manager, UserEntity user) {

		Query query = manager.createNamedQuery("GetAllKebabsOfUser", KebabEntity.class);
		query.setParameter("user", user);
		for (KebabEntity k : (List<KebabEntity>) query.getResultList())
			manager.remove(k);

	}
}
