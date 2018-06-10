package test;

import entities.Semester;
import static entities.Semester_.name;
import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bo
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

//        Persistence.generateSchema("com.mycompany_ORMandJPQL_war_1.0-SNAPSHOTPU", null);
        //getAllStudents();
        //getStudentByFistName("Anders");
        //New student
//        Semester semester = new Semester();
//        Student student = new Student();
//
//        student.setFirstname("Joe");
//        student.setLastname("Frasier");
//        semester.setId(3L);
//        student.setCurrentsemesterId(semester);
//
//        insertNewStudent(student);

//        findStudentByLastName("Henriksen");


    }
    
    public static void findStudentsBasedOnSemesterName(String semesterName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
//        TypedQuery<Semester> query = em.createNamedQuery("Semester.findByName", Semester.class)
//                .setParameter("name", name);
//        Semester result = query.getSingleResult();
//        result.getId();
        
        Query queryForStudents = em.createQuery("SELECT s FROM Semester s JOIN s.Student p JOIN e.projects p2 WHERE p.name = :p1 and p2.name = :p2");
        query.setParameter("currentsemester_Id", currentsemester_Id);

        Student<List> allStudents = query.getResultList();
    }

    public static void findStudentByLastName(String lastname) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> query = em.createNamedQuery("Student.findByLastname", Student.class)
                .setParameter("lastname", lastname);
        List<Student> result = query.getResultList();

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Alle efternavne med " + lastname + " som er i listen: "
                    + result.get(i).getLastname() + " " + result.get(i).getFirstname());
        }
    }

    public static void insertNewStudent(Student student) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            em.close();
        }

    }

    public static void getStudentByFistName(String firstname) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> query = em.createNamedQuery("Student.findByFirstname", Student.class)
                .setParameter("firstname", firstname);
        List<Student> result = query.getResultList();

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Alle navne med " + firstname + " som er i listen: " + result.get(i).getFirstname() + " "
                    + result.get(i).getLastname());
        }
    }

    public static void getAllStudents() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> result = query.getResultList();

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Student Name: " + result.get(i).getFirstname() + " " + result.get(i).getLastname());
        }
    }

}
