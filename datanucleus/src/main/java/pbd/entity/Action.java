package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Action {
    @PrimaryKey
    private String name;

    @Column(allowsNull = "false")
    private String description;

    @Column(allowsNull = "false")
    private Skill requiredSkill;

    public Action(String name, String description, Skill requiredSkill) {
        this.name = name;
        this.description = description;
        this.requiredSkill = requiredSkill;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static String[][] actions = {{"Attack",
            "Attack another object"}, {"Block", "Block some attack"},
            {"Throw spell", "Throw spell from your magic book"}, {"Move forward", "Do one step forward"},
            {"Move backward", "Do one step backward"}, {"Move left", "Do one step left"},
            {"Move right", "Do one step right"}, {"Move left front", "Do one step diagonally to left front"},
            {"Move left back", "Do one step diagonally to left back"},
            {"Move right front", "Do one step diagonally to right front"},
            {"Move right back", "Do ne step diagonally to right back"}, {"Talk", "Talk to some champion"},
            {"Bait", "Provoke some champion"}, {"pick up", "Pick up some item"}, {"Throw up", "Throw up some item"},
            {"Accept quest", "Accept some quest from principal"}, {"Sleep", "Sleep for some time"},
            {"Fight", "Start fight with some other player"}, {"Jump", "Just jump"},
            {"Sit", "Sit at some object prepared to do id"}, {"Dig", "Dig to find some brecleaus"},
            {"Bow shot", "Shot from a bow"}, {"Crossbow shot", "Shot from a crossbow"}, {"Wear", "Wear some item"},
            {"Get reward", "Get reward for some quest"}, {"Get on ship", "Just get on ship"},
            {"Get on horse", "Just get on horse"}, {"Get on dragon", "Just get on some dragon"},
            {"Some cigarette", "Relax"}, {"Eat", "Eat something"}, {"Drink", "Drink something"},
            {"Take elixir", "Drink some elixir"}, {"Buff", "Buff someon or someone else"},
            {"Learn spell", "Learn some spell"}, {"Learn skill", "Learn some skill"},
            {"Get a level", "Get a new level"}, {"Complete quest", "Complete some quest"},
            {"Read", "Read book or scroll"}, {"Write", "Write on book or on scroll"},
            {"Send", "Send message to someon"}, {"Call horse", "Order your horse to come to you"}};
}
