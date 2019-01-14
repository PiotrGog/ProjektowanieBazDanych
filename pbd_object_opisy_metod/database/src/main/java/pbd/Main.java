package pbd;


import example.database.Product;
import pbd.datagenerator.GameDataGenerator;
import pbd.entity.Character;
import pbd.entity.Team;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static public void main(String[] args){
        GameDataGenerator gdg = new GameDataGenerator();
        gdg.fillDatabase("database");

    }
}
