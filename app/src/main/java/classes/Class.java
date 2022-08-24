package classes;

import java.util.ArrayList;
import java.util.HashMap;

import character.*;
import classes.classList.subclasses.Subclass;
import item.*;

public class Class {
    String name;
    int level;
    int proficiencyBonus;
    int hitDice;
    ArrayList<Item> itemProficiencies = new ArrayList<>();
    ArrayList<SavingThrow> savingThrowProficiencies = new ArrayList<>();
    HashMap<Item,Integer> equipment = new HashMap<>();
    ArrayList<Feature> features = new ArrayList<>();
    Subclass subclass;
}
