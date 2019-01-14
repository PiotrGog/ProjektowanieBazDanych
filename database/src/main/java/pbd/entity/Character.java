package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@PersistenceCapable
public class Character {

    @PrimaryKey
    private String name;

    private int level;

    private int strength;

    private int ability;

    private int intellect;

    private int prudence;

    private int charisma;

    private int construction;

    @Column(allowsNull = "false")
    private Race race;

    @Column(allowsNull = "false")
    private Class class_;

    @Column(allowsNull = "false")
    private Specialization specialization;

    @Column(allowsNull = "false")
    private List<Equipment> bag;

    @Column(allowsNull = "false")
    private List<Zone> zones;

    @Column(allowsNull = "false")
    private List<Modifier> modifiers;

    @Column(allowsNull = "false")
    private List<Quest> quests;

    public Character(String name, int level, int strength, int ability, int intellect, int prudence, int charisma,
                        int construction, Race race, Class class_, Specialization specialization,
                        List<Equipment> bag, List<Modifier> modifiers, List<Quest> quests) {
        this.name = name;
        this.setLevel(level);
        this.setStrength(strength);
        this.setAbility(ability);
        this.setIntellect(intellect);
        this.setPrudence(prudence);
        this.setCharisma(charisma);
        this.setConstruction(construction);
        this.race = race;
        this.class_ = class_;
        this.specialization = specialization;
        this.bag = bag;
        this.zones = createAllCharacterZones(this);
        this.modifiers = modifiers;
        this.quests = quests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException, NullPointerException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty.");
        }
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws IllegalArgumentException {
        if (level < 1) {
            throw new IllegalArgumentException("Level value can not be less than 1.");
        }
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) throws IllegalArgumentException {
        if (strength < 1) {
            throw new IllegalArgumentException("Strength value can not be less than 1.");
        }
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) throws IllegalArgumentException {
        if (ability < 1) {
            throw new IllegalArgumentException("Ability value can not be less than 1.");
        }
        this.ability = ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) throws IllegalArgumentException {
        if (intellect < 1) {
            throw new IllegalArgumentException("Intellect value can not be less than 1.");
        }
        this.intellect = intellect;
    }

    public int getPrudence() {
        return prudence;
    }

    public void setPrudence(int prudence) throws IllegalArgumentException {
        if (prudence < 1) {
            throw new IllegalArgumentException("Prudence value can not be less than 1.");
        }
        this.prudence = prudence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) throws IllegalArgumentException {
        if (charisma < 1) {
            throw new IllegalArgumentException("Charisma value can not be less than 1.");
        }
        this.charisma = charisma;
    }

    public int getConstruction() {
        return construction;
    }

    public void setConstruction(int construction) throws IllegalArgumentException {
        if (construction < 1) {
            throw new IllegalArgumentException("Construction value can not be less than 1.");
        }
        this.construction = construction;
    }

    public Race getRace() {
        return race;
    }

    public Class getClass_() {
        return class_;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public List<Equipment> getBag() {
        return bag;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public Set<Equipment> putOnEquipment(Equipment equipment) {
        Set<String> zones = new TreeSet<>(equipment.getZones());
        Set<Equipment> previousEquipment = new TreeSet<>();
        for (Zone z : this.zones) {
            if (zones.contains(z.getName())) {
                if (null != z.getEquipment()) {
                    previousEquipment.add(z.getEquipment());
                }
                z.setEquipment(equipment);
            }
        }
        return previousEquipment;
    }




    public int getSumStrength() {
        return strength + class_.getStrength() + race.getStrength() + specialization.getStrength();
    }

    public int getSumAbility() {
        return ability + class_.getAbility() + race.getAbility() + specialization.getAbility();
    }

    public int getSumIntellect() {
        return intellect + class_.getIntellect() + race.getIntellect() + specialization.getIntellect();
    }

    public int getSumPrudence() {
        return prudence + class_.getPrudence() + race.getPrudence() + specialization.getPrudence();
    }

    public int getSumCharisma() {
        return charisma + class_.getCharisma() + race.getCharisma() + specialization.getCharisma();
    }

    public int getSumConstruction() {
        return construction + class_.getConstruction() + race.getConstruction() + specialization.getConstruction();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    public static Character characterFactory(String name, int level, int strength, int ability, int intellect,
                                             int prudence, int charisma,
                                             int construction, String race, String class_, String specialization,
                                             List<Equipment> bag, List<Zone> zones, List<Modifier> modifiers,
                                             List<Quest> quests)
            throws IllegalArgumentException {

        List<String> availableClasses = Race.availableClasses.get(race);
        List<String> availableSpecializations = Class.availableSpecializations.get(class_);
        if (null == availableClasses) {
            throw new IllegalArgumentException("Race " + race + " is not defined.");
        }
        if (null == availableSpecializations) {
            throw new IllegalArgumentException("Class " + class_ + " is not defined.");
        }
        if (!availableClasses.contains(class_)) {
            throw new IllegalArgumentException(
                    "Combination race" + race + " and class " + class_ + " is not available.");
        }
        if (!availableSpecializations.contains(specialization)) {
            throw new IllegalArgumentException(
                    "Combination class" + class_ + " and specialization " + specialization + " is not available.");
        }

        return new Character(name, level, strength, ability, intellect, prudence, charisma, construction,
                Race.raceFactory(race), Class.classFactory(class_),
                Specialization.specializationFactory(specialization), bag, modifiers, quests);
    }

    public static Character characterFactory(String name, int level, int strength, int ability, int intellect,
                                             int prudence, int charisma,
                                             int construction, Race race, Class class_, Specialization specialization,
                                             List<Equipment> bag, List<Modifier> modifiers,
                                             List<Quest> quests, String characterType)
            throws IllegalArgumentException {

//        List<String> availableClasses = Race.availableClasses.get(race);
//        List<String> availableSpecializations = Class.availableSpecializations.get(class_);
//        if (null == availableClasses) {
//            throw new IllegalArgumentException("Race " + race + " is not defined.");
//        }
//        if (null == availableSpecializations) {
//            throw new IllegalArgumentException("Class " + class_ + " is not defined.");
//        }
//        if (!availableClasses.contains(class_)) {
//            throw new IllegalArgumentException(
//                    "Combination race" + race + " and class " + class_ + " is not available.");
//        }
//        if (!availableSpecializations.contains(specialization)) {
//            throw new IllegalArgumentException(
//                    "Combination class" + class_ + " and specialization " + specialization + " is not available.");
//        }

        if ("player".equalsIgnoreCase(characterType)) {
            return new Player(name, level, strength, ability, intellect, prudence, charisma, construction,
                    race, class_, specialization, bag, modifiers, quests);
        } else if ("npc".equalsIgnoreCase(characterType)) {
            return new NPC(name, level, strength, ability, intellect, prudence, charisma, construction,
                    race, class_, specialization, bag, modifiers, quests);
        }
        return null;
    }

    protected List<Zone> createAllCharacterZones(Character character) {
        ArrayList<Zone> characterZones = new ArrayList<>();
        for (String z : Zone.zones) {
            characterZones.add(new Zone(z, character, null));
        }
        return characterZones;
    }
}
