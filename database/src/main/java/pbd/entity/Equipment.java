package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import java.util.List;

@PersistenceCapable
public class Equipment {
    @PrimaryKey
    private String equipmentName;

    @Column(allowsNull = "false")
    private List<String> zones;

    @Column(allowsNull = "false")
    private List<Modifier> modifiers;

    public String getEquipmentName() {
        return equipmentName;
    }

    public List<String> getZones() {
        return zones;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }
}
