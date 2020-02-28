package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Listpet;
import model.Registration;

public class RegistrationHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WePetsRegistration");

		public void insertShopper(Registration s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		}

		public List<Registration> showAllShoppers() {
			EntityManager em = emfactory.createEntityManager();
			List<Registration> allShoppers = em.createQuery("SELECT s FROM Shopper s").getResultList();
			return allShoppers;
		}
		public Registration searchForShopperByName(String rigidtionName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Registration> typedQuery = em.createQuery("select s from Shopper s where s.rigidtionName = :selectedName", Registration.class);
			typedQuery.setParameter("selectedName", rigidtionName);
			typedQuery.setMaxResults(1);

			Registration found = typedQuery.getSingleResult();
			em.close();
			return found;
		}
}
