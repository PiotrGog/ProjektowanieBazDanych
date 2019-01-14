package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.GeneratedValue;
import java.util.List;

@PersistenceCapable
public class Treasure {
    @PrimaryKey
    @GeneratedValue
    private int id;

    @Column(allowsNull = "false")
    private List<Equipment> equipmentInside;

    public int getId() {
        return id;
    }

    public List<Equipment> getEquipmentInside() {
        return equipmentInside;
    }

    public Treasure(List<Equipment> equipmentInside) {

        this.equipmentInside = equipmentInside;
    }
}
