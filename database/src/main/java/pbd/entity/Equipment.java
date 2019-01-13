package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Equipment {
    @PrimaryKey
    private String equipmentName;

    private List<String> zones;

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
