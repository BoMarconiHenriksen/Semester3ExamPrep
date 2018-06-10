package entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bo
 */
public class PersonFacade {

    public static List<Person> getAllPersons() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restandjson");
        EntityManager em = emf.createEntityManager();

        List<Person> personList;

        Query q = em.createQuery("select p from Person p");
        personList = q.getResultList();

        return personList;
    }
    
    public static List<Person> getNumberOfPersons(int number) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restandjson");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList().subList(0, number);
        
        return personList;
    }

    //For testing
    public static void main(String[] args) {
        PersonFacade pf = new PersonFacade();
        System.out.println(pf.getNumberOfPersons(10));
    }

}
