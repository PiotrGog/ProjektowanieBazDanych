package pbd.datagenerator;

import pbd.entity.*;
import pbd.entity.Character;
import pbd.entity.Class;

import javax.jdo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDataGenerator {

    private Random random = new Random();

    private List<Race> racesList = new ArrayList<>();
    private List<Class> classesList = new ArrayList<>();
    private List<Specialization> specializationsList = new ArrayList<>();

    private List<Buff> buffsList = new ArrayList<>();
    private List<Modifier> modifiersList = new ArrayList<>();

    public void fillDatabase(String databaseName) {

//        File file = new File("./db/" + databaseName + ".odb");
//        if (file.delete()) {
//            System.out.println("./db/" + databaseName + ".odb File deleted");
//        } else {
//            System.out.println("File ./db/" + databaseName + ".odb doesn't exists");
//        }
//        file = new File("./db/" + databaseName + ".odb$");
//        if (file.delete()) {
//            System.out.println("./db/$" + databaseName + ".odb File deleted");
//        } else {
//            System.out.println("File ./db/$" + databaseName + ".odb doesn't exists");
//        }

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a Product and a Book.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            for (String s : Specialization.specializations) {
                Specialization spec = Specialization.specializationFactory(s);
                specializationsList.add(spec);
                tx.begin();
                pm.makePersistent(spec);
                tx.commit();
            }

            for (String s : Class.classes) {
                Class cla = Class.classFactory(s);
                classesList.add(cla);
                tx.begin();
                pm.makePersistent(cla);
                tx.commit();
            }

            for (String s : Race.races) {
                Race ra = Race.raceFactory(s);
                racesList.add(ra);
                tx.begin();
                pm.makePersistent(ra);
                tx.commit();
            }

            for (String s : Modifier.modifiers) {
                Modifier mod = makeModifier(s);
                modifiersList.add(mod);
                tx.begin();
                pm.makePersistent(mod);
                tx.commit();
            }

            for (String[] s : Buff.buffs) {
                Buff buff = makeBuff(s[0], s[1]);
                buffsList.add(buff);
                tx.begin();
                pm.makePersistent(buff);
                tx.commit();
            }
            System.out.println("Inventory, Product and Book have been persisted");
        } catch (Exception e) {
            System.out.println("Exception persisting data : " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");


        pmf.close();


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
        return (Player) Character
                .characterFactory(name, 1 + Math.abs(random.nextInt()) % 20, 1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20, 1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20, race, cl,
                        sp, new ArrayList<Equipment>(), new ArrayList<Modifier>(),
                        new ArrayList<Quest>(), "player");
    }


    public NPC makeNPC(String name) {
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
        return (NPC) Character
                .characterFactory(name, 1 + Math.abs(random.nextInt()) % 20, 1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20, 1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20,
                        1 + Math.abs(random.nextInt()) % 20, race, cl,
                        sp, new ArrayList<Equipment>(), new ArrayList<Modifier>(),
                        new ArrayList<Quest>(), "npc");
    }


    public Buff makeBuff(String name, String description) {
        return Buff
                .buffFactory(name, description, Math.abs(random.nextInt()) % 30, 5 + Math.abs(random.nextInt()) % 10);
    }

    public Modifier makeModifier(String name) {
        return Modifier.modifierFactory(name, name, Math.abs(random.nextInt()) % 30);
    }

}
