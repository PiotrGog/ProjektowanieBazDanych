package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

@PersistenceCapable
public class Equipment {
    @PrimaryKey
    private String equipmentName;

    @Column(allowsNull = "false")
    private List<String> zones;

    protected Equipment(String equipmentName, List<String> zones, List<Modifier> modifiers) {
        this.equipmentName = equipmentName;
        this.zones = zones;
        this.modifiers = modifiers;
    }

    @Column(allowsNull = "false")

    private List<Modifier> modifiers;

    public String getEquipmentName() {
        return equipmentName;
    }

    public List<String> getZones() {
        return zones;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    static public String[] equipments =
            {"Curse Mantle", "Eternity Necklace", "Supremacy Cylinder", "Guardian's Shield", "Wisdom Urn",
                    "Elixir of Damnation", "Necklace of Evil", "Ark of Decadence", "Staff of Betrayal",
                    "Statue of Decay", "Lust's Runes", "Faith's Symbols", "Shadow Gem", "Hungering Stone",
                    "Echo Goblet", "Tome of Shapeshifting", "Jar of Runes", "Circlet of Blights", "Cloak of Genesis",
                    "Jar of Vengeance", "Fate's Symbols", "Purity Boots", "Sanctifying Scroll", "Anarchy Skull",
                    "Athanasia Ark", "Statue of Oblivion", "Horn of Pain", "Mirror of Apathy", "Staff of Torture",
                    "Urn of Dread", "Lucky Sword", "Spite Tome", "Massacre Mirror", "Decimation Ring",
                    "Elemental Gauntlet", "Box of Karma", "Box of the Scourge", "Robes of Karma", "Book of Wishes",
                    "Mirror of Malady", "Lifeblood Goblet", "Prosperous Seal", "Temptation Fleece", "Demonic Ichor",
                    "Destruction Rod", "Shield of Oaths", "Skull of Chance", "Chest of Speed", "Ark of the Occult",
                    "Shard of Strength", "Binding Robes", "Paramount Ring", "Anguish Box", "Rogue Pillar",
                    "Kismet Feather", "Cloak of Shapeshifting", "Monolith of Death", "Ichor of Mania", "Ichor of Toxin",
                    "Cube of Secrets", "Massacre Cylinder", "Burning Gauntlet", "Twilight Microlith",
                    "Elemental Symbols", "Holy Root", "Seal of Riddles", "Box of Grace", "Tablet of Service",
                    "Arch of Paradise", "Canopic", "Jar of Genesis", "Fortitude Tome", "Equinox Feather", "Chaos Seal",
                    "Sentient Cube", "Letters of Chaos", "Grail of Lightning", "Tablet of Speed", "Lamp of Riddles",
                    "Staff of Misfortune", "Prime Horn", "Truth Stone", "Seduction Tome", "Resistance Ichor",
                    "Shade Goblet", "Circlet of Ice", "Robes of Youth", "Crown of Apathy", "Tiara of Valor",
                    "Hide of Hell", "Maniacal Runes", "Impurity Mantle", "Devotion Seal", "Void Urn", "Cup of the Gods",
                    "Robes of Paradise", "Key of Passion", "Sword of Malice", "Dominance Boots", "Death's Monolith",
                    "Supremacy Door", "Enigma Band", "Elemental Feather", "Amulet of Enthrallment",
                    "Statuette of Spells", "Chest of Spellbinding", "Ichor of Valor", "Bracelet of Agony",
                    "Necrotic Shield", "Genesis Boots", "Black Magic", "Mirror", "Paradise Door", "Healing Fruit",
                    "Robes of Dreams", "Tablet o Rebirth", "Boots of Sentience", "Band of Betrayal", "Arch of Vice",
                    "Termination Disc", "Aurora Cylinder", "Tribute Instrument", "Exile Skull", "Tiara of Binding",
                    "Cylinder of Eternal Slumber", "Seal of Storms", "Rod of the Aether", "Root of Toxin",
                    "Paradise Slab", "Valor Goblet", "Teleporting Inscriptions", "Kismet Tiara", "Valor Cloak",
                    "Grimoire of the Oracle", "Staff of Gold", "Chalice of Fertility", "Sandals of Fortune",
                    "Tome of Enthrallment", "Resolution Disc", "Thunder Cup", "Infinity Tablet", "Justice Disc",
                    "Robes of Downfall", "Grail of All-Seeing", "Cloak of the Aether", "Sandals of Immobilizing",
                    "Monolith of Torment"};

}
