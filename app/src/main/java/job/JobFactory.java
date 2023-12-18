package job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

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
    Scanner scan;

    public JobFactory(Scanner scan) throws IOException {
        this.scan = scan;
        try {
            this.jsonString = FileLoader.loadResourceFile("jobs.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Job createJob(String jobName) throws IOException {
        ItemFactory fac = new ItemFactory();
        JSONObject newJob;
        
        try {
            newJob = new JSONObject(jsonString).getJSONObject(jobName.toLowerCase());
        } catch (Exception e) {
            // If job cannot be found, return null
            return null;
        }
        
        String name = newJob.getString("name");
        int hitDice = newJob.getInt("hitDice");
        
        // Get item proficiencies from json array
        JSONArray jsonItemProficiencies = newJob.getJSONArray("item proficiencies");
        ArrayList<String> itemProficiencies = new ArrayList<>();
        for (int i = 0; i < jsonItemProficiencies.length(); i++) {
            itemProficiencies.add(jsonItemProficiencies.getString(i));
        }
        
        // Get saving throw proficiencies from json array
        JSONArray jsonSavingThrowProficiencies = newJob.getJSONArray("saving throw proficiencies");
        ArrayList<String> savingThrowProficiencies = new ArrayList<>();
        for (int i = 0; i < jsonSavingThrowProficiencies.length(); i++) {
            savingThrowProficiencies.add(jsonSavingThrowProficiencies.getString(i));
        }

        ArrayList<String> skillProficiencies = new ArrayList<>();
        
        // Get list of choices from jsonArray
        // JSONObject skillInfo = newJob.getJSONObject("skill proficiencies");
        // int numChoices = skillInfo.getInt("number of choices");
        // JSONArray jsonSkillChoices = skillInfo.getJSONArray("list of choices");
        // ArrayList<String> skillChoices = new ArrayList<>();
        // for (int i = 0; i < jsonSkillChoices.length(); i++) {
        //     skillChoices.add(jsonSkillChoices.getString(i));
        // }

        // for (int i = 0; i < numChoices; i++) {
        //     System.out.println("------------------------------------------");
        //     for (int j = 0; j < skillChoices.size(); j++) {
        //         System.out.println(j + ": " + skillChoices.get(j));
        //     }
        //     System.out.println("------------------------------------------");
        //     System.out.print("Please choose a skill by entering its number: ");
        //     int choice = scan.nextInt();
        //     skillProficiencies.add(skillChoices.get(choice));
        //     skillChoices.remove(choice);
        // }
        
        // Uncomment the lines below for test purposes
        skillProficiencies.add("Athletics");
        skillProficiencies.add("Intimidation");

        HashMap<String,Item> equipment = new HashMap<>();
        
        // Add section to let user choose equipment from options instead of getting prechosen items
        // JSONObject equipmentInfo = newJob.getJSONObject("equipment");
        // for (int i = 1; i <= equipmentInfo.length(); i++) {
        //     JSONArray equipmentChoice = equipmentInfo.getJSONArray("item " + i);
        //     System.out.println("------------------------------------------");
        //     for (int j = 0; j < equipmentChoice.length(); j++) {
        //        System.out.println(j + ": " +  equipmentChoice.getString(j));
        //     }
        //     System.out.println("------------------------------------------");
        //     System.out.print("Please choose a piece of equipment by entering its number: ");
        //     int choice = scan.nextInt();

        //     String itemString = equipmentChoice.getString(choice);
        //     String itemName = itemString.split(" - ")[0];
        //     int itemAmount = Integer.parseInt(itemString.split(" - ")[1]);

        //     if (itemName.equals("simple weapon")) {
        //         System.out.print("Please enter any simple weapon: ");
        //         itemName = scan.next();
        //     } else if (itemName.equals("simple melee weapon: ")) {
        //         System.out.print("Please enter any simple melee weapon: ");
        //         itemName = scan.next();
        //     } else if ((itemName.equals("simple ranged weapon: "))) {
        //         System.out.print("Please enter any simple ranged weapon: ");
        //         itemName = scan.next();
        //     } else if (itemName.equals("martial weapon: ")) {
        //         System.out.print("Please enter any martial weapon: ");
        //         itemName = scan.next();
        //     } else if ((itemName.equals("martial melee weapon: "))) {
        //         System.out.print("Please enter any martial melee weapon: ");
        //         itemName = scan.next();
        //     } else if ((itemName.equals("martial ranged weapon: "))) {
        //         System.out.print("Please enter any martial melee weapon: ");
        //         itemName = scan.next();
        //     }

        //     Item item = fac.createItemWithCustomAmount(itemName, itemAmount);
        //     equipment.put(item.getName(), item);
        // }

        // Uncomment the lines below for test purposes
        equipment.put("Greataxe", fac.createItemWithCustomAmount("greataxe", 1));
        equipment.put("Handaxe", fac.createItemWithCustomAmount("handaxe", 1));
        equipment.put("Explorer's Pack", fac.createItemWithCustomAmount("explorer's pack", 1));
        equipment.put("Javelin", fac.createItemWithCustomAmount("javelin", 4));

        // Get and create list of features from json array
        JSONArray jsonArrayFeatures = newJob.getJSONArray("features");
        ArrayList<Feature> features = new ArrayList<>();
        for (int i = 0; i < jsonArrayFeatures.length(); i++) {
            JSONObject currFeature = jsonArrayFeatures.getJSONObject(i);
            features.add(new Feature(currFeature.getString("name"), currFeature.getString("description"), name, currFeature.getInt("level")));
        }

        // Get subclass of job
        Subclass subclass = null;
        if (newJob.getInt("subclass level requirement") == 1) {
            // Handle subclass at level 1 later
        } else {
            subclass = new Subclass();
        }

        // Get extra mechanics of each job from json object and place into hashmap
        JSONObject extraMechanics = newJob.getJSONObject("extra mechanics");
        Iterator<String> objectKeys = extraMechanics.keys();
        HashMap<String,ArrayList<Integer>> otherJobValues = new HashMap<>();
        while (objectKeys.hasNext()) {
            String currKey = objectKeys.next();
            otherJobValues.put(currKey, jsonArrayToArrayList(extraMechanics.get(currKey)));
        }

        if (name.equals("Barbarian")) {
            return new Barbarian(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, otherJobValues);
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
