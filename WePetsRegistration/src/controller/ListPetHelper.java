package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Listpet;

public class ListPetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingList");

	public void insertItem(Listpet li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Listpet> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Listpet> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}

	public void deleteItem(Listpet toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Listpet> typedQuery = em.createQuery(
				"select li from ListItem li where li.store = :selectedStore and li.item = :selectedItem",
				Listpet.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem", toDelete.getItem());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Listpet result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Listpet searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Listpet found = em.find(Listpet.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Listpet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public List<Listpet> searchForItemByStore(String storeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Listpet> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore", Listpet.class);
		typedQuery.setParameter("selectedStore", storeName);

		List<Listpet> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Listpet> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Listpet> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem", Listpet.class);
		typedQuery.setParameter("selectedItem", itemName);

		List<Listpet> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}	
	public void cleanUp(){
		emfactory.close();
	}

}
