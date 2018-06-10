
package test;

import entities.Names;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bo
 */
public class Tester {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();
        
//        Persistence.generateSchema("user", null);

        getAllNames();
        
    }
    
    public static void getAllNames() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT n FROM Names n");
        List<Names> result = query.getResultList();

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Name: " + result.get(i).getName() + " " + result.get(i).getSurname() + ", " + result.get(i).getGender());
        }
    }
    
}
