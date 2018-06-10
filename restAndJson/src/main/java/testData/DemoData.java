package testData;

import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author Bo
 */
public class DemoData {

    DataFactory df = new DataFactory();

    public void createTestPersons(EntityManager em) {
        Person person;

        for (int i = 0; i < 100; i++) {
            person = new Person(df.getFirstName(), df.getLastName(), df.getNumberUpTo(107));
            em.persist(person);
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restandjson");
        EntityManager em = emf.createEntityManager();

        DemoData demoData = new DemoData();

        em.getTransaction().begin();
        demoData.createTestPersons(em);
        em.getTransaction().commit();
        em.close();

    }

}
