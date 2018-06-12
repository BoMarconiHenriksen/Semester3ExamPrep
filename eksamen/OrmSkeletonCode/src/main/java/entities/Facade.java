package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bo
 */
public class Facade {
    
    // HAR IKKE LAVET DATABASE OG PERSOSTENCE UNIT!
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKRIV NAVN PÅ PERSISTENCE UNIT HER");
        EntityManager em = emf.createEntityManager();

        //Laver entities med tomme tabeler i databasen.
        Persistence.generateSchema("SKRIV NAVN PÅ PERSISTENCE UNIT HER", null);
        
        
        
    }
    
}
