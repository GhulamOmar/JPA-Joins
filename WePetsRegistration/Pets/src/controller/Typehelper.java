package controller;

	import java.util.List;


	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import javax.persistence.TypedQuery;

	import model.PetType;

	public class Typehelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pets");

		public void insertItem(PetType li) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(li);
			em.getTransaction().commit();
			em.close();
		}

		public List<PetType> showAllType() {
			EntityManager em = emfactory.createEntityManager();
			List<PetType> allType = em.createQuery("SELECT i FROM PetType i").getResultList();
			return allType;
		}

		public void deleteItem(PetType toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<PetType> typedQuery = em.createQuery(
					"select li from PetType li where li.pettype = :selectedPettype and li.petname = :selectedPetname li.ownername = :selectedOw ",
					PetType.class);
			typedQuery.setParameter("selectedType", toDelete.getPettype());
			typedQuery.setParameter("selectedPetname", toDelete.getPetname());
			typedQuery.setParameter("selectedOwnername", toDelete.getOwnername());

			typedQuery.setMaxResults(1);
			PetType result = typedQuery.getSingleResult();
			em.remove(result);
			em.getTransaction().commit();
			em.close();

		}
		public PetType searchForPetId(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			PetType found = em.find(PetType.class, idToEdit);
			em.close();
			return found;
		}

		public void updatePet(PetType toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}

		public List<PetType> searchForNmaeByType(String typeName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<PetType> typedQuery = em.createQuery("select li from PetType li where li.pettype = :selectedPettype and li.petname = :selectedPetname li.ownername = :selectedOw ",PetType.class);
			typedQuery.setParameter("selectedType", typeName);

			List<PetType> foundPets = typedQuery.getResultList();
			em.close();
			return foundPets;
		}

		public List<PetType> searchForPetByPet(String petName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<PetType> typedQuery = em.createQuery("select li from PetType li where li.pettype = :selectedPettype and li.petname = :selectedPetname li.ownername = :selectedOw ",PetType.class);
			typedQuery.setParameter("selectedPetname", petName);

			List<PetType> foundPets = typedQuery.getResultList();
			em.close();
			return foundPets;
		}
		
		public void cleanUp(){
			emfactory.close();
		}

	}


