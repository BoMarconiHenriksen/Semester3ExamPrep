package entities;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Implement a simple facade class with a method that will return all Pet's, and
 * demonstrate the method
 *
 * @author Bo
 */
public class PetFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("dyr");
    EntityManager em = emf.createEntityManager();
    //Pet pet = new Pet();

    public static HashMap<Integer, Event> events = new HashMap<>();

    public static Owner findOwnerById(Owner ownerId) {
        return null;

    }

    public static List<Pet> getAllPets() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dyr");
        EntityManager em = emf.createEntityManager();

        List<Pet> pets;

        Query q = em.createQuery("select p from Pet p");
        pets = q.getResultList();

        //En anden mulighed
//        TypedQuery<Pet> query = em.createNamedQuery("Pet.findAll", Pet.class);
//        List<Pet> results = query.getResultList();
        return pets;
    }

    public static int countAllPets() {
        return getAllPets().size();
    }

}
