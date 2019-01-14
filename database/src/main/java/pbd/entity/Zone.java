package pbd.entity;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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

    @EmbeddedId
    private ZoneId id;

    private Equipment equipment;

    public Zone(String name, Character character, Equipment equipment) {
        this.id = new ZoneId(name, character);
        this.equipment = equipment;
    }

    public String getName() {
        return id.name;
    }

    public Character getCharacter() {
        return id.character;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}

@Embeddable
class ZoneId {
    String name;
    Character character;

    public ZoneId(String name, Character character) {
        this.name = name;
        this.character = character;
    }
}
