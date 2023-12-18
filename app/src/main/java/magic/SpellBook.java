package magic;

import java.util.ArrayList;

public class SpellBook {
    private String spellcastingClass;
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

    public SpellBook(String spellcastingClass, String spellcastingAbility, int spellSaveDC, int spellAttackBonus, ArrayList<Spell> cantrips, ArrayList<Spell> firstLevel, ArrayList<Spell> secondLevel, ArrayList<Spell> thirdLevel, ArrayList<Spell> fourthLevel, ArrayList<Spell> fifthLevel, ArrayList<Spell> sixthLevel, ArrayList<Spell> seventhLevel, ArrayList<Spell> eightLevel, ArrayList<Spell> ninthLevel) {
        this.spellcastingClass = spellcastingClass;
        this.spellcastingAbility = spellcastingAbility;
        this.spellSaveDC = spellSaveDC;
        this.spellAttackBonus = spellAttackBonus;
        this.cantrips = cantrips;
        this.firstLevel = firstLevel;
        this.secondLevel = secondLevel;
        this.thirdLevel = thirdLevel;
        this.fourthLevel = fourthLevel;
        this.fifthLevel = fifthLevel;
        this.sixthLevel = sixthLevel;
        this.seventhLevel = seventhLevel;
        this.eightLevel = eightLevel;
        this.ninthLevel = ninthLevel;
    }

    public String getSpellcastingClass() {
        return spellcastingClass;
    }

    public String getSpellcastingAbility() {
        return spellcastingAbility;
    }

    public int getSpellSaveDC() {
        return spellSaveDC;
    }

    public int getSpellAttackBonus() {
        return spellAttackBonus;
    }

    public ArrayList<Spell> getCantrips() {
        return cantrips;
    }

    public ArrayList<Spell> getFirstLevel() {
        return firstLevel;
    }

    public ArrayList<Spell> getSecondLevel() {
        return secondLevel;
    }

    public ArrayList<Spell> getThirdLevel() {
        return thirdLevel;
    }

    public ArrayList<Spell> getFourthLevel() {
        return fourthLevel;
    }

    public ArrayList<Spell> getFifthLevel() {
        return fifthLevel;
    }

    public ArrayList<Spell> getSixthLevel() {
        return sixthLevel;
    }

    public ArrayList<Spell> getSeventhLevel() {
        return seventhLevel;
    }

    public ArrayList<Spell> getEightLevel() {
        return eightLevel;
    }

    public ArrayList<Spell> getNinthLevel() {
        return ninthLevel;
    }
}
