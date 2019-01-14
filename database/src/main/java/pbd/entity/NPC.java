package pbd.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class NPC extends Character {
    public NPC(String name, int level, int strength, int ability, int intellect, int prudence, int charisma,
               int construction, Race race, Class class_, Specialization specialization,
               List<Equipment> bag, List<Zone> zones, List<Modifier> modifiers, List<Quest> quests) {
        super(name, level, strength, ability, intellect, prudence, charisma, construction, race, class_, specialization,
                bag, zones, modifiers, quests);
    }
}
