package classes;

import java.util.ArrayList;
import java.util.HashMap;

import character.*;
import classes.classList.subclasses.Subclass;
import classes.classMethodsInterfaces.BarbarianInterface;
import item.*;

public class Class implements BarbarianInterface {
    private String name;
    private int level;
    private int proficiencyBonus;
    private int hitDice;
    
    private ArrayList<String> itemProficiencies = new ArrayList<>();
    private ArrayList<String> savingThrowProficiencies = new ArrayList<>();
    private ArrayList<String> skillProficiencies = new ArrayList<>();
    private HashMap<Item,Integer> equipment = new HashMap<>();
    private ArrayList<Feature> features = new ArrayList<>();
    private Subclass subclass;
    private HashMap<String, Object> otherClassValues = new HashMap<>();

    public Class(String name, int hitDice, ArrayList<String> itemProficiencies, ArrayList<String> savingThrowProficiencies, 
            ArrayList<String> skillProficiencies, HashMap<Item,Integer> equipment, ArrayList<Feature> features, Subclass subclass, HashMap<String, Object> otherClassValues) {
        this.name = name;
        this.level = 1;
        this.hitDice = hitDice;
        this.itemProficiencies = itemProficiencies;
        this.savingThrowProficiencies = savingThrowProficiencies;
        this.equipment = equipment;
        this.features = features;
        this.subclass = subclass;
        this.otherClassValues = otherClassValues;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHitDice() {
        return hitDice;
    }

    public ArrayList<String> getItemProficiencies() {
        return itemProficiencies;
    }

    public ArrayList<String> getSavingThrowProficiencies() {
        return savingThrowProficiencies;
    }
    
    public ArrayList<String> getSkillProficiencies() {
        return skillProficiencies;
    }

    public HashMap<Item, Integer> getEquipment() {
        return equipment;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public Subclass getSubclass() {
        return subclass;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public HashMap<String, Object> getOtherClassValues() {
        return otherClassValues;
    }
    
}
