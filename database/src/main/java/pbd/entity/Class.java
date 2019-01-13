package pbd.entity;


import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Class {

    final static public Map<String, List<String>> validSpecializations = new HashMap<>();

    static {
        validSpecializations.put("hunter",
                Arrays.asList("The Barbarian", "The Monster Knight", "The Samurai", "The Warlord", "The Cavalier",
                        "The Rebel"));
        validSpecializations.put("cleric",
                Arrays.asList("The Hero", "The Inherent Gift Magician", "The Theurgist", "The Summoner",
                        "The Vancian Magician"));
        validSpecializations.put("assassin",
                Arrays.asList("The Battle Priest", "The Witch Doctor", "The Templar", "The Caster",
                        "The Sniper Ranger"));
        validSpecializations.put("ninja",
                Arrays.asList("The Bow and Blade Ranger", "The Dual Wielding Ranger", "The Beast Master Ranger"));
        validSpecializations.put("thief",
                Arrays.asList("The Summoner Ranger", "The Trapper Ranger", "The Magical Ranger", "The Magic Knight"));
        validSpecializations.put("magus",
                Arrays.asList("The Battle Mage", "The Bard", "The Dancer", "The Cantor", "The Skald", "The Monk",
                        "The Beast"));
        validSpecializations.put("magician",
                Arrays.asList("The Engineer", "The Alchemist", "The Gunslinger", "The Gun Mage", "The Psychic"));
        validSpecializations.put("warlock",
                Arrays.asList("The Elementalist", "The Druid", "The Shaman", "The Thief", "The Assassin",
                        "The Gambler"));
        validSpecializations.put("wizard",
                Arrays.asList("The Beastmaster", "The Scholar"));
        validSpecializations.put("mage",
                Arrays.asList("The Illusionist", "The Nature Magician", "The Scout", "The Priest"));
        validSpecializations.put("soldier",
                Arrays.asList("The Knight", "The Warden", "The Swashbuckler", "The Paladin", "The Dark Knight",
                        "The Dragon Knight"));
        validSpecializations.put("knight",
                Arrays.asList("The Ninja", "The Shadow", "The Bandit", "The Pirate"));
        validSpecializations.put("warrior",
                Arrays.asList("The Red Mage", "The Blue Mage", "The Necromancer"));
    }

    @PrimaryKey
    private String name;

    private String description;

    private int strength;

    private int ability;

    private int intellect;

    private int prudence;

    private int charisma;

    private int construction;

    protected Class(String name, String description, int strength, int ability, int intellect, int prudence,
                    int charisma,
                    int construction) {
        this.name = name;
        this.description = description;
        this.setStrength(strength);
        this.setAbility(ability);
        this.setIntellect(intellect);
        this.setPrudence(prudence);
        this.setCharisma(charisma);
        this.setConstruction(construction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getPrudence() {
        return prudence;
    }

    public void setPrudence(int prudence) {
        this.prudence = prudence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConstruction() {
        return construction;
    }

    public void setConstruction(int construction) {
        this.construction = construction;
    }

    public static Class classFactory(String className) {
        switch (className.toLowerCase()) {
            case "warrior":
                return new Class("Warrior", "One of the most basic classes, " +
                        "the Fighter puts emphasis on strength and physical combat. " +
                        "Weilding melee weapons, they typically lack range, or have only limited ranged attack options," +
                        " but they excel at fighting enemies in close range combat, often having high HP, defense, " +
                        "and attack capabilities to aid in this. In a team or party based game they put themselves " +
                        "at risk at the front of the group and take the brunt of the damage meant for their less sturdy" +
                        " comrades. A Fighter's strength is boosted by the wide variety of equipment they can use and " +
                        "they are usually able to equip the widest variety of weaponry and armor, including stuff too" +
                        " heavy for other classes. Most of the time the Fighter is considered the default \"hero\" " +
                        "class and as such they are often considered good for beginners.",
                        20, 10, 4, 5, 7, 1);
            case "knight":
                return new Class("Knight", "One of the most basic classes, " +
                        "the Fighter puts emphasis on strength and physical combat. " +
                        "Weilding melee weapons, they typically lack range, or have only limited ranged attack options," +
                        " but they excel at fighting enemies in close range combat, often having high HP, defense, " +
                        "and attack capabilities to aid in this. In a team or party based game they put themselves " +
                        "at risk at the front of the group and take the brunt of the damage meant for their less sturdy" +
                        " comrades. A Fighter's strength is boosted by the wide variety of equipment they can use and " +
                        "they are usually able to equip the widest variety of weaponry and armor, including stuff too" +
                        " heavy for other classes. Most of the time the Fighter is considered the default \"hero\" " +
                        "class and as such they are often considered good for beginners.",
                        20, 10, 4, 5, 7, 1);
            case "soldier":
                return new Class("Soldier", "One of the most basic classes, " +
                        "the Fighter puts emphasis on strength and physical combat. " +
                        "Weilding melee weapons, they typically lack range, or have only limited ranged attack options," +
                        " but they excel at fighting enemies in close range combat, often having high HP, defense, " +
                        "and attack capabilities to aid in this. In a team or party based game they put themselves " +
                        "at risk at the front of the group and take the brunt of the damage meant for their less sturdy" +
                        " comrades. A Fighter's strength is boosted by the wide variety of equipment they can use and " +
                        "they are usually able to equip the widest variety of weaponry and armor, including stuff too" +
                        " heavy for other classes. Most of the time the Fighter is considered the default \"hero\" " +
                        "class and as such they are often considered good for beginners.",
                        20, 10, 4, 5, 7, 1);
            case "mage":
                return new Class("Mage", "One of the most basic classes, " +
                        "By whatever name you know this class by, you know this class: they" +
                        " primarily use magic powers. In any game with classes, there will " +
                        "always be one that maps to the Magician. These have the widest variety of any set" +
                        " of role-playing classes simply because there are so many varieties of Functional Magic." +
                        " In a Fantasy Kitchen Sink setting, there can potentially be an infinite number of " +
                        "magic users, so long as there is justification for considering them each their own type. " +
                        "A Magician is usually a Glass Cannon, blasting away at long range, " +
                        "but easily taken down at close range.",
                        10, 5, 20, 5, 10, 1);
            case "wizard":
                return new Class("Wizard", "One of the most basic classes, " +
                        "By whatever name you know this class by, you know this class: they" +
                        " primarily use magic powers. In any game with classes, there will " +
                        "always be one that maps to the Magician. These have the widest variety of any set" +
                        " of role-playing classes simply because there are so many varieties of Functional Magic." +
                        " In a Fantasy Kitchen Sink setting, there can potentially be an infinite number of " +
                        "magic users, so long as there is justification for considering them each their own type. " +
                        "A Magician is usually a Glass Cannon, blasting away at long range, " +
                        "but easily taken down at close range.",
                        10, 5, 20, 5, 10, 1);
            case "warlock":
                return new Class("Warlock", "One of the most basic classes, " +
                        "By whatever name you know this class by, you know this class: they" +
                        " primarily use magic powers. In any game with classes, there will " +
                        "always be one that maps to the Magician. These have the widest variety of any set" +
                        " of role-playing classes simply because there are so many varieties of Functional Magic." +
                        " In a Fantasy Kitchen Sink setting, there can potentially be an infinite number of " +
                        "magic users, so long as there is justification for considering them each their own type. " +
                        "A Magician is usually a Glass Cannon, blasting away at long range, " +
                        "but easily taken down at close range.",
                        10, 5, 20, 5, 10, 1);
            case "magician":
                return new Class("Magician", "One of the most basic classes, " +
                        "By whatever name you know this class by, you know this class: they" +
                        " primarily use magic powers. In any game with classes, there will " +
                        "always be one that maps to the Magician. These have the widest variety of any set" +
                        " of role-playing classes simply because there are so many varieties of Functional Magic." +
                        " In a Fantasy Kitchen Sink setting, there can potentially be an infinite number of " +
                        "magic users, so long as there is justification for considering them each their own type. " +
                        "A Magician is usually a Glass Cannon, blasting away at long range, " +
                        "but easily taken down at close range.",
                        10, 5, 20, 5, 10, 1);
            case "magus":
                return new Class("Magus", "One of the most basic classes, " +
                        "By whatever name you know this class by, you know this class: they" +
                        " primarily use magic powers. In any game with classes, there will " +
                        "always be one that maps to the Magician. These have the widest variety of any set" +
                        " of role-playing classes simply because there are so many varieties of Functional Magic." +
                        " In a Fantasy Kitchen Sink setting, there can potentially be an infinite number of " +
                        "magic users, so long as there is justification for considering them each their own type. " +
                        "A Magician is usually a Glass Cannon, blasting away at long range, " +
                        "but easily taken down at close range.",
                        10, 5, 20, 5, 10, 1);

            case "thief":
                return new Class("Thief", "Rogues are a diverse class that contains " +
                        "everything from dexterous thieves, to treasure-hunters, to assassins. " +
                        "Masters of stealth and infiltration, Rogues prefer to attack when their opponent is " +
                        "least aware. They are quick but fragile, unable to take heavy damage, and instead rely " +
                        "on their speed to dodge attacks and slip in and out of the shadows to catch their " +
                        "opponent off guard; setting traps and inflicting status effects on foes to give them the edge." +
                        " Outside of battle Rogues usually have a wide range of helpful utility abilities " +
                        "such as lockpicking to allow them to open locked doors and treasure chests without needing " +
                        "to find/buy keys or the ability to detect and disarm traps. Some can even steal items " +
                        "directly from enemies allowing the player to obtain items that otherwise might be unobtainable." +
                        " Sometimes Rogues are lumped in with the Ranger class, but more commonly they are " +
                        "differentiated by specializing in melee - particularly with light blades and daggers or " +
                        "ranged attacks using throwing weapons such as knives and shuriken",
                        5, 20, 4, 5, 10, 10);
            case "ninja":
                return new Class("Ninja", "Rogues are a diverse class that contains " +
                        "everything from dexterous thieves, to treasure-hunters, to assassins. " +
                        "Masters of stealth and infiltration, Rogues prefer to attack when their opponent is " +
                        "least aware. They are quick but fragile, unable to take heavy damage, and instead rely " +
                        "on their speed to dodge attacks and slip in and out of the shadows to catch their " +
                        "opponent off guard; setting traps and inflicting status effects on foes to give them the edge." +
                        " Outside of battle Rogues usually have a wide range of helpful utility abilities " +
                        "such as lockpicking to allow them to open locked doors and treasure chests without needing " +
                        "to find/buy keys or the ability to detect and disarm traps. Some can even steal items " +
                        "directly from enemies allowing the player to obtain items that otherwise might be unobtainable." +
                        " Sometimes Rogues are lumped in with the Ranger class, but more commonly they are " +
                        "differentiated by specializing in melee - particularly with light blades and daggers or " +
                        "ranged attacks using throwing weapons such as knives and shuriken",
                        5, 20, 4, 5, 10, 10);
            case "assassin":
                return new Class("Assassin", "Rogues are a diverse class that contains " +
                        "everything from dexterous thieves, to treasure-hunters, to assassins. " +
                        "Masters of stealth and infiltration, Rogues prefer to attack when their opponent is " +
                        "least aware. They are quick but fragile, unable to take heavy damage, and instead rely " +
                        "on their speed to dodge attacks and slip in and out of the shadows to catch their " +
                        "opponent off guard; setting traps and inflicting status effects on foes to give them the edge." +
                        " Outside of battle Rogues usually have a wide range of helpful utility abilities " +
                        "such as lockpicking to allow them to open locked doors and treasure chests without needing " +
                        "to find/buy keys or the ability to detect and disarm traps. Some can even steal items " +
                        "directly from enemies allowing the player to obtain items that otherwise might be unobtainable." +
                        " Sometimes Rogues are lumped in with the Ranger class, but more commonly they are " +
                        "differentiated by specializing in melee - particularly with light blades and daggers or " +
                        "ranged attacks using throwing weapons such as knives and shuriken",
                        5, 20, 4, 5, 10, 10);
            case "cleric":
                return new Class("Cleric", "Unlike Magician-classes, the Clerics usually draw " +
                        "their powers from either Faith, a god, or some variation of the two. Their magic " +
                        "generally requires them to stick to a certain doctrine to access it, but usually comes " +
                        "with less of a price or chance of backfiring like some Magician classes might experience." +
                        " Clerics often focus on healing and party buffs, but sometimes they are offensively " +
                        "useful against \"unholy\" enemies such as demons and undead. Often draw their powers" +
                        " from Crystal Dragon Jesus and may be suspiciously Catholic for a fantasy setting. " +
                        "Cleric-type classes generally have the least amount of variation, simply because " +
                        "healing is so vital and important that distracting a healer generally isn't seen as " +
                        "a good idea.",
                        5, 5, 5, 20, 10, 1);
            case "hunter":
                return new Class("Hunter", "Rangers are woodsmen skilled at surviving in the wild. " +
                        "They may be lumped in with Fighters or Rogues (above) but more often than not are a separate " +
                        "tree of classes all their own. Archery is generally their favored skill, although most can " +
                        "fall back on swordplay if necessary. Rangers may also be skilled in some form of wilderness " +
                        "or nature magic, and sometimes capable of utilizing their terrain or surroundings " +
                        "to their advantage. They may be very good at fighting a specific type of enemy, and " +
                        "often take on the role of a Hunter of Monsters against such foes. In a setting that allows " +
                        "guns, they will usually appear in the hands of the Ranger.",
                        5, 5, 5, 20, 10, 1);
            default:
                return null;
        }
    }

//    String[] classes =
//            {"hunter", "cleric", "assassin", "ninja", "thief", "magus", "magician", "warlock", "wizard", "mage",
//                    "soldier", "knight", "warrior"};
}
