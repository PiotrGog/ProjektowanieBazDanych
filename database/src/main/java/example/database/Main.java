package example.database;

import javax.persistence.*;
import java.util.List;

public class Main {

    static public void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("./db/database.odb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Product("JakisProdukt", 10));
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Product p");
        System.out.println("Total Products: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.price) FROM Product p");
        System.out.println("Average price: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> results = query.getResultList();
        for (Product p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();

    }
}
