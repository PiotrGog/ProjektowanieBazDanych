package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
public class Treasure {
    @PrimaryKey
    @GeneratedValue
    private int id;

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
