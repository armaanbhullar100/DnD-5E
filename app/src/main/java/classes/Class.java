package classes;

import java.util.ArrayList;
import java.util.HashMap;

import character.*;
import classes.classList.subclasses.Subclass;
import item.*;

public class Class {
    private String name;
    private int level;
    private int proficiencyBonus;
    private int hitDice;
    private ArrayList<Item> itemProficiencies = new ArrayList<>();
    private ArrayList<Skill> savingThrowProficiencies = new ArrayList<>();
    private HashMap<Item,Integer> equipment = new HashMap<>();
    private ArrayList<Feature> features = new ArrayList<>();
    private Subclass subclass;

    public Class() {

    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getProficiencyBonus() {
        return this.proficiencyBonus;
    }

    public int getHitDice() {
        return this.hitDice;
    }

    public ArrayList<Item> getItemProficiencies() {
        return this.itemProficiencies;
    }

    public ArrayList<Skill> getSavingThrowProficiencies() {
        return this.savingThrowProficiencies;
    }

    public HashMap<Item, Integer> getEquipment() {
        return this.equipment;
    }

    public ArrayList<Feature> getFeatures() {
        return this.features;
    }

    public Subclass getSubclass() {
        return this.subclass;
    }

    
}
