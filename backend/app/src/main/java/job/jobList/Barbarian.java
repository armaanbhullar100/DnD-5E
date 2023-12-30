package job.jobList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import item.Item;
import job.ExtraMechanics;
import job.Job;
import job.jobList.subclasses.Subclass;
import magic.SpellSlots;
import magic.SpellBook;

public class Barbarian extends Job {

    public Barbarian(String name, int hitDice, ArrayList<String> itemProficiencies,
            ArrayList<String> savingThrowProficiencies, ArrayList<String> skillProficiencies,
            HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, 
            ExtraMechanics extraMechanics, SpellSlots spellSlots, SpellBook spellBook) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
    }

    @Override
    public int getRageDamage() {
        return getExtraMechanics().getRageDamage(getLevel()-1);
    }

    @Override
    public int getCurrRages() {
        return getExtraMechanics().getCurrRages();
    }

    @Override
    public int getMaxRages() {
        return getExtraMechanics().getMaxRages(getLevel()-1);
    }
    
}
