package job.jobList;

import java.util.ArrayList;
import java.util.HashMap;

import character.Feature;
import item.Item;
import job.Job;
import job.jobList.subclasses.Subclass;

public class Druid extends Job {

    public Druid(String name, int hitDice, ArrayList<String> itemProficiencies,
            ArrayList<String> savingThrowProficiencies, ArrayList<String> skillProficiencies,
            HashMap<String,Item> equipment, ArrayList<Feature> features, Subclass subclass, HashMap<String,ArrayList<Integer>> otherJobValues) {
        super(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, otherJobValues);
        //TODO Auto-generated constructor stub
    }
    
}