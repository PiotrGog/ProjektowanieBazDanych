package pbd.entity;


import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Skill {

    @PrimaryKey
    private String name;

    @Column(allowsNull = "false")
    private String descritpion;

    public Skill(String name, String descritpion) {
        this.name = name;
        this.descritpion = descritpion;
    }

    public String getName() {
        return name;
    }

    public String getDescritpion() {
        return descritpion;
    }


    public static String[][] skills = {{"Archaeology",
            "Archaeologists must travel around the world, looking for fragments of ancient artifacts, many of which have interesting tidbits of lore attached. In Mists of Pandaria, a new faction has been added that loves archaeology."},
            {"Cooking",
                    "Cooking is a secondary profession which allows players to combine various ingredients such as fish or meat into delicious food and drink items which can be consumed to restore health and mana, as well as to grant combat buffs."},
            {"Draenor Cooking", "kfdjslkajfkasjklfjsjfjsdkjfksjadfiamia;disfjisdkfjkasjfjajfiosajfaslj"}, {"Fishing",
            "Fishing is a gathering secondary profession which allows players to fish in the various bodies of water found across the world. Different areas require certain skill levels before the player will be able to cast in the waters."},
            {"Riding",
                    "Riding is the passive skill which allows players to utilize a mount to navigate throughout the world. Riding skill is not leveled but rather trained at increasing gold costs."},
            {"Axes", "Ability to use Axes."}, {"Bows",
            "ne of the four ranged weapon-classes. Uses arrows as ammo. No longer benefits from the quiver's effect."},
            {"Crossbows", "Ability allowing to use Crossbows."}, {"Polearms",
            "Polearms are most of the time designed for Hunters and Feral Druids. In the past these weapons were also designed for warriors and retribution paladins but those classes have swung over to swords, axes and maces."},
            {"Ancestral Spirit",
                    "Returns the spirit to the body, restoring a dead target to life with 65 health and 120 mana. Cannot be cast when in combat."},
            {"Chain Heal", "Heals the friendly target for 320 to 369, then jumps to heal additional nearby targets."},
            {"Chain Lightning",
                    "Hurls a lightning bolt at the enemy, dealing 493 to 552 Nature damage and then jumping to additional nearby enemies."},
            {"Cure Poison", "Cures 1 poison effect on the target."},
            {"Earth Shock", "Instantly shocks the target with concussive force, causing 32 to 35 Nature damage."},
            {"Fire Resistance", "Fire Resistance increased by 30."}, {"Flame Shock",
            "Instantly sears the target with fire, causing 21 Fire damage immediately and 28 Fire damage over 12sec."},
            {"Flametongue Weapon Proc", "Flametongue Weapon Proc"}, {"Frost Shock",
            "Instantly shocks the target with frost, causing 89 to 96 Frost damage and slowing movement speed by 50%."},
            {"Grounding Totem",
                    "Summons a Grounding Totem with 5 health at the feet of the caster that will redirect one harmful spell cast on a nearby party member to itself every 10 seconds."},
            {"Lightning Bolt", "Casts a bolt of lightning at the target for 13 to 16 Nature damage."},
            {"Lightning Shield",
                    "The caster is surrounded by 3 balls of lightning. When a spell, melee or ranged attack hits the caster, the attacker will be struck for 51 Nature damage."},
            {"Purge", "Purges the enemy target, removing 2 beneficial magic effects."}, {"Tremor Totem",
            "Summons a Tremor Totem with 5 health at the feet of the caster that shakes the ground around it."},
            {"Eviscerate", "Finishing move that causes damage per combo point, increased by Attack Power."},
            {"Cheap Shot", "Stuns the target for 4sec. Must be stealthed. Awards 2 combo points."}, {"Mana Tide Totem",
            "Summons a Mana Tide Totem with 5 health at the feet of the caster for 12sec that restores 290 mana every 3 seconds to group members within 20 yards."},
            {"Mana Spring", "Gain 6 mana every 2 seconds."}, {"Magma Totem",
            "Summons a Magma Totem with 5 health at the feet of the caster for 20sec that causes 22 Fire damage to creatures within 8 yards every 2 seconds."},
            {"Rupture", "Finishing move that Garrote",
                    "Garrote the enemy, causing 444 damage over 18sec, increased by your Attack Power."},
            {"Stealth", "Allows the rogue to sneak around, but reduces your speed by 50%. Lasts until cancelled."},
            {"Throw", "Hurl a thrown weapon at the target."}, {"Seal Fate",
            "Your critical strikes from abilities that add combo points have a 60% chance to add an additional combo point."},
            {"Blind",
                    "Blinds the target, causing it to wander confused for up to 10sec. Any damage caused will remove the effect."},
            {"Pick Pocket", "Pick the target's pocket."},
            {"Evasion", "The rogue's dodge chance will increase by 50% for 15sec."},
            {"Sprint", "Increases the rogue's movement speed by 50% for 15sec. Does not break stealth."},
            {"Slice and Dice", "Finishing move that increases melee attack speed by 20%."}, {"Sinister Strike",
            "An instant strike that causes 10 damage in addition to your normal weapon damage. Awards 1 combo point."},
            {"Ambush", "Ambush the target, causing 250% weapon damage plus 70 to the target. "},
            {"Poisons", "You can create and mix poisons, with both found and storebought ingredients."},
            {"Premeditation", "When used, adds 2 combo points to your target."},
            {"Distract", "Throws a distraction, attracting the attention of all nearby monsters for 10 seconds. "},
            {"Mind-numbing Poison",
                    "Coats a weapon with poison that lasts for 30 minutes. Each strike has a 20% chance of poisoning the enemy, "},
            {"Gouge", "Causes 32 damage, incapacitating the opponent for 4sec, and turns off your attack. "},
            {"Improved Charge", "Increases the amount of rage generated by your Charge ability by 3."}, {"Battle Shout",
            "The warrior shouts, increasing the melee attack power of all party members within 20 yards by 232. Lasts 2min"},
            {"Berserker Charge", "Charges at an enemy, knocking it back and inflicting normal damage plus 300."},
            {"Berserker Stance",
                    "An aggressive stance. Critical hit chance is increased by 3% and all damage taken is increased by 10%."},
            {"Bloodthirst", "Instantly attack the target causing damage equal to 45% of your attack power. I"},
            {"Booming Voice",
                    "Increases the area of effect and duration of your Battle Shout and Demoralizing Shout by 40%."},
            {"Cleave", "A sweeping attack that does your weapon damage plus 18 to the target and his nearest ally"},
            {"Cripple", "Reduces target enemy's attack power by 15 for 30sec"},
            {"Defensive Stance", "A defensive combat stance. Decreases damage taken by 10% and damage caused by 10%."},
            {"Demoralizing Shout", "Reduces the melee attack power of nearby enemies by 40 for 30sec."}, {"Execute",
            "Attempt to finish off a wounded foe, causing 125 damage and converting each extra point of rage into 3 additional damage."},
            {"Hamstring", "Maims the enemy, causing 18 damage and slowing the enemy's movement by 45% for 15sec."},
            {"Head Butt", "Pummels an enemy for 250 damage and interrupts the spell being cast for 5sec."},
            {"Improved Battle Shout", "Increases the melee attack power bonus of your Battle Shout by 25%."},
            {"Conflagrate", "Ignites a target that is already afflicted by Immolate, dealing 240 to 307 Fire damage"},
            {"Corruption", "Corrupts the target, causing 822 Shadow damage over 18sec."},
            {"Curse of Agony", "Curses the target with agony, causing 504 Shadow damage over 24sec."},
            {"Curse of Recklessness",
                    "Curses the target with recklessness, increasing melee attack power by 45 but reducing armor by 290 for 2min."},
            {"Curse of Weakness", "Damage caused by the target is reduced by 15 for 2min. "}, {"Devour Magic",
            "Purges 1 harmful magic effect from a friend or 1 beneficial magic effect from an enemy. "},
            {"Drain Mana", "Transfers 99 Mana every 1 sec from the target to the caster. Lasts 5sec."},
            {"Enslave Demon", "Enslaves the target demon, up to level 47, forcing it to do your bidding. "},
            {"Fire Shield", "Surrounds the target in a shield of fire. "},
            {"Firebolt", "Shoots a bolt of flame at an enemy, inflicting Fire damage."}, {"Health Funnel",
            "Gives 119 health to the caster's pet every second for 10sec as long as the caster channels."},
            {"Immolate", "Burns the enemy for 8 Fire damage and then an additional 20 Fire damage over 15sec."},
            {"Aimed Shot", "An aimed shot that increases ranged damage by 600."},
            {"Aspect of the Hawk", "The hunter takes on the aspects of a hawk, increasing Ranged Attack Power by 50."},
            {"Counterattack", "A strike that becomes active after parrying an opponent's attack. "}, {"Immolation Trap",
            "Place a fire trap that will burn the first enemy to approach for 0 Fire damage over 15sec"},
            {"Mongoose Bite", "Counterattack the enemy for 25 damage. Can only be performed after you dodge."},
            {"Raptor Strike", "A strong attack that increases melee damage by 11."},
            {"Expose Armor", "Finishing move that exposes the target for 30sec, reducing armor per combo point."}};


}
