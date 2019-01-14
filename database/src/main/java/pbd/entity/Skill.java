package pbd.entity;


import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@PersistenceCapable
public class Skill {

    @PrimaryKey
    private String name;

    @Column(allowsNull = "false")
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
