package com.advancia.Utility;

import java.util.List;

import com.advancia.DAO.*;
import com.advancia.Modal.*;
import com.advancia.Entity.KebabEntity;
import com.advancia.Entity.UserEntity;

import javax.persistence.*;;

public class KebabServices {


	public static void CreateNewKebab(String name, int containerId, int primaryId, List<Integer> sauceIds,
			List<Integer> secondaryIds, UserEntity user, int price) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);

			transaction.begin();

			KebabEntity kebabToAdd = new KebabEntity();
			kebabToAdd.setUser(user);
			kebabToAdd.setName(name);
			kebabToAdd.setContainer(ContainerDAO.getContainerById(manager, containerId));
			kebabToAdd.setPrimaryIngredient(PrimaryIngredientDAO.getPrimaryIngredientById(manager, primaryId));
			kebabToAdd.setPrice(price);
			for (Integer i : sauceIds)
				kebabToAdd.addSauceIngredientToList(SauceIngredientDAO.getSauceIngredientById(manager, i));
			for (Integer i : secondaryIds)
				kebabToAdd.addSecondaryIngredientToSet(SecondaryIngredientDAO.getSecondaryIngredientById(manager, i));
			
			
			KebabDAO.AddNewKebab(manager, kebabToAdd);
			user.getKebabsCreated().add(kebabToAdd);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();
			if (manager != null)
				manager.close();
		}
	}

	public static List<KebabEntity> GetAllUserKebabs(UserEntity user) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();

			return KebabDAO.GetAllKebabsOfUser(manager, user);
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

	public static void DeleteAllUserKebab(UserEntity user) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();

			KebabDAO.DeleteAllUserKebab(manager, user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();
			if (manager != null)
				manager.close();
		}

	}

	public static KebabEntity GetKebabOfUserByName(UserEntity user,String kebabName) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = JpaUtil.GetEntityManager();
			transaction = JpaUtil.GetEntityTransaction(manager);
			transaction.begin();

			List<KebabEntity> userKebabs = KebabDAO.GetAllKebabsOfUser(manager, user);
			for(KebabEntity k: userKebabs) {
				if(k.getName().equals(kebabName))
					return k;
				
			}
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

}
