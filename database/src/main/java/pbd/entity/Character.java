package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Character {
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

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    @PrimaryKey
    private String name;

    private int level;

}
