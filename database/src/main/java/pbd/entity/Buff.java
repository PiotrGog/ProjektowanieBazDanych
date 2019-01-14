package pbd.entity;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Buff extends Modifier {

    private int duration;

    protected Buff(String modName, String description, int modValue, int duration) {
        super(modName, description, modValue);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws IllegalArgumentException, NullPointerException {
        if (duration < 1) {
            throw new IllegalArgumentException("Duration value can not be less than 1.");
        }
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Buff: " +
                "buff name=" + super.getModName() +
                ", buff value=" + super.getModValue() +
                ", buff time=" + duration + " rounds";
    }

    public static Buff buffFactory(String modName, String description, int modValue, int duration)
            throws IllegalArgumentException {
        if (description.equals("")) {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
        if (modName.equals("")) {
            throw new IllegalArgumentException("Modifier Name value can not be an empty string.");
        }
        if (duration < 1) {
            throw new IllegalArgumentException("Duration value can not be less than 1.");
        }
        return new Buff(modName, description, modValue, duration);
    }


    static public String[][] buffs =
            {{"Attack upgrage", "Upgrade your attack skill"}, {"Def upgrade", "Upgrade your defence skill"},
                    {"Dexterity upgrade", "Upgrade your dexterity skill"},
                    {"Power upgrade", "Upgrade your magic power"}, {"Knowledge upgrade", "Upgrade your knowledge"},
                    {"Health upgrade", "Upgrade your maximum level of health"},
                    {"Thief skills upgrade", "Upgrade your thief skills"},
                    {"Mana upgrade", "Upgrade your maximum level of mana"},
                    {"Right hand upgrade", "Upgrade one-handed weapon skills"},
                    {"Left hand upgrade", "Upgrade shield using skills"},
                    {"Strong muscles", "Two-handed weapon upgrade"},
                    {"Heavy armor upgrade", "Upgrade statistics of heavy armor"},
                    {"Med armor upgrade", "Upgrade statistics of medium armor"},
                    {"Light armor upgrade", "Upgrade statistics of light armor"},
                    {"Eagle eye", "Upgrade your accurity"},
                    {"Long seeing", "You can see further"}, {"7-miles shoues", "You can go thru 2 fields in one move"},
                    {"Troll regeneration", "Your health regenerates 2x faster"},
                    {"Mana regeneration", "Your mana regenerates 2x faster"},
                    {"Usain Bolt", "Your energy regenerates 2x faster"}, {"Good taste", "Food and drinks work faster"},
                    {"Toxic blood", "Elixirs work faster"}, {"Strong head", "Alkohol doesn't work"},
                    {"Rock skin", "Arrows mean nothing to you"}, {"Magic shield", "Magical damage reduced to 50%"},
                    {"Hard skin", "Physical damages reduced to 50%"}, {"Golem", "Physical damages reduced to 10%"},
                    {"Quick hands", "You can do 2 attacks in one move"}, {"Better helmets", "Helmets work better"},
                    {"Better boots", "Boots work better"}, {"Better gloves", "Gloves work better"},
                    {"Better trousers", "Trousers work better"}};
}
