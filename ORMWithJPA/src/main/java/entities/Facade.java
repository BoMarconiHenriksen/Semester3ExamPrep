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
public class Facade {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ORMWithJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        //Laver entities med tomme tabeler i databasen.
        Persistence.generateSchema("com.mycompany_ORMWithJPA_war_1.0-SNAPSHOTPU", null);
        //Create a customer
        Customer customerOne = new Customer();
        customerOne.setName("Jens Hansen");
        customerOne.setEmail("jh@hotmail.com");
        
        
        String name= customerOne.getName();
        System.out.println(name);
//        createCustomer(customerOne, em);
//        Customer customerTwo = new Customer();
//        customerTwo.setName("Bodil Jensen");
//        customerTwo.setEmail("bj@gmail.com");
//        createCustomer(customerTwo, em);
//        findCustomer("jfh@hotmail.com", em);
        //System.out.println(findAllCustomers(em));
        //Ordre orderOne = new Ordre();
//        orderOne.setOrderId(1);
//        createOrder(orderOne, em);

//        Virker ikke
//        Ordre orderTwo = new Ordre();
//        orderTwo.setOrderId(2);
//        Integer customerId = 1;
//        orderTwo.setCustomerIdList(customerId);
//        createOrder(orderTwo, em);

        //ItemType produkt = new ItemType();
//        produkt.setName("Converse sko");
//        produkt.setDescription("En god gammel klassiker.");
//        produkt.setPrice(349.95);
//        createItemType(produkt, em);

//        OrderLine orderLine = new OrderLine();
//        orderLine.setQuantity(10);
//        
//        produkt.setItemTypeIdList();
//        createOrderLine(orderLine, produkt, em);
        
    }
    
    public static void createOrderLine(OrderLine orderLine, ItemType orderLineId, EntityManager em) {
        try {
            em.getTransaction().begin();
            em.persist(orderLine);
            em.getTransaction().commit();//commit kan smide exception
            
        } catch (Exception e) {
            System.out.println("Fejl ved commit!");
        } finally {
            em.close();
        }
    }
    
    public static void createItemType(ItemType itemType, EntityManager em) {
        try {
            em.getTransaction().begin();
            em.persist(itemType);
            em.getTransaction().commit();//commit kan smide exception
        } catch (Exception e) {
            System.out.println("Fejl ved commit!");
        } finally {
            em.close();
        }
    }

//    public static void addOrderToCustomer(Ordre order, EntityManager em) {
//        try {
//            
//            
//        } catch (Exception e) {
//            System.out.println("Fejl ved commit!");
//        } finally {
//            em.close();
//        }
//        
//    }
    public static void createOrder(Ordre order, EntityManager em) {
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();//commit kan smide exception

        } catch (Exception e) {
            System.out.println("Fejl ved commit!");
        } finally {
            em.close();
        }
    }
    
    public static List<Customer> findAllCustomers(EntityManager em) {
        List<Customer> customerList = null;
        
        try {
            Query q = em.createQuery("SELECT c FROM Customer c");
            customerList = q.getResultList();
            
        } catch (Exception e) {
            System.out.println("Der opstod en fejl!");
        }
        
        return customerList;
    }
    
    public static void findCustomer(String email, EntityManager em) {
        try {
            Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email");
            query.setParameter("email", email);
            
            Customer result = (Customer) query.getSingleResult();
            
            System.out.println("Customer Id: " + result.getId());
            System.out.println("Customer Name: " + result.getName());
            System.out.println("Customer Email: " + result.getEmail());
            
        } catch (Exception e) {
            System.out.println("The customer des not exist!");
        }
    }
    
    public static void createCustomer(Customer customer, EntityManager em) {
        
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();//commit kan smide exception

        } catch (Exception e) {
            System.out.println("Fejl ved commit!");
        } finally {
            em.close();
        }
        
    }
    
}
