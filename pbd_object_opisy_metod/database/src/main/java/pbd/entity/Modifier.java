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
    public void setModValue(int modValue){
        this.modValue = modValue;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description == "") {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
        this.description=description;
    }
    
    public void setModeName(String modName) throws IllegalArgumentException {
        if (modName == "") {
            throw new IllegalArgumentException("Modifer Name value can not be an empty string.");
        }
        this.modName=modName;
    }

    @Override
    public String toString() {
        return "Modifer: " +
                "modifer name=" + modName + 
                ", modifer value=" + modValue + 
                "\n" + Description;
    }


    /**
     *
     * @param modName
     * @param description
     * @param modValue
     * @return
     */
    public static Class classFactory(String modName, String description, int modValue)
    throw IllegalArgumentException
    {
    if (description == "") {
            throw new IllegalArgumentException("Description value can not be an empty string.");
        }
    if (modName == "") {
            throw new IllegalArgumentException("Modifer Name value can not be an empty string.");
        }
    
    return new Modifer(modName, description, modValue)
    }
}
