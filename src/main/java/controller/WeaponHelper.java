package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Weapon;

/**
 * @author Halmar Arteaga - harteagabran
 * CIS175 - Spring 2024
 * Feb 15, 2024
 */
public class WeaponHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Webfireemblem");

	/**
	 * @param toAdd
	 */
	public void insertWeapon(Weapon toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Weapon> showAllWeapons() {
		EntityManager em = emfactory.createEntityManager();
		List<Weapon> allItems = em.createQuery("SELECT i FROM Weapon i").getResultList();
		return allItems;
	}

	/**
	 * @param toDelete
	 */
	public void deleteWeapon(Weapon toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Weapon> typedQuery = em.createQuery("select u from Weapon u where u.id = :selectedId", Weapon.class);
		
		//Substitute with actual data
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//only want one result
		typedQuery.setMaxResults(1);
		
		//get result save in list item
		Weapon result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Weapon searchForWeaponById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Weapon found = em.find(Weapon.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateWeapon(Weapon toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
