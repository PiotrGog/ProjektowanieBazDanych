package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Modifier {

    @PrimaryKey
    private String modName;

    @Column(allowsNull = "false")
    private String description;

    private int modValue;

    protected Modifier(String modName, String description, int modValue) {
        this.modName = modName;
        this.description = description;
        this.modValue = modValue;
    }

    public String getModName() {
        return modName;
    }

    public String getDescription() {
        return description;
    }

    public int getModValue() {
        return modValue;
    }

    public void setModValue(int modValue) {
        this.modValue = modValue;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description == "") {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
        this.description = description;
    }

    public void setModeName(String modName) throws IllegalArgumentException {
        if (modName == "") {
            throw new IllegalArgumentException("Modifer Name value can not be an empty string.");
        }
        this.modName = modName;
    }

    @Override
    public String toString() {
        return "Modifer: " +
                "modifer name=" + modName +
                ", modifer value=" + modValue +
                "\n" + description;
    }

    /**
     *
     * @param modName
     * @param description
     * @param modValue
     * @return
     */
    public static Modifier modifierFactory(String modName, String description, int modValue)
            throws IllegalArgumentException {
        if (description.equals("")) {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
        if (modName.equals("")) {
            throw new IllegalArgumentException("Modifer Name value can not be an empty string.");
        }

        return new Modifier(modName, description, modValue);
    }

    static public String[] modifiers =
            {"Attack modifier", "Def modifier", "Dexterity modifier", "Energy modifier", "Mana modifier",
                    "Health modifier", "Accuraty modifier", "Knowledge modifier", "Power modifier", "Thief modifier",
                    "Strong modifier", "Health regen modifier", "Mana regen modifier", "Toxic modifier",
                    "Eagle eye modifier", "Magical shield modifier", "Head modifier", "Helmet modifier",
                    "Gloves modifier", "Boots modifier", "Trousers modifier",
                    "Hard skin modifier", "Rock skin modifier", "Elixir modifier", "Spell modifier", "Bow modifier",
                    "Crossbow modifier", "Left hand modifier", "Right hand modifier", "Lucky modifier",
                    "Wisdom modifier", "Muscles modifier", "Two-handed weapon modifier", "Fire spells modifier",
                    "Water spells modifier", "Earth spells modifier", "Air spells modifier", "Mind spells modifier",
                    "Utility spells modifier", "Call spells modifier", "Move modifier"};

//    static public String[] stat = {"strength", "ability", "intellect", "prudence", "charisma", "construction"};

}
