package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bo
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("restandjasonskeletoncode");
    EntityManager em = emf.createEntityManager();
    
    

}
