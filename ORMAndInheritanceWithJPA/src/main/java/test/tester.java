package test;

import entities.Book;
import entities.EBook;
import entities.PaperBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bo
 */
public class tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        EntityManager em = emf.createEntityManager();

        //Laver entities med tomme tabeler i databasen.
//        Persistence.generateSchema("orm", null);
        //Create EBook
//        EBook ebook = new EBook();
//        ebook.setTitle("Heksejagt");
//        ebook.setSizeMB(12);
//        ebook.setAuthor("Arthur Miller");
//        ebook.setPrice(9.45);
//        ebook.setDownloadUrl("www.hj.dk/download");
//        createEBook(ebook);
        //Create paperBook
//        PaperBook paperbook = new PaperBook();
//        paperbook.setAuthor("Carla og Wilhelm Hansen");
//        paperbook.setInStock(12);
//        paperbook.setPrice(99.95);
//        paperbook.setShippingWeight(2);
//        paperbook.setTitle("Rasmus Klup på Eventyr");
//        createPaperBook(paperbook);
//        readEBook(1L, em);
//        readPaperBook(2L, em);
        //Update EBook
        //For det som ikke skal opdateres skrives der null. 
        //Dog for price og sizeMB skal der skrives 0, hvis det ikke skal opdaters. 
        //updateEbook(1L, null, "asb", 0, null, 0, em);
        
        //For det som ikke skal opdateres skrives der null. 
        //Dog for price, shippiingweight og inStock skal der skrives 0, hvis det ikke skal opdaters. 
        //updatePaperBook(2L, "Jeg blev opdateret", "Den Franske Opdatering", 0, 0, 10, em);
        
        deleteBook(3L, em);
    }

    public static void createEBook(EBook ebook) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(ebook);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Fejl i createEBook!");
        } finally {
            em.close();
        }

    }

    public static void createPaperBook(PaperBook paperBook) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(paperBook);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Fejl i createPaperBook!");
        } finally {
            em.close();
        }

    }

    public static void readEBook(Long isbn, EntityManager em) {
        Query query = em.createQuery("SELECT e FROM EBook e WHERE e.isbn = :isbn");
        query.setParameter("isbn", isbn);

        EBook result = (EBook) query.getSingleResult();

        System.out.println("ISBN: " + result.getIsbn());
        System.out.println("Title: " + result.getTitle());
        System.out.println("Forfatter: " + result.getAuthor());
        System.out.println("Pris: " + result.getPrice() + " kr.");
        System.out.println("Download url : " + result.getDownloadUrl());
        System.out.println("Størrelse i megabyte : " + result.getSizeMB() + " megabyte.");
        System.out.println("");//Hvis der udskrives flere bøger er der mellem rum mellem hver bog
    }

    public static void readPaperBook(Long isbn, EntityManager em) {
        Query query = em.createQuery("SELECT e FROM PaperBook e WHERE e.isbn = :isbn");
        query.setParameter("isbn", isbn);

        PaperBook result = (PaperBook) query.getSingleResult();

        System.out.println("ISBN: " + result.getIsbn());
        System.out.println("Title: " + result.getTitle());
        System.out.println("Forfatter: " + result.getAuthor());
        System.out.println("Pris: " + result.getPrice() + " kr.");
        System.out.println("Forsendelsesvægt : " + result.getShippingWeight());
        System.out.println("Antal på lager : " + result.getInStock());
        System.out.println(""); //Hvis der udskrives flere bøger er der et lille mellem rum mellem hver bog
    }

    public static void updateEbook(Long isbn, String title, String author, double price, String downloadUrl, int sizeMB, EntityManager em) {
        //Finder ebook ud fra isbn
        EBook ebook = em.find(EBook.class, isbn);
        
        //Tjekker for hvad der skal ændres og sætter de nye værdier
        if(title != null) {
            ebook.setTitle(title);
            System.out.println("Titlen er ændret til " + title);
            
        } if(author != null) {
            ebook.setAuthor(author);
            System.out.println("Forfatter er ændret til " + author);
            
        } if (price != 0) {
            ebook.setPrice(price);
            System.out.println("Prisen er ændret til " + price + "kr.");
            
        } if(downloadUrl != null) {
            ebook.setDownloadUrl(downloadUrl);
            System.out.println("download url er ændret til " + downloadUrl);
            
        } if (sizeMB != 0) {
            ebook.setSizeMB(sizeMB);
            System.out.println("Megabyte er ændret til " + sizeMB + "MB");
            
        } else {
            System.out.println("Ingen ændringer!");
        }
        
        //Ændringerne i det "nye" objekt merges med det gamle.
        em.getTransaction().begin();
        em.merge(ebook);
        em.getTransaction().commit();
    }
    
    public static void updatePaperBook(Long isbn, String title, String author, double price, double shippingWeight, int inStock, EntityManager em) {
        PaperBook paperBook = em.find(PaperBook.class, isbn);
        
        //Tjekker for hvad der skal ændres og sætter de nye værdier
        if(title != null) {
            paperBook.setTitle(title);
            System.out.println("Ændre er ændret til " + title);
            
        } if(author != null) {
            paperBook.setAuthor(author);
            System.out.println("Forfatter er ændret til " + author);
            
        } if (price != 0) {
            paperBook.setPrice(price);
            System.out.println("Prisen er ændret til " + price + "kr.");
            
        } if(shippingWeight != 0) {
            paperBook.setShippingWeight(shippingWeight);
            System.out.println("Forsendelsesvægt er ændret til " + shippingWeight);
            
        } if (inStock != 0) {
            paperBook.setInStock(inStock);
            System.out.println("Antal på lager er ændret til " + inStock);
            
        } else {
            System.out.println("Ingen ændringer!");
        }
        
        //Ændringerne i det "nye" objekt merges med det gamle.
        em.getTransaction().begin();
        em.merge(paperBook);
        em.getTransaction().commit();
    }
    
    //Metoden for delete og mit forsøg på  polymorphism
    public static void deleteBook(Long isbn, EntityManager em) {
        //Henter en liste af både ebook og paperbook
        Query query = em.createQuery("Select e FROM Book e WHERE e.isbn > 0");
        List<Book> result = query.getResultList();
        
        int id = isbn.intValue() - 1; //-1 da de ligger i en List
        Book book = result.get(id);
        
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        System.out.println(book.getTitle() + " af " + book.getAuthor() + " er nu slettet.");
    }

}
