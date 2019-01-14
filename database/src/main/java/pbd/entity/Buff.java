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

    public static Buff classFactory(String modName, String description, int modValue, int duration)
            throws IllegalArgumentException {
        if (description.equals("")) {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
        if (modName.equals("")) {
            throw new IllegalArgumentException("Modifer Name value can not be an empty string.");
        }
        if (duration < 1) {
            throw new IllegalArgumentException("Duration value can not be less than 1.");
        }
        return new Buff(modName, description, modValue, duration);
    }
}
