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
