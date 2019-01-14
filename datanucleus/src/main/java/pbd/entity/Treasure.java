package pbd.entity;

import javax.jdo.annotations.*;
import java.util.List;

@PersistenceCapable
public class Treasure {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
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
