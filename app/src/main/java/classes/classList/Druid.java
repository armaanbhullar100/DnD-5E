package classes.classList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import classes.Class;
import classes.classList.subclasses.Subclass;
import item.Item;

public class Druid extends Class {

    public Druid(String name, int hitDice, ArrayList<String> itemProficiencies,
            ArrayList<String> savingThrowProficiencies, ArrayList<String> skillProficiencies,
            HashMap<Item, Integer> equipment, ArrayList<Feature> features, Subclass subclass) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features,
                subclass);
    }
    
}