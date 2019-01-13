package pbd.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class NPC extends Character {

    private List<Quest> quests;

    public NPC(String name, int level, List<Quest> quests) {
        super(name, level);
        this.quests = quests;
    }
}
