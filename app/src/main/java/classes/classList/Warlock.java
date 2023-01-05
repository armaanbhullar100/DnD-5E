package classes.classList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import classes.Class;
import classes.classList.subclasses.Subclass;
import item.Item;

public class Warlock extends Class {

    public Warlock(String name, int hitDice, ArrayList<String> itemProficiencies,
            ArrayList<String> savingThrowProficiencies, ArrayList<String> skillProficiencies,
            HashMap<Item, Integer> equipment, ArrayList<Feature> features, Subclass subclass, HashMap<String,Object> otherClassValues) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, otherClassValues);
        //TODO Auto-generated constructor stub
    }
    
}
