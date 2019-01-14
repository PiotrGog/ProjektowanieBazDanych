package pbd.entity;

import javax.jdo.annotations.PersistenceCapable;
import java.util.List;

@PersistenceCapable
public class Player extends Character {
    protected Player(String name, int level, int strength, int ability, int intellect, int prudence, int charisma,
                  int construction, Race race, Class class_, Specialization specialization,
                  List<Equipment> bag, List<Modifier> modifiers, List<Quest> quests) {
        super(name, level, strength, ability, intellect, prudence, charisma, construction, race, class_, specialization,
                bag, modifiers, quests);
    }

    /**
     * Creates new Player object with given parameters
     * @param name name for new player
     * @param level level of new player
     * @param strength strength level of new player
     * @param ability ability level of new player
     * @param intellect intellect level of new player
     * @param prudence prudence level of new player
     * @param charisma charisma level of new player
     * @param construction construction level of new player
     * @param race ability of new player
     * @param class_ class of new player
     * @param specialization specialization of new player
     * @param bag bag of new player
     * @param zones zones that new player has got
     * @param modifiers modifiers that new player has got
     * @param quests quests that new player has got
     * @return new Player object with given parameters
     * @throws IllegalArgumentException thrown if some argument is wrong
     */
    public static Player playerFactory(String name, int level, int strength, int ability, int intellect,
                                       int prudence, int charisma,
                                       int construction, Race race, Class class_, Specialization specialization,
                                       List<Equipment> bag, List<Zone> zones, List<Modifier> modifiers,
                                       List<Quest> quests)
            throws IllegalArgumentException {

//        List<String> availableClasses = Race.availableClasses.get(race);
//        List<String> availableSpecializations = Class.availableSpecializations.get(class_);
//        if (null == availableClasses) {
//            throw new IllegalArgumentException("Race " + race + " is not defined.");
//        }
//        if (null == availableSpecializations) {
//            throw new IllegalArgumentException("Class " + class_ + " is not defined.");
//        }
//        if (!availableClasses.contains(class_)) {
//            throw new IllegalArgumentException(
//                    "Combination race" + race + " and class " + class_ + " is not available.");
//        }
//        if (!availableSpecializations.contains(specialization)) {
//            throw new IllegalArgumentException(
//                    "Combination class" + class_ + " and specialization " + specialization + " is not available.");
//        }

        return new Player(name, level, strength, ability, intellect, prudence, charisma, construction,
                race, class_, specialization, bag, modifiers, quests);
    }
}
