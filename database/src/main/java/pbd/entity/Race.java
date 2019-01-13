package pbd.entity;


import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Race {

    @PrimaryKey
    private String name;

    private String description;

    private int strength;

    private int ability;

    private int intellect;

    private int prudence;

    private int charisma;

    private int construction;

    public Race(String name, String description, int strength, int ability, int intellect, int prudence, int charisma, int construction) {
        this.name = name;
        this.description = description;
        this.setStrength(strength);
        this.setAbility(ability);
        this.setIntellect(intellect);
        this.setPrudence(prudence);
        this.setCharisma(charisma);
        this.setConstruction(construction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
}
