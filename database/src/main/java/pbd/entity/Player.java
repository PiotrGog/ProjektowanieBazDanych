package pbd.entity;

import java.util.List;

public class Player extends Character {

    public Player(String name, int level, List<Quest> quests) {
        super(name, level);
        this.quests = quests;
    }

    private List<Quest> quests;
}
