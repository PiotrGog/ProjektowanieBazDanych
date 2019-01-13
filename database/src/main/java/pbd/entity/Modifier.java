package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Modifier {

    @PrimaryKey
    private String modName;

    private String description;

    private int modValue;

    public Modifier(String modName, String description, int modValue) {
        this.modName = modName;
        this.description = description;
        this.modValue = modValue;
    }

    public String getModName() {
        return modName;
    }

    public String getDescription() {
        return description;
    }

    public int getModValue() {
        return modValue;
    }
}
