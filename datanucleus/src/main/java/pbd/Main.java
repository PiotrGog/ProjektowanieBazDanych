package pbd;

import pbd.datagenerator.GameDataGenerator;

public class Main {
    static public void main(String[] args){
        GameDataGenerator gdg = new GameDataGenerator();
        gdg.fillDatabase("database");

    }
}
