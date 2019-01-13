package pbd.entity;

public class Buff extends Modifier {

    private int duration;

    public Buff(String modName, String description, int modValue, int duration) {
        super(modName, description, modValue);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
