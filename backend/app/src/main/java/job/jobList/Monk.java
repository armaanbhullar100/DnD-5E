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

public class Monk extends Job {

    public Monk(String name, int hitDice, ArrayList<String> itemProficiencies, ArrayList<String> savingThrowProficiencies, 
            ArrayList<String> skillProficiencies, HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, 
            ExtraMechanics extraMechanics, SpellSlots spellSlots, SpellBook spellBook) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
    }

    @Override
    public int getMartialArtsDice() {
        return getExtraMechanics().getMartialArtsDice(getLevel()-1);
    }

    @Override
    public int getMaxKiPoints() {
        return getExtraMechanics().getMaxKiPoints(getLevel()-1);
    }

    @Override
    public int getCurrKiPoints() {
        return getExtraMechanics().getCurrKiPoints();
    }

    @Override
    public int getUnarmoredMovement() {
        return getExtraMechanics().getUnarmoredMovement(getLevel()-1);
    }
    
}
