package pbd.entity;


import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Specialization {

    @PrimaryKey
    private String name;

    @Column(allowsNull = "false")
    private String description;

    private int strength;

    private int ability;

    private int intellect;

    private int prudence;

    private int charisma;

    private int construction;

    protected Specialization(String name, String description, int strength, int ability, int intellect, int prudence,
                             int charisma, int construction) {
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

    public void setStrength(int strength) throws IllegalArgumentException {
        if (strength < 1) {
            throw new IllegalArgumentException("Strength value can not be less than 1.");
        }
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) throws IllegalArgumentException {
        if (ability < 1) {
            throw new IllegalArgumentException("Ability value can not be less than 1.");
        }
        this.ability = ability;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) throws IllegalArgumentException {
        if (intellect < 1) {
            throw new IllegalArgumentException("Intellect value can not be less than 1.");
        }
        this.intellect = intellect;
    }

    public int getPrudence() {
        return prudence;
    }

    public void setPrudence(int prudence) throws IllegalArgumentException {
        if (prudence < 1) {
            throw new IllegalArgumentException("Prudence value can not be less than 1.");
        }
        this.prudence = prudence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) throws IllegalArgumentException {
        if (charisma < 1) {
            throw new IllegalArgumentException("Charisma value can not be less than 1.");
        }
        this.charisma = charisma;
    }

    public int getConstruction() {
        return construction;
    }

    public void setConstruction(int construction) throws IllegalArgumentException {
        if (construction < 1) {
            throw new IllegalArgumentException("Construction value can not be less than 1.");
        }
        this.construction = construction;
    }

    /**
     * Finds specialization by name and creates new Specialization Object with this name and proper description.
     * @param specializationName name of specialization to create
     * @return specialization object with given name and proper description
     */
    public static Specialization specializationFactory(String specializationName) {
        switch (specializationName.toLowerCase()) {

            case "the knight":
                return new Specialization("The Knight",
                        "  Cavaliernote , Guardian, Sentinel. The Knight is often considered an " +
                                "upgrade to the basic Fighter. It may be able to wear bigger, heavier armor " +
                                "(including shields) and weaponry, possibly sacrificing speed in favor of more" +
                                " defense and power. The Knight may also gain supportive abilities that help to" +
                                " keep their allies safe, relating to bravery and chivalry. For example; the ability " +
                                "to shield the group from enemy attacks, or otherwise take hits meant for their friends, a " +
                                "taunt command that forces foes to direct attacks towards them and away from allies, or the " +
                                "ability to make powerful Counter Attacks against enemies who ignore them. " +
                                "Knights may be able to employ mounted combat, if there is no dedicated " +
                                "Cavalier class.",
                        15, 7, 12, 14, 10, 12);
            case "the warden":
                return new Specialization("The Warden",
                        "  Knight, Sword Master, Mercenary. These fighters are usually trained " +
                                "with the long sword and wear medium to heavy armour. They are vowed " +
                                "to fight for a faction and if chosen in battle to serve for their warlord " +
                                "until death. They are usually chosen in one on one battles with an enemy " +
                                "(if both factions agree with each other for no more bloodshed) and if onewarden " +
                                "wins than the opposite faction surrenders. If the enemy factions warden dies in" +
                                " combat against another warden in a one on one, the warden that one will have the " +
                                "chance to switch factions and have a new warlord. The wardens can also fight on " +
                                "frontlines and they are good at guarding castles to sacred treasures. These people" +
                                " usually try to fight for peace but sometimes will fight for evil purposes. They will " +
                                "fight to the death and will not surrender unless ordered to by a superior officer or " +
                                "warlord. They are also high ranking and can order other troops around. Their armour " +
                                "is usually hand crafted or passed down from generations along with their sword. " +
                                "These fighters are almost the most loyal to leaders and will obey almost any command.",
                        14, 1, 3, 3, 13, 12);
            case "the swashbuckler":
                return new Specialization("The Swashbuckler",
                        "  Fencer, Duelist. A Fighter who tends toward light or no armor and prefers agility," +
                                " cunning, daring and technical skill to sheer force. Tends to be rogue-like in his " +
                                "or her trappings (though usually more flamboyant than subtle) and is often used to " +
                                "evoke the Rogue archetype in games where skills and stealth play a small or no role." +
                                " A likely default class for The Hero, especially in JRPGs and adventure novels after " +
                                "Alexandre Dumas.",
                        7, 8, 2, 14, 6, 11);
            case "the paladin":
                return new Specialization("The Paladin",
                        "  Holy Knight, Crusader, Templarnote , Inquisitor. The Paladin is a Fighter with " +
                                "the power of Light and healing magic, as well as defensive buffs for their allies. " +
                                "Their devotion to their god or deity gives them various prayers, healing abilities " +
                                "and light-based spells to protect themselves and others. Naturally, they are a type" +
                                " of Magic Knight. They are also quite good at laying the smite down on undead, demons " +
                                "and other traditionally evil supernatural creatures. However, they may have behavioral " +
                                "limits",
                        15, 14, 11, 7, 11, 10);
            case "the dark knight":
                return new Specialization("The Dark Knight",
                        "  Blackguard, Hexblade, Antipaladin, Death Knight. The Dark Knight class is" +
                                " the opposite number of the Paladin, possessing the power of Darkness and often " +
                                "necromantic or dark-magic oriented abilities that deal large amounts of damage to" +
                                " enemies, although often at the cost of their own HP. They may have abilities that " +
                                "lower their target's stats or inflict Standard Status Effects also. As the opposite" +
                                " of the Paladin, they may do more damage to light based enemies such as angels, " +
                                "fairies or other traditionally good/holy creatures even if Light Is NotGood or find " +
                                "such foes to be their biggest weakness. They generally do not suffer the behavioral " +
                                "limitations of Paladins, except possibly when they are the literal counterpart of " +
                                "Paladins and need tobehave accordingly.",
                        14, 3, 8, 12, 5, 14);
            case "the dragon knight":
                return new Specialization("The Dragon Knight",
                        "  Dragoon note . A Fighter who is either descended from, in the employ of, " +
                                "powered by, owns, or specializes in hunting, dragons. A Dragon Knight usually " +
                                "has a variety of abilities that mimic or relate to dragons in some way â Flight " +
                                "or high jumping ability, breathing fire or imbuing it into their attacks, and " +
                                "dealing extra damage to dragons are all common. Some are able to tame or train " +
                                "dragons (typically either big ones large enough to ride on, or smaller " +
                                "species/hatchlings) or even transform into a dragon themselves. They seem " +
                                "to be associatedwith spears for some reason.",
                        10, 11, 11, 9, 3, 10);
            case "the barbarian":
                return new Specialization("The Barbarian",
                        "  Berserker, Gladiator, Viking. The Barbarian is a breed of Fighter " +
                                "focused more on damage than defense. Note that in systems where Barbarians " +
                                "have normal or greater than normal physical defense compared to other warriors," +
                                " such as D&D, they will usually have no defense whatsoever against magic. " +
                                "Often characterized by wearing less armor, being less civilized, and being able " +
                                "to fly into a berserker rage that increases damage output or allow them to do" +
                                " more damage based on how hurt they are.",
                        14, 8, 15, 2, 15, 15);
            case "the monster knight":
                return new Specialization("The Monster Knight",
                        " Related to Dragon Knight and Barbarian above as well as the Beast below, " +
                                "Monster Knight combines the augmented power of a monster/beast and the training " +
                                "and weaponry of a knight. They may also be able to tap on their basic monster" +
                                " instincts to gain more power and ferocity, often at a cost (either endangering " +
                                "you or your allies). Dragon Knight thatcan turn (whether fully or in part) into " +
                                "dragons overlap with this. In games with multiple playable races, if a Monstrous " +
                                "Humanoid race exists as one of the choices, them taking the Knight class makethem this.",
                        13, 9, 10, 12, 4, 5);
            case "the samurai":
                return new Specialization("The Samurai",
                        "  Yojimbo, Kensai, Weapon Master, Myrmidon. Samurai wear less armor than regular " +
                                "Fighters, which leads them to have less defensive abilities. In general, " +
                                "they commonly have access to Ki Attacks, higher damage, and higher speed and " +
                                "mobility, along with abilities related to Counter Attacks, sensing hidden enemies, " +
                                "or acting before their opponents can act. Some Samurai can wield both swords and " +
                                "longbows (and occasionally spears), but the majority focus on the sword to the " +
                                "exclusion of all other weapons. Generally restricted to Asian settings, but can " +
                                "appear outside them under more generic names like The Swordmaster. After the Hero, " +
                                "Samurai are the class most likely to have unique weapons which other classes cannot " +
                                "use. Because Yojimbo are mercenaries, they may be literally able to spend money " +
                                "to deal more damage.",
                        11, 5, 5, 2, 2, 11);
            case "the warlord":
                return new Specialization("The Warlord",
                        "  General, Tactician, Marshal, Commander. The Warlord is a tactical master." +
                                " He can hold his own in frontline combat as well as giving out buffs to his underlings " +
                                "and allies, usually by commanding them to superior positions than the ones they would" +
                                " have thought of on their own, and he may have protective auras made of his own " +
                                "charisma to increase a team's effectiveness in battle. Sometimes may be able to " +
                                "summon his own troops, overlapping with Pet Master below.",
                        2, 13, 12, 15, 6, 1);
            case "the cavalier":
                return new Specialization("The Cavalier",
                        "  Knightnote . The Cavalier fights from the back of a mount, whether a normal " +
                                "horse or something more exotic. Cavaliers have higher movement speed than other " +
                                "Fighters and may be able to charge through groups of enemies or perform Hit-and-Run " +
                                "Tactics. However, they also have more weaknesses",
                        12, 1, 11, 14, 15, 9);
            case "the rebel":
                return new Specialization("The Rebel",
                        "  Soldier, Fallen Knight, Outlaw. A cross between a Knight and Ranger " +
                                "due to a mix of martial capability and survival instincts. Usually differentiated " +
                                "from other fighters as being against the law or higher authority, particularly in " +
                                "counterpart to the Knight who upholds/represents the law/higher authority. Sometimes " +
                                "appear under-equipped and/or using improvised or stolen equipment. They usually " +
                                "have an expert sense of guerilla warfare and survival tactics at their disposal " +
                                "compared to better equipped foes to balance the odds, comparable to that of a " +
                                "Warlord, but is not necessarily a leader.",
                        11, 3, 13, 7, 11, 10);
            case "the hero":
                return new Specialization("The Hero",
                        "  Lord, Protagonist. This is the class generally used exclusively used by RPG " +
                                "protagonists, the protagonist of the game will be the only character able to " +
                                "become this class (usually) and may become it as a plot point. Although they " +
                                "are definitely a type of physical class, and sometimes referred to by one of " +
                                "the names of the classes above, they aren't a Mighty Glacier or Stone Wall; " +
                                "but much closer to being the Jack-of-All-Stats. They may gain some magic, and " +
                                "will almost certainly have unique skills. Almost always uses a sword, and " +
                                "possibly a shield. Sometimes they will have exclusive access to powerful items " +
                                "like the Infinity +1 Sword.",
                        10, 8, 8, 6, 13, 4);
            case "the inherent gift magician":
                return new Specialization("The Inherent Gift Magician",
                        "  Sorcerer. This magic-user was born with abilities they don't need to study, " +
                                "and can use more readily than other Magicians. This is sometimesexplained as being " +
                                "descended from a magical creature, other times as being part of a Witch Species. " +
                                "However, they are often much less versatile than other magic-users, being limited t" +
                                "o a smaller or much more tightly-themed pool of spells. Commonly, their powers " +
                                "manifest at adolescence.",
                        6, 7, 11, 10, 7, 2);
            case "the theurgist":
                return new Specialization("The Theurgist",
                        "  Warlock. The Magician makes a pact with a higher spirit (although not usually" +
                                " a god since those tend to be distinct in fantasy settings), who supplies him with " +
                                "magical powers. This is usually flavored with a Deal with the Devil. While healing" +
                                " class pacts are seen as good, a Magician that makes a pact with an entity that" +
                                " gives them the power to harm ordestroy is usually flavored in a darker light - " +
                                "and it may turn out to be with demons or Eldritch Abominations. Thus, this type " +
                                "of magic is usually heavily offensive and nasty, dealing heavy area damage and/or" +
                                " multitude of Status Ailment.",
                        1, 12, 4, 2, 13, 12);
            case "the summoner":
                return new Specialization("The Summoner",
                        "  Conjurer. A higher level in which the caster summons the entity to them to " +
                                "do its bidding. Usually even more dangerous than regular Theurgists. Usually" +
                                " supplemented with some magic of another type. If the summoned entity sticks " +
                                "around for a while to assist the summoner, then they may learn magic that allows" +
                                " them to support it. If the summoned entity simply uses a single powerful attack " +
                                "or ability before vanishing, then the summoner is likely to have weaker abilities " +
                                "of roughly the same type, with the summons themselves serving as a form of Limit " +
                                "Break. When Summoners can have pacts with multiple entities at once, they will" +
                                " often be able to go on sidequests to unlock more summons.",
                        4, 14, 14, 14, 1, 10);
            case "the vancian magician":
                return new Specialization("The Vancian Magician",
                        "  Wizard, among many others. These casters rely on Rule Magic and study to " +
                                "learn and wield magic, usually taking years, leaving their bodies squishyand " +
                                "out of shape... most of the time. Dusty tomes and candlelit towers are what " +
                                "you should associate with these guys. If there's a distinction between this " +
                                "and the Inherent Gift Magician, it will be that these ones have some kind of " +
                                "limitation â like needing to prepare which spells they'll use ahead of time â " +
                                "in exchange for more versatility if prepared.",
                        9, 1, 13, 5, 10, 4);
            case "the red mage":
                return new Specialization("The Red Mage",
                        " A Magician who does not specialize in one school or tradition and studies " +
                                "the magic of various types. They tend to be rare, and depending on which limitations " +
                                "they have, may be very powerful thanks to their versatility or very weak thanks to " +
                                "their lack of focus. In any case, they usually aren't able to use the more complex" +
                                " spells their specialized brethren use, or at least not nearly as often. Of all the " +
                                "kinds of Magician, they tend to be the most open minded and least prone to think " +
                                "there are Unequal Rites. May also have more physical prowess than most other mages " +
                                "to be even more versatile.",
                        2, 11, 1, 15, 4, 14);
            case "the blue mage":
                return new Specialization("The Blue Mage",
                        "  Mime, Mimic. A Magician who does not usually rely on standard spells, but " +
                                "instead learns various spells and special abilities from monsters encountered " +
                                "in travel. Often they will need to see the spell or special ability in action," +
                                " or cast their own unique spell to 'absorb' the ability. Traditionally will " +
                                "develop to be as diverse as the Red Mage, except with unique monster-like abilities " +
                                "to supplement them.",
                        12, 13, 6, 7, 7, 10);
            case "the necromancer":
                return new Specialization("The Necromancer", " A magic-user who wields power over " +
                        "the dead, blood, and . They're usually antagonists, but if Dark Is Not Evil, may be a playable class." +
                        " Often they employ a Zerg Rush - creating hordes of weak undead and sending them" +
                        " after a problem till it dies. Any other abilities will likely be curses that " +
                        "weaken or sap away strength. Very often alsoa form of Black Mage," +
                        " especially if an alternative more versatile battle mage is not available." +
                        " May or may not overlap with the Theurgist class above.",
                        6, 5, 3, 7, 7, 11);
            case "the illusionist":
                return new Specialization("The Illusionist",
                        " A magic-user who casts illusions. Generally considered weak, with no " +
                                "real damage output, and has been phased out of most settings - their" +
                                " abilities are generally given to characters with Psychic powers and Bards.",
                        3, 12, 12, 2, 10, 10);
            case "the nature magician":
                return new Specialization("The Nature Magician",
                        " Wields power over the natural world, often including elements, animals, and plants.",
                        7, 10, 3, 7, 14, 14);
            case "the elementalist":
                return new Specialization("The Elementalist",
                        " A specialized Magician who can only use Elemental Powers in some way." +
                                " They may be able to use all the elements, or may specialize in one or two. Often,they are the key to winning Elemental RockâPaperâScissors in their setting. May sometimes come with a pact with - and optionally summon - Elemental Embodiment.",
                        6, 7, 9, 10, 14, 12);
            case "the druid":
                return new Specialization("The Druid",
                        " A jack of all trades nature Magician. They often have a mix of elemental " +
                                "offense, healing, and the ability to morph into animals or elemental spirits" +
                                " to become melee fighters. To further the overlap with the Cleric classes," +
                                " is often a of nature.",
                        3, 1, 10, 1, 12, 2);
            case "the shaman":
                return new Specialization("The Shaman",
                        " A nature Magician with a Summoner twist. This class generally revolves " +
                                "around bargaining with spirits and building a Place of Power for yourself." +
                                " (Although since a story about someone who stays in the same place is likely" +
                                " to get boring, this place may become more or less mobile in practice.)",
                        10, 4, 10, 3, 10, 5);
            case "the thief":
                return new Specialization("The Thief",
                        " The Thief, when it is a separate class, is a version of the Rogue with " +
                                "lower damage, but the ability to steal items from enemies. Sometimes, " +
                                "this can extend even to intangible items, such as experience points, but " +
                                "more commonly includes rare items that cannot be obtained in any other way.",
                        2, 14, 4, 7, 2, 2);
            case "the assassin":
                return new Specialization("The Assassin",
                        " A more offensive Rogue, who sacrifices technical expertise for better " +
                                "stealth and killing abilities. Often have a variety of weakening and " +
                                "poisoning abilities and are able to cripple a foe to leave him open for" +
                                " allies or to let him die from Damage Over Time.",
                        4, 7, 11, 8, 8, 6);
            case "the gambler":
                return new Specialization("The Gambler",
                        " The Gambler is a fairly rare variation more often seen in video games than " +
                                "in pen and paper settings. The Gambler is a Rogue who has a set of magical powersthat " +
                                "rely more on chance than usual. They may have to draw a card, spin a roulette, " +
                                "roll magical dice, or activate a magical slot machine to get a desired effect which" +
                                " may be positive or negative depending on their luck. Very likely to attack with" +
                                " playing cards in lieu of throwing knives.",
                        14, 12, 7, 8, 15, 11);
            case "the ninja":
                return new Specialization("The Ninja",
                        " Generally, the highest tier of Rogue-type classes. The Ninja is a Rogue who " +
                                "may have a long list of useful skills. Stealth and backstabbing are universal, " +
                                "butbeyond that, it gets hazy. Invisibility, smoke techniques that increases evasion, " +
                                "long-range elemental powers, and sometimes special bonuses to combat like dual-wielding. " +
                                "They also tend to excel at throwing items like shurikens, daggers, and kunai." +
                                " Often a Game-Breaker. May be combined with the Assassin or distinct.",
                        11, 2, 2, 10, 3, 1);
            case "the shadow":
                return new Specialization("The Shadow",
                        "  Nightblade. Occasionally, Rogue-types will specialize in magic or powers " +
                                "that augment their stealth, and when they do, those powers generally feature " +
                                "darkness, shadows or the occult as themes. May be distinct or combined with" +
                                " the Ninja or Assassin.",
                        7, 7, 13, 6, 2, 11);
            case "the bandit":
                return new Specialization("The Bandit",
                        "  Burglar, Thug, Brigand. Close to the Thief, a Bandit is a Rogue " +
                                "whose stealth skills are either downplayed or non-existent. While they have " +
                                "all the standardRogue abilities, they tend to use them in less subtle ways - " +
                                "instead of unlocking a door they'll kick it down, and instead of stealthily " +
                                "pickpocketing their enemies they'll simply walk up and grab things from them. " +
                                "Sometimes they also have the ability to intimidate their enemies or are good at " +
                                "destroying structures, as well as whole slew of other  related abilities. Bandits " +
                                "are generally the Mighty Glacier of Rogue classes, having stats more similar to " +
                                "a Fighter (though they may still be a Fragile Speedster compared to non-Rogues)." +
                                " While they display slightly more variation in weapons than standard Rogues, most" +
                                " Bandits still cannot equip heavy armor and are thus not as tough as Fighters.",
                        9, 6, 7, 1, 10, 13);
            case "the pirate":
                return new Specialization("The Pirate",
                        "  Corsair, Privateer, Swashbuckler. Currently a rare variation of the Rogue," +
                                " but gaining popularity thanks to Memetic Mutation. The archetype for pirate " +
                                "isn'tyet set that hard in stone, but in general, a Pirate will use a combination " +
                                "of weaponry instead of specializing - usually being able to switch freely between" +
                                " pistols and swords. They may also receivebonuses for fighting in water terrain " +
                                "or on ships, or be the best class at swimming. May have some aspects of the Bandit, " +
                                "or the Bandit class may be folded into Pirate entirely. When this class specifically " +
                                "represents a pirate captain it sometimes overlaps with Warlord.",
                        1, 13, 14, 13, 6, 9);
            case "the scout":
                return new Specialization("The Scout",
                        "  Spy, Acrobat, Operative. Another rare variation on the Rogue, the Scout " +
                                "combines high movement rate with superior sensory and information-gathering skills, " +
                                "and often emphasizes stealth as well. Not guaranteed to be as good at combat as other " +
                                "Rogues; may overlap with the Ranger archetype if they are. May also favour ranged " +
                                "weapons more than other Rogues. Sometimes combined with the Thief and/or Assassin to" +
                                " give them more things to do.",
                        10, 7, 12, 4, 11, 3);
            case "the priest":
                return new Specialization("The Priest",
                        "  Healer, White Mage. A squishy dedicated healer with little abilities at offense " +
                                "aside from specific types of enemies, most commonly demonic entities and theundead.",
                        5, 9, 8, 13, 5, 12);
            case "the battle priest":
                return new Specialization("The Battle Priest",
                        " A badass, tough warrior, carrying blessed weapons. This version of the Cleric can" +
                                " dish out melee damage and heal. They tend to be closer to Clerics than Paladins, who " +
                                "tend to be closer to Fighters; although occassionally this is a literal overlap a.k.a " +
                                "hybrid of Fighter and Cleric class.",
                        3, 7, 12, 8, 14, 14);
            case "the witch doctor":
                return new Specialization("The Witch Doctor",
                        " A version of the Cleric flavored for a more shamanic, nature-worshiping culture " +
                                "as opposed to the generally Monotheistic religion most Cleric-using settings use." +
                                " May be slightly more magically offensive and overlap with the Shaman (see above).",
                        8, 2, 9, 6, 14, 11);
            case "the templar":
                return new Specialization("The Templar",
                        "  Inquisitor. Named after The Knights Templar, the Templar is more of an assassin" +
                                " mixed with a Cleric. The chief role in the story is generally to do the church's " +
                                "dirty work, ferreting out heretics and covering up the great conspiracy. In battle, " +
                                "they may be anything, but tend to be a jack of all trades, weaker than a Paladin, " +
                                "Cleric, or Rogue in their specialties, but able to handle all of their roles to one " +
                                "extent or another. They can also be defined as Mage Killer / The Witch Hunter," +
                                " especially in settings where the Church is very much at odds withsome, if not all," +
                                " mages. If the Cleric class normally comes with innate restrictions or drawbacks " +
                                "(e.g. must always tell the truth, cannot wear metal armor, must avoid contact with" +
                                " The Dark Side) then a Templar can usually ignore at least some of them.",
                        14, 3, 2, 10, 15, 1);
            case "the caster":
                return new Specialization("The Caster",
                        " In some settings, the Cleric will be combined with the Magician to create the " +
                                "Caster. The Caster isn't so much The Red Mage (although depending on the case, " +
                                "it can be) as they are the Squishy Wizard; the physically weak magic user. This" +
                                " character is usually female. Story-wise, they will be in the party because no-one " +
                                "else can use magic. This is more common in modern settings, but some medieval works " +
                                "will still use this class for the heroine.",
                        13, 14, 3, 15, 4, 8);
            case "the sniper ranger":
                return new Specialization("The Sniper Ranger",
                        " This version is totally reliant on archery, but usually does higher damage because" +
                                " of it. May have a variety of status-inflicting arrows to slow or otherwise annoy" +
                                " enemies. Keeps to the back of a battle, as they're weak in terms of close combat.",
                        10, 8, 2, 13, 3, 4);
            case "the bow and blade ranger":
                return new Specialization("The Bow and Blade Ranger",
                        " A version of the Ranger that can handle bladed weapons as well, allowing them " +
                                "to defend themselves against approaching enemies or close in for the kill. The most " +
                                "likely Ranger to overlap with the Fighter archetype, usually the Swashbuckler, or" +
                                " alternatively the Rogue.",
                        5, 15, 1, 9, 7, 13);
            case "the dual wielding ranger":
                return new Specialization("The Dual Wielding Ranger",
                        " The Dual Wielding Ranger most famously represented by the famed Drow ranger " +
                                "Drizzt Do'Urden, who uses two melee weapons, though it does predatehim by quite" +
                                " some time. Very common in Dungeons & Dragons-based material, but less so elsewhere.",
                        7, 9, 8, 14, 13, 15);
            case "the beast master ranger":
                return new Specialization("The Beast Master Ranger",
                        " Living out in the wilderness is just easier with a loyal dog at your side and a" +
                                " hawk on your arm. This variant employs a number of beasts, and can be as simple as " +
                                "a Houndmaster using two or three dogs, to something more fantastic like a snake " +
                                "charmer or dinosaur rider. Different from the Druid because the Beast Master Ranger" +
                                " is still a martial class who fights alongside his beasts, and either doesn't use " +
                                "magic or only uses minor magic to compliment his weapon(s), and may be limited in " +
                                "the kind of beasts they can use compared to, say, pureBeastmasters (see below).",
                        14, 2, 13, 1, 2, 10);
            case "the summoner ranger":
                return new Specialization("The Summoner Ranger",
                        " A variant of the Beast Master Ranger that can summon beasts to its his side," +
                                " either with magic, as a familiar, or his connection to nature. Overlapswith the" +
                                " Druid such that they are often the primary guardians of the forest and nature " +
                                "against the encroaching modern civilizations.",
                        5, 13, 9, 4, 14, 13);
            case "the trapper ranger":
                return new Specialization("The Trapper Ranger",
                        " The Trapper is a character who can lay down various traps in an area that " +
                                "the enemy can walk into, making them vulnerable to ambushes or follow-up attacks. " +
                                "Often combined with the Sniper or Beast Master above.",
                        2, 5, 14, 14, 14, 13);
            case "the magical ranger":
                return new Specialization("The Magical Ranger",
                        " A version of the Ranger who can use enchanted or Trick Arrows to take " +
                                "advantage of Elemental RockâPaperâScissors, or slow down and disable enemies with ",
                        14, 4, 6, 2, 8, 1);
            case "the magic knight":
                return new Specialization("The Magic Knight",
                        "  Spellblade, Hexblade, Eldritch Knight, Rune Knight. The Magic Knight " +
                                "is a hybrid Fighter/Magician. The key distinction between different versions " +
                                "of this class is how the Fighter and Mage parts are combined",
                        15, 1, 9, 6, 6, 14);
            case "the battle mage":
                return new Specialization("The Battle Mage",
                        "  Warmage, Runesmith. An offensively-focused spellcaster who lacks some of " +
                                "the weaknesses of their setting's normal Squishy Wizards - they're tougher andcan " +
                                "cast their spells faster or more reliably, in exchange for their arsenal being weaker " +
                                "or limited entirely to offense. Explanations for this can vary from special training," +
                                " to special equipment, to their magic being somehow . Usually has at least a" +
                                " mild military theme, being either a soldier (possibly " +
                                "a Super Soldier) or someone who HAD To Be Sharp. Tends to use spells with " +
                                "shorterranges than other spellcasters, or to simply cast their spells at close " +
                                "range more often. Can sometimes equip better weapons or armor than other mages, in " +
                                "which case they're distinguished from the Magic Knight through poor physical stats " +
                                "or lack of advanced combat skills. Common in Action Games, less so elsewhere.",
                        4, 1, 8, 12, 13, 4);
            case "the bard":
                return new Specialization("The Bard",
                        " The Bard is a class specializing in music. Perhaps understandably, they're " +
                                "butt of a lot of jokes in fantasy settings, however, depending on the game, they " +
                                "maybe useful. Bardic songs are generally useful for buffing allies, weakening enemies, " +
                                "status effects, and occasionally damage (via Brown Note or Make Me Wanna Shout)." +
                                " Sometimes they act as the Jack of All Trades. Of all the classes, Bards are the most" +
                                " likely to be good at diplomacy with NPCs.",
                        2, 6, 13, 3, 6, 12);
            case "the dancer":
                return new Specialization("The Dancer",
                        " A rare variation of the Bard, who tend to get the same jokes made, but for " +
                                "dancing instead of music. They tend to do the same things as Bards, too, so " +
                                "perhaps they deserve it. A variant is The Whirling Dervish, who looks to the " +
                                "casual observer like an ordinary dancer but is actually a spinning buzz-saw of" +
                                " slice-and-dice death; she'll give new meaning to Aram Khachaturian's Sabre Dance " +
                                "and have way too much fun doing it.",
                        12, 9, 14, 5, 6, 1);
            case "the cantor":
                return new Specialization("The Cantor",
                        " The Cantor sings not just songs but hymns, acting as a cross between the" +
                                " Bard and the Priest. Cantors generally have more focus on healing abilities" +
                                " than a standard Bard, but instead of having attacks which harm demonic creatures" +
                                " and The Undead, a Cantor makes his allies better at fighting such creatures. " +
                                "Alternatively a Cantor may specialize in supporting other Cleric classes, such as " +
                                "restoring their Mana or increasing the potency of their healing spells. Can overlap " +
                                "with Dancer for characters who use religious dances, such as Miko.",
                        5, 6, 1, 13, 14, 8);
            case "the skald":
                return new Specialization("The Skald", " A more  version of the Bard, who " +
                        "charges into battle himself so that he can write epic stories about how glorious it " +
                        "was afterwards. Tends to be less of a Jack of All Trades than a standard Bard in favor " +
                        "of combat abilities similar to the Barbarian. He might also have buffs which turn his al" +
                        "lies into Glass Cannons, affect larger numbers of allies than a standard Bard, or allow al" +
                        "lies to march or fight continuously without rest. Usually acts as a substitute for Bards in" +
                        " whatever culture Barbarians come from, but they can show up in just about any military " +
                        "setting as  or similar.",
                        6, 3, 13, 13, 15, 1);
            case "the monk":
                return new Specialization("The Monk",
                        "  Black Belt, Martial Artist, Pugilist, Fighternote , Mystic. " +
                                "The Monk is partway between the Fighter and the Rogue... kind of." +
                                " They are usually bare-fisted warriors who either eschew weapons entirely" +
                                " or use only martial artsy weapons like nunchucks and staves. Tend to have " +
                                "higher magical stats than other warriors due to their refined bodies and souls, " +
                                "but not enough magic to make this very useful. They often have access to some" +
                                " sort of Ki Attacks and build up attacks, and sometimes have resistance to magi" +
                                "c or certain Standard Status Effects. Self-sufficiency is what sets them apart" +
                                " from classes relying on fragile magics, higher powers or expensive items.",
                        10, 9, 15, 4, 12, 4);
            case "the beast":
                return new Specialization("The Beast",
                        "  Beastman, Wolfling, Laguz, Manakete. The Beast is either a non-human creature, " +
                                "or can turn into one, and fights with their own body in place of weapons. As such," +
                                " they are generally even less tied to equipment than Monks are. Beasts often lack " +
                                "versatility compared to other classes, but compensate with high stats, high movement" +
                                " speed, and/or terrain-based abilities (either gaining bonuses in certain terrains," +
                                " moving through rough terrain without being slowed, or just being able to fly over" +
                                " obstacles entirely). Sometimes combined with the Barbarian, Nature Magician, Dragon " +
                                "Knight or Monster Knight; alternately they may possess similar wilderness skills to" +
                                " the Ranger. If a Beast has access to Prestige Classes, they will usually represent " +
                                "a physical metamorphosis or simply getting larger and stronger.",
                        5, 3, 12, 7, 15, 4);
            case "the engineer":
                return new Specialization("The Engineer",
                        "  Tinkerer, Artificer, Machinist, Gadgeteer, Alchemist note . This is a character " +
                                "class that relies on technology, often of the Steam Punk or Magitek variety, to" +
                                " achieve ranged controlling effects similar to a wizard. They most likely have guns " +
                                "and bombs as primary weapons, and employ stationary and/or mobile machines on the " +
                                "battlefield."
                        , 6, 6, 7, 5, 9, 7);
            case "the alchemist":
                return new Specialization("The Alchemist",
                        "  Chemist, Brewer, Herbalist, Merchant. An Alchemist combines items," +
                                " magic or otherwise, to create potions or bombs to use in battle, " +
                                "often mixing them together during battle. Oddly enough, of all of " +
                                "the classes, they're the ones most likely to be good at throwing things," +
                                " partly because bombs aren't going to deliver themselves to his enemies. " +
                                "They oftenare also capable of making supportive items, Health Potion and " +
                                "food being most common.",
                        11, 2, 6, 14, 14, 6);
            case "the gunslinger":
                return new Specialization("The Gunslinger",
                        " The Gunslinger is the wielder of firearms in a fantasy setting that has " +
                                "them, when guns aren't common enough to be in the hands of regular people " +
                                "(or, ifthey are in the hands of regular people, the gunslinger tends to " +
                                "use them with much greater effectiveness and panache). Usually functions " +
                                "as a ranged counterpart to the Samurai class, focusing entirely on their Weapon " +
                                "of Choice and being weak or useless at close range, but may also have some " +
                                "abilities from the Engineer and/or Alchemist (particularly if they build their" +
                                " own guns). Sometimes given a nerf or weakness in order to keep people playing " +
                                "the Ranger class (assuming it isn't merged with the Ranger class) - for instance" +
                                " guns might have lower damage or a slower rate of fire than bows, in exchange " +
                                "for longer range or the ability to pierce armor, or alternatively Gunslingers" +
                                " may lack versatility but have higher attack power or evasion compared to regular " +
                                "Rangers. Gunslinger and Ranger are the only classes likely to have Wild West motifs, " +
                                "though even then, they don't always have them.",
                        3, 3, 14, 9, 13, 8);
            case "the gun mage":
                return new Specialization("The Gun Mage",
                        " A Magician who uses guns to shoot spells. Tends to have above-average attack" +
                                " speed and mobility, in exchange for being less versatile and more equipment-dependent" +
                                " than other dedicated magic-users. Can be an outright Magic Knight who uses magic and" +
                                " guns separately, but this is rare. In settings where Magicians use guns, they tend to " +
                                "be the only classes that use guns - sometimes Magicians don't have time to master any " +
                                "weapon more complicated than a gun, sometimes igniting gunpowder with magic is more " +
                                "reliable than conventional firing mechanisms, and sometimes their guns are just a kind " +
                                "of Magic Wand with firearm-like aesthetics.",
                        14, 12, 4, 11, 11, 4);
            case "the psychic":
                return new Specialization("The Psychic",
                        "  Psion, Mentalist, ESPer. Psychics generally employ a combination of telepathy" +
                                " and psychokinesis to attack the opponent's mind directly, or to deal damage to his" +
                                " body. Distinctions between psychic powers and magic may be difficult to make. In " +
                                "addition, the list of Psychic Powers potentially available is often seen as too long " +
                                "and generalized. Was generally restricted to science fiction settings before the " +
                                "popularity of X-Men prompted its controversial inclusion in Dungeons & Dragons decades" +
                                " ago, and has appeared only sporadically in other fantasy settings since then.",
                        15, 5, 3, 2, 1, 13);
            case "the beastmaster":
                return new Specialization("The Beastmaster",
                        "  Pet Master, Puppet Master, Trainer. Pet Masters specialize in controlling a " +
                                "powerful  to fight by their side. The pet can be anything from a tamedanimal to a" +
                                " summoned elemental to a constructed Golem, but usually it serves as a front-line melee" +
                                " combatant while the master hangs back to support it with healing, buffing and " +
                                "long-range attacks. Inextreme cases the master does not take part in combat at all." +
                                " If the pet is an animal then this class is often folded into Ranger or Nature Magician," +
                                " and comes with the ability to control animals in general. If folded into Summoner " +
                                "then the character might have access to multiple pets, but only be able to use one a" +
                                "t a time. Sometimes a Pet Master can ride their pet and function somewhat like a Cava" +
                                "lier, except that the pet does most of the fighting. An MMORPG Pet Master will always" +
                                " have some way of summoning their pet to their position.",
                        4, 13, 2, 7, 10, 11);
            case "the scholar":
                return new Specialization("The Scholar",
                        "  Sage, Librarian, Loremaster, Archivist, Veteran, Wizard. Scholars are a sup" +
                                "port class with encyclopedic knowledge which allows them to study enemies and fig" +
                                "ure out their weaknesses. This ranges from simply reading the enemies' stats to a" +
                                "ctually giving them weaknesses or stripping away their defences. Scholars also ha" +
                                "ve a wide range of other skills, sometimes including unique elements or status co" +
                                "nditions which no other class can access, but they're usually weak or impractical " +
                                "outside of narrow situations. Strongly associated with books (magical or otherwise)," +
                                " sometimes to the point of wielding them as weapons. Most Scholars are magic-users " +
                                "(often folded in with the Blue Mage, Bard, Alchemist or Inquisitor) but Genius Bru" +
                                "iser Fighters and Badass Bookworm Rogues are not unheard of.",
                        13, 5, 10, 2, 15, 15);

            default:
                return null;
        }
    }

    static public String[] specializations =
            {"The Knight", "The Warden", "The Swashbuckler", "The Paladin", "The Dark Knight", "The Dragon Knight",
                    "The Barbarian", "The Monster Knight", "The Samurai", "The Warlord", "The Cavalier", "The Rebel",
                    "The Hero", "The Inherent Gift Magician", "The Theurgist", "The Summoner", "The Vancian Magician",
                    "The Red Mage", "The Blue Mage", "The Necromancer", "The Illusionist", "The Nature Magician",
                    "The Elementalist", "The Druid", "The Shaman", "The Thief", "The Assassin", "The Gambler",
                    "The Ninja", "The Shadow", "The Bandit", "The Pirate", "The Scout", "The Priest",
                    "The Battle Priest", "The Witch Doctor", "The Templar", "The Caster", "The Sniper Ranger",
                    "The Bow and Blade Ranger", "The Dual Wielding Ranger", "The Beast Master Ranger",
                    "The Summoner Ranger", "The Trapper Ranger", "The Magical Ranger", "The Magic Knight",
                    "The Battle Mage", "The Bard", "The Dancer", "The Cantor", "The Skald", "The Monk", "The Beast",
                    "The Engineer", "The Alchemist", "The Gunslinger", "The Gun Mage", "The Psychic", "The Beastmaster",
                    "The Scholar"};
}
