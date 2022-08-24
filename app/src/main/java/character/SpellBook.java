package character;

import java.util.ArrayList;

import classes.Class;
import classes.Spell;

public class SpellBook {
    Class spellcastingClass;
    String spellcastingAbility;
    int spellSaveDC;
    int spellAttackBonus;

    ArrayList<Spell> cantrips = new ArrayList<>();
    ArrayList<Spell> firstLevel = new ArrayList<>();
    ArrayList<Spell> secondLevel = new ArrayList<>();
    ArrayList<Spell> thirdLevel = new ArrayList<>();
    ArrayList<Spell> fourthLevel = new ArrayList<>();
    ArrayList<Spell> fifthLevel = new ArrayList<>();
    ArrayList<Spell> sixthLevel = new ArrayList<>();
    ArrayList<Spell> seventhLevel = new ArrayList<>();
    ArrayList<Spell> eightLevel = new ArrayList<>();
    ArrayList<Spell> ninthLevel = new ArrayList<>();
}
