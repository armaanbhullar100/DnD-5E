package character;

import java.util.ArrayList;

import classes.Class;
import classes.Spell;

public class SpellBook {
    private Class spellcastingClass;
    private String spellcastingAbility;
    private int spellSaveDC;
    private int spellAttackBonus;

    private ArrayList<Spell> cantrips = new ArrayList<>();
    private ArrayList<Spell> firstLevel = new ArrayList<>();
    private ArrayList<Spell> secondLevel = new ArrayList<>();
    private ArrayList<Spell> thirdLevel = new ArrayList<>();
    private ArrayList<Spell> fourthLevel = new ArrayList<>();
    private ArrayList<Spell> fifthLevel = new ArrayList<>();
    private ArrayList<Spell> sixthLevel = new ArrayList<>();
    private ArrayList<Spell> seventhLevel = new ArrayList<>();
    private ArrayList<Spell> eightLevel = new ArrayList<>();
    private ArrayList<Spell> ninthLevel = new ArrayList<>();

    public SpellBook() {

    }

    public Class getSpellcastingClass() {
        return this.spellcastingClass;
    }

    public String getSpellcastingAbility() {
        return this.spellcastingAbility;
    }

    public int getSpellSaveDC() {
        return this.spellSaveDC;
    }

    public int getSpellAttackBonus() {
        return this.spellAttackBonus;
    }

    public ArrayList<Spell> getCantrips() {
        return this.cantrips;
    }

    public ArrayList<Spell> getFirstLevel() {
        return this.firstLevel;
    }

    public ArrayList<Spell> getSecondLevel() {
        return this.secondLevel;
    }

    public ArrayList<Spell> getThirdLevel() {
        return this.thirdLevel;
    }

    public ArrayList<Spell> getFourthLevel() {
        return this.fourthLevel;
    }

    public ArrayList<Spell> getFifthLevel() {
        return this.fifthLevel;
    }

    public ArrayList<Spell> getSixthLevel() {
        return this.sixthLevel;
    }

    public ArrayList<Spell> getSeventhLevel() {
        return this.seventhLevel;
    }

    public ArrayList<Spell> getEightLevel() {
        return this.eightLevel;
    }

    public ArrayList<Spell> getNinthLevel() {
        return this.ninthLevel;
    }

    
}
