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
        return  "Buff: " +
                "buff name=" + modName + 
                ", buff value=" + modValue + 
                ", buff time=" + duration + "s"
                "\n" + Description;
    }

    /**
     * Creates Buff object inheriting from Class class
     * @param modName name of modifier
     * @param description Buff description
     * @param modValue value of given modifier
     * @param duration duration of working buff
     * @return
     */
    public static Class classFactory(String modName, String description, int modValue, int duration)
    throw IllegalArgumentException
    {
    if (description == "") {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
    if (modName == "") {
            throw new IllegalArgumentException("Modifer Name value can not be an empty string.");
        }
    if (duration< 1) {
            throw new IllegalArgumentException("Duration value can not be less than 1.");
        }
    return new Buff(modName,description, modValue, duration);        
    }
}
