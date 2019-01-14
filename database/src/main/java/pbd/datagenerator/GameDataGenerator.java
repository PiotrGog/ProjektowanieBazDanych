package pbd.datagenerator;

import pbd.entity.*;
import pbd.entity.Character;
import pbd.entity.Class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDataGenerator {

    private Random random = new Random();

    private List<Race> racesList = new ArrayList<>();
    private List<Class> classesList = new ArrayList<>();
    private List<Specialization> specializationsList = new ArrayList<>();

    public void fillDatabase(String databaseName) {

        File file = new File("./db/" + databaseName + ".odb");
        if (file.delete()) {
            System.out.println("./db/" + databaseName + ".odb File deleted");
        } else {
            System.out.println("File ./db/" + databaseName + ".odb doesn't exists");
        }
        file = new File("./db/" + databaseName + ".odb$");
        if (file.delete()) {
            System.out.println("./db/$" + databaseName + ".odb File deleted");
        } else {
            System.out.println("File ./db/$" + databaseName + ".odb doesn't exists");
        }


        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("./db/" + databaseName + ".odb");
        EntityManager em = emf.createEntityManager();


        for (String s : Specialization.specializations) {
            Specialization spec = Specialization.specializationFactory(s);
            specializationsList.add(spec);
            em.getTransaction().begin();
            em.persist(spec);
            em.getTransaction().commit();
        }

        for (String s : Class.classes) {
            Class cla = Class.classFactory(s);
            classesList.add(cla);
            em.getTransaction().begin();
            em.persist(cla);
            em.getTransaction().commit();
        }

        for (String s : Race.races) {
            Race ra = Race.raceFactory(s);
            racesList.add(ra);
            em.getTransaction().begin();
            em.persist(ra);
            em.getTransaction().commit();
        }

        em.getTransaction().begin();
        em.persist(makePlayer("kjkfsajlfjsd"));
        em.getTransaction().commit();

//
//        em.getTransaction().begin();
//        em.persist(new Team("team1", Collections.singletonList(ch)));
//        em.getTransaction().commit();
//
//
//        // Find the number of Point objects in the database:
//        Query q1 = em.createQuery("SELECT COUNT(t) FROM Team t");
//        System.out.println("Total Products: " + q1.getSingleResult());
//
//        // Find the average X value:
//        Query q2 = em.createQuery("SELECT (t.teamName) FROM Team t");
//        System.out.println("Average price: " + q2.getResultList().get(0));

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


    public Player makePlayer(String name) {

        Race race = racesList.get(Math.abs(random.nextInt()) % racesList.size());

        String cString = Race.availableClasses.get(race.getName().toLowerCase())
                .get(Math.abs(random.nextInt()) % Race.availableClasses.get(race.getName().toLowerCase()).size());
        Class cl = null;
        int i = 0;
        while (cl == null) {
            if (classesList.get(i).getName().equalsIgnoreCase(cString)) {
                cl = classesList.get(i);
            }
            i++;
        }

        String sString = Class.availableSpecializations.get(cString)
                .get(Math.abs(random.nextInt()) % Class.availableSpecializations.get(cString).size());
        Specialization sp = null;
        i = 0;
        while (sp == null) {
            if (specializationsList.get(i).getName().equalsIgnoreCase(sString)) {
                sp = specializationsList.get(i);
            }
            i++;
        }

        return Player.playerFactory(name, Math.abs(random.nextInt()) % 20, Math.abs(random.nextInt()) % 20, Math.abs(random.nextInt()) % 20,
                Math.abs(random.nextInt()) % 20, Math.abs(random.nextInt()) % 20, Math.abs(random.nextInt()) % 20, Math.abs(random.nextInt()) % 20, race, cl,
                sp, new ArrayList<Equipment>(), new ArrayList<Zone>(), new ArrayList<Modifier>(),
                new ArrayList<Quest>());

    }



}
