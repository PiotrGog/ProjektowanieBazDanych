package pbd.factory;

import pbd.entity.Character;


public class CharacterFactory {
    public static Character createCharacter(String name){
        return new Character(name, 1);
    }
}
