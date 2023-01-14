package job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import character.Feature;
import item.Item;
import item.ItemFactory;
import job.jobList.*;
import job.jobList.subclasses.Subclass;
import util.FileLoader;

public class JobFactory {
    String jsonString;

    public JobFactory() throws IOException {
        try {
            this.jsonString = FileLoader.loadResourceFile("jobs.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Job createJob(String jobType) throws IOException {
        ItemFactory fac = new ItemFactory();
        JSONObject newItem;
        
        try {
            newItem = new JSONObject(jsonString).getJSONObject(jobType.toLowerCase());
        } catch (Exception e) {
            // If class cannot be found, return null
            return null;
        }
        
        String name = newItem.getString("name");
        int hitDice = newItem.getInt("hitDice");
        
        // Get item proficiencies from json array
        JSONArray jsonItemProficiencies = newItem.getJSONArray("itemProficiencies");
        ArrayList<String> itemProficiencies = new ArrayList<>();
        for (int i = 0; i < jsonItemProficiencies.length(); i++) {
            itemProficiencies.add(jsonItemProficiencies.getString(i));
        }
        
        // Get saving throw proficiencies from json array
        JSONArray jsonSavingThrowProficiencies = newItem.getJSONArray("savingThrowProficiencies");
        ArrayList<String> savingThrowProficiencies = new ArrayList<>();
        for (int i = 0; i < jsonSavingThrowProficiencies.length(); i++) {
            savingThrowProficiencies.add(jsonSavingThrowProficiencies.getString(i));
        }

        // JSONObject skillInfo = newItem.getJSONObject("skillProficiencies");
        // Add section to make user choose number of options from list
        ArrayList<String> skillProficiencies = new ArrayList<>();
        skillProficiencies.add("Athletics");
        skillProficiencies.add("Intimidation");

        // Add section to let user choose equipment from options instead of getting prechosen items
        HashMap<String,Item> equipment = new HashMap<>();
        equipment.put("greataxe", fac.createItemWithCustomAmount("greataxe", 1));
        equipment.put("handaxe", fac.createItemWithCustomAmount("handaxe", 1));
        equipment.put("explorer's pack", fac.createItemWithCustomAmount("explorer's pack", 1));
        equipment.put("javelin", fac.createItemWithCustomAmount("javelin", 4));

        // Get and create list of features from json array
        JSONArray jsonArrayFeatures = newItem.getJSONArray("features");
        ArrayList<Feature> features = new ArrayList<>();
        for (int i = 0; i < jsonArrayFeatures.length(); i++) {
            JSONObject currFeature = jsonArrayFeatures.getJSONObject(i);
            features.add(new Feature(currFeature.getString("name"), currFeature.getString("description"), name, currFeature.getInt("level")));
        }

        // Figure out a way to do subclasses

        // Get extra mechanics of each class from json object and place into hashmap
        JSONObject extraMechanics = newItem.getJSONObject("extra mechanics");
        Iterator<String> objectKeys = extraMechanics.keySet().iterator();
        HashMap<String,ArrayList<Integer>> otherJobValues = new HashMap<>();
        while (objectKeys.hasNext()) {
            String currKey = objectKeys.next();
            otherJobValues.put(currKey, jsonArrayToArrayList(extraMechanics.get(currKey)));
            // System.err.println(extraMechanics.get(currKey).getClass());
        }
        
        if (name.equals("Barbarian")) {
            return new Barbarian(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, new Subclass(), otherJobValues);
        } else {
            return null;
        }
    }

    public ArrayList<Integer> jsonArrayToArrayList(Object obj) {
        JSONArray jsonArray = (JSONArray) obj;
        ArrayList<Integer> newArray = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            newArray.add(jsonArray.getInt(i));
        }

        return newArray;
    }
}
