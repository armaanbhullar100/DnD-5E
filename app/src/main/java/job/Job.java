package job;

import java.util.ArrayList;
import java.util.HashMap;

import character.*;
import item.*;
import job.jobList.subclasses.Subclass;
import job.jobMethodsInterface.BarbarianInterface;
import magic.SpellBook;
import magic.SpellSlots;

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
    private ExtraMechanics extraMechanics;
    private SpellSlots spellSlots;
    private SpellBook spellBook;

    public Job(String name, int hitDice, ArrayList<String> itemProficiencies, ArrayList<String> savingThrowProficiencies, 
            ArrayList<String> skillProficiencies, HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, 
            ExtraMechanics extraMechanics, SpellSlots spellSlots, SpellBook spellBook) {
        this.name = name;
        this.level = 1;
        this.hitDice = hitDice;
        this.itemProficiencies = itemProficiencies;
        this.savingThrowProficiencies = savingThrowProficiencies;
        this.skillProficiencies = skillProficiencies;
        this.equipment = equipment;
        this.features = features;
        this.subclass = subclass;
        this.extraMechanics = extraMechanics;
        this.spellSlots = spellSlots;
        this.spellBook = spellBook;
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

    public ExtraMechanics getExtraMechanics() {
        return extraMechanics;
    }

    public SpellBook getSpellBook() {
        return spellBook;
    }

    public SpellSlots getSpellSlots() {
        return spellSlots;
    }

    public int getFirstLevelSpellSlots() {
        return spellSlots.getFirstLevelSpellSlots(getLevel()-1);
    }
    
    public int getSecondLevelSpellSlots() {
        return spellSlots.getSecondLevelSpellSlots(getLevel()-1);
    }
    
    public int getThirdLevelSpellSlots() {
        return spellSlots.getThirdLevelSpellSlots(getLevel()-1);
    }
    
    public int getFourthLevelSpellSlots() {
        return spellSlots.getFourthLevelSpellSlots(getLevel()-1);
    }
    
    public int getFifthLevelSpellSlots() {
        return spellSlots.getFifthLevelSpellSlots(getLevel()-1);
    }

    public int getSixthLevelSpellSlots() {
        return spellSlots.getSixthLevelSpellSlots(getLevel()-1);
    }

    public int getSeventhLevelSpellSlots() {
        return spellSlots.getSeventhLevelSpellSlots(getLevel()-1);
    }

    public int getEighthLevelSpellSlots() {
        return spellSlots.getEighthLevelSpellSlots(getLevel()-1);
    }

    public int getNinthLevelSpellSlots() {
        return spellSlots.getNinthLevelSpellSlots(getLevel()-1);
    }

    @Override
    public int getRageDamage() {
        return -1;
    }
    
    @Override
    public int getMaxRages() {
        return -1;
    }
    
    @Override
    public int getCurrRages() {
        return -1;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
}
