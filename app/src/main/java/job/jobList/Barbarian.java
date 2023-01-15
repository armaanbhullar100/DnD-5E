package job.jobList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import item.Item;
import job.Job;
import job.jobList.subclasses.Subclass;

public class Barbarian extends Job {

    public Barbarian(String name, int hitDice, ArrayList<String> itemProficiencies,
            ArrayList<String> savingThrowProficiencies, ArrayList<String> skillProficiencies,
            HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, HashMap<String,ArrayList<Integer>> otherJobValues) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, otherJobValues);
    }

    @Override
    public int getRageDamage() {
        return getOtherJobValues().get("rage damage").get(getLevel()-1);
    }

    @Override
    public int getCurrRageNum() {
        return getOtherJobValues().get("current rages").get(0);
    }

    @Override
    public int getMaxRageNum() {
        return getOtherJobValues().get("number of rages").get(getLevel()-1);
    }
    
}
