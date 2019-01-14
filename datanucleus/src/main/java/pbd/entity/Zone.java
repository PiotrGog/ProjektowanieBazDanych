package pbd.entity;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PersistenceCapable
public class Zone {
    static public List<String> zones = new ArrayList<>(
            Arrays.asList("Left Foot", "Right foot", "Left leg", "Right leg", "Belt", "Left hand", "Right hand",
                    "Left forearm", "Right forearm", "Left arm", "Right arm", "Trunk", "Neck", "Left ear", "Right ear",
                    "Left finger", "Right finger",
                    "Tail", "Eyes"));

//    @EmbeddedId
//    private ZoneId id;

    String name;
    Character character;

    private Equipment equipment;

    public Zone(String name, Character character, Equipment equipment) {
//        this.id = new ZoneId(name, character);
        this.name = name;
        this.character = character;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}

@PersistenceCapable(objectIdClass=Zone.class)
class ZoneId {
    @PrimaryKey
    String name;
    @PrimaryKey
    Character character;

    public ZoneId(String name, Character character) {
        this.name = name;
        this.character = character;
    }
}
