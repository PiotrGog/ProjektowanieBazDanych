package pbd.entity;


import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import java.util.List;

@Entity
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

    private Race race;

    private Class class_;

    private Specialization specialization;

    private List<Equipment> bag;

    private List<Zone> zones;

    private List<Modifier> modifiers;


    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getPrudence() {
        return prudence;
    }

    public void setPrudence(int prudence) {
        this.prudence = prudence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConstruction() {
        return construction;
    }

    public void setConstruction(int construction) {
        this.construction = construction;
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
}
