package job;

import java.util.ArrayList;
import java.util.HashMap;

import character.*;
import item.*;
import job.jobList.subclasses.Subclass;
import job.jobMethodsInterface.BarbarianInterface;

public class Job implements BarbarianInterface {
    private String name;
    private int level;
    private int proficiencyBonus;
    private int hitDice;
    
    private ArrayList<String> itemProficiencies = new ArrayList<>();
    private ArrayList<String> savingThrowProficiencies = new ArrayList<>();
    private ArrayList<String> skillProficiencies = new ArrayList<>();
    private HashMap<String,Item> equipment = new HashMap<>();
    private ArrayList<Feature> features = new ArrayList<>();
    private Subclass subclass;
    private HashMap<String, ArrayList<Integer>> otherJobValues = new HashMap<>();

    public Job(String name, int hitDice, ArrayList<String> itemProficiencies, ArrayList<String> savingThrowProficiencies, 
            ArrayList<String> skillProficiencies, HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, HashMap<String, ArrayList<Integer>> otherJobValues) {
        this.name = name;
        this.level = 1;
        this.hitDice = hitDice;
        this.itemProficiencies = itemProficiencies;
        this.savingThrowProficiencies = savingThrowProficiencies;
        this.skillProficiencies = skillProficiencies;
        this.equipment = equipment;
        this.features = features;
        this.subclass = subclass;
        this.otherJobValues = otherJobValues;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Job j = (Job) obj;
        if (!name.equals(j.getName())) {
            return false;
        }

        return true;
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

    public HashMap<String,Item> getEquipment() {
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

    public HashMap<String, ArrayList<Integer>> getOtherJobValues() {
        return otherJobValues;
    }

    @Override
    public int getRageDamage() {
        return 0;
    }

    @Override
    public int getMaxRageNum() {
        return 0;
    }

    @Override
    public int getCurrRageNum() {
        return 0;
    }
    
}
