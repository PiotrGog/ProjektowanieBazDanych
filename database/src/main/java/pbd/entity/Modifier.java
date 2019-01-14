package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Modifier {

    @PrimaryKey
    private String modName;

    @Column(allowsNull = "false")
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
