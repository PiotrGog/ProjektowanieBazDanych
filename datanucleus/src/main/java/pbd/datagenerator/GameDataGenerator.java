package pbd.datagenerator;

import org.datanucleus.samples.jdo.tutorial.Book;
import org.datanucleus.samples.jdo.tutorial.Product;
import pbd.entity.*;
import pbd.entity.Character;
import pbd.entity.Class;

import javax.jdo.*;
import java.util.*;

public class GameDataGenerator {

    private Random random = new Random();

    private List<Race> racesList = new ArrayList<>();
    private List<Class> classesList = new ArrayList<>();
    private List<Specialization> specializationsList = new ArrayList<>();
    private List<Buff> buffsList = new ArrayList<>();
    private List<Modifier> modifiersList = new ArrayList<>();
    private List<Action> actionsList = new ArrayList<>();
    private List<Equipment> equipmentsList = new ArrayList<>();
    private List<Skill> skillsList = new ArrayList<>();
    private List<Quest> questList = new ArrayList<>();


    public void fillDatabase(String databaseName) {

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a Product and a Book.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            for (String[] s : Skill.skills) {
                Skill skill = makeSkill(s[0], s[1]);
                skillsList.add(skill);
                tx.begin();
                pm.makePersistent(skill);
                tx.commit();
            }


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

            for (String[] s : Action.actions) {
                Action action = makeAction(s[0], s[1]);
                actionsList.add(action);
                tx.begin();
                pm.makePersistent(action);
                tx.commit();
            }

            for (String s : Equipment.equipments) {
                Equipment equipment = makeEquipment(s);
                equipmentsList.add(equipment);
                tx.begin();
                pm.makePersistent(equipment);
                tx.commit();
            }

            for (String s : Quest.questDescritpion) {
                Quest quest = makeQuest(s);
                questList.add(quest);
                tx.begin();
                pm.makePersistent(quest);
                tx.commit();
            }


        } catch (Exception e) {
            System.out.println("Exception persisting data : " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        tx.begin();
        System.out.println("Executing Query for Products with price below 150.00");
        Query q = pm.newQuery("SELECT FROM " + Specialization.class.getName());
        List<Specialization> products = (List<Specialization>) q.execute();
        Iterator<Specialization> iter = products.iterator();
        while (iter.hasNext()) {
            Specialization p = iter.next();
            System.out.println(">  " + p);

            // Give an example of an update
            if (p instanceof Specialization) {
                System.out.println(p.getName());
            }
        }

        tx.commit();


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

    public Action makeAction(String name, String description) {
        return new Action(name, description, skillsList.get(Math.abs(random.nextInt()) % skillsList.size()));
    }

    public Equipment makeEquipment(String name) {
        ArrayList<String> set = new ArrayList<>(Zone.zones);
        Collections.shuffle(set);
        ArrayList<String> zones = new ArrayList<>();
        int r = 1 + (Math.abs(random.nextInt()) % 4);
        for (int i = 0; i < r; i++) {
            zones.add(set.remove(set.size() - 1));
        }

        ArrayList<Modifier> set1 = new ArrayList<>(modifiersList);
        Collections.shuffle(set1);
        ArrayList<Modifier> modif = new ArrayList<>();
        r = 1 + (Math.abs(random.nextInt()) % 10);
        for (int i = 0; i < r; i++) {
            modif.add(set1.remove(set1.size() - 1));
        }

        return new Equipment(name, zones, modif);
    }

    public Quest makeQuest(String description) {
        return new Quest(description.substring(0, 20), description.substring(0, 100),
                actionsList.get(Math.abs(random.nextInt()) % actionsList.size()));
    }

    public Skill makeSkill(String name, String description) {
        return new Skill(name, description.substring(0, 100));
    }

}
