package com.advancia.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.advancia.Entity.ContainerEntity;

public class ContainerDAO {

	public static List<ContainerEntity> getAllContainers(EntityManager manager) {

		List<ContainerEntity> listToReturn = null;

		Query query = manager.createNamedQuery("GetAllContainers", ContainerEntity.class);
		listToReturn = query.getResultList();

		return listToReturn;
	}

	public static ContainerEntity getContainerById(EntityManager manager, int selectedContainerId) {

		ContainerEntity containerToReturn = null;

		Query query = manager.createNamedQuery("GetContainerById", ContainerEntity.class);
		query.setParameter("id", selectedContainerId);
		containerToReturn = (ContainerEntity) query.getSingleResult();

		return containerToReturn;
	}

	public static boolean deleteContainerById(EntityManager manager, int selectedSecondaryId) {
		try {
			ContainerEntity secondaryToReturn = null;
			secondaryToReturn = getContainerById(manager, selectedSecondaryId);
			manager.remove(secondaryToReturn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteAllContainers(EntityManager manager) {
		try {
			Query query = manager.createNamedQuery("GetAllContainers", ContainerEntity.class);
			for (ContainerEntity s : (List<ContainerEntity>) query.getResultList())
				manager.remove(s);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean createNewContainer(EntityManager manager, ContainerEntity newContainer) {
		try {
			manager.persist(newContainer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
