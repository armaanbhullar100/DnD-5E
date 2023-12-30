package job.jobList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import item.Item;
import job.ExtraMechanics;
import job.Job;
import job.jobList.subclasses.Subclass;
import magic.SpellBook;
import magic.SpellSlots;

public class Sorcerer extends Job {

    public Sorcerer(String name, int hitDice, ArrayList<String> itemProficiencies, ArrayList<String> savingThrowProficiencies, 
            ArrayList<String> skillProficiencies, HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, 
            ExtraMechanics extraMechanics, SpellSlots spellSlots, SpellBook spellBook) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
    }

    @Override
    public int getMaxSorceryPoints() {
        return getExtraMechanics().getMaxSorceryPoints(getLevel()-1);
    }

    @Override
    public int getCurrSorceryPoints() {
        return getExtraMechanics().getCurrSorceryPoints();
    }
    
}