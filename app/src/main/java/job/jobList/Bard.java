package job.jobList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import item.Item;
import job.Job;
import job.jobList.subclasses.Subclass;

public class Bard extends Job {

    public Bard(String name, int hitDice, ArrayList<String> itemProficiencies,
            ArrayList<String> savingThrowProficiencies, ArrayList<String> skillProficiencies,
            HashMap<Item, Integer> equipment, ArrayList<Feature> features, Subclass subclass, HashMap<String,Object> otherJobValues) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, otherJobValues);
        //TODO Auto-generated constructor stub
    }
    
}