package pbd;


import example.database.Product;
import pbd.entity.Character;
import pbd.entity.Team;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static public void main(String[] args){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("./db/game_db.odb");
        EntityManager em = emf.createEntityManager();

        Character ch = new Character("character1", 10);
        em.getTransaction().begin();
        em.persist(ch);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(new Team("team1", Collections.singletonList(ch)));
        em.getTransaction().commit();


        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(t) FROM Team t");
        System.out.println("Total Products: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT (t.teamName) FROM Team t");
        System.out.println("Average price: " + q2.getResultList().get(0));

//        // Retrieve all the Point objects from the database:
//        TypedQuery<Product> query =
//                em.createQuery("SELECT p FROM Product p", Product.class);
//        List<Product> results = query.getResultList();
//        for (Product p : results) {
//            System.out.println(p);
//        }

        // Close the database connection:
        em.close();
        emf.close();

    }
}
