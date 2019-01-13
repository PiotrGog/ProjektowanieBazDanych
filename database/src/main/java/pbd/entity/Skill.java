package pbd.entity;


import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Skill {

    @PrimaryKey
    private String name;

    private String descritpion;

    public Skill(String name, String descritpion) {
        this.name = name;
        this.descritpion = descritpion;
    }

    public String getName() {
        return name;
    }

    public String getDescritpion() {
        return descritpion;
    }
}
