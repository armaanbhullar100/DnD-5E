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
import magic.SpellBook;
import magic.SpellSlots;
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
        int hitDice = newJob.getInt("hit dice");
        
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

        // Get skill proficiencies from json array (CURRENTLY GETS FIRST N SKILLS FROM LIST)
        JSONArray jsonSkillProficiencies = newJob.getJSONObject("skill proficiencies").getJSONArray("list of choices");
        int numSkillProficiencies = newJob.getJSONObject("skill proficiencies").getInt("number of choices");
        ArrayList<String> skillProficiencies = new ArrayList<>();
        for (int i = 0; i < numSkillProficiencies; i++) {
            skillProficiencies.add(jsonSkillProficiencies.getString(i));
        }
        
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
        
        // Get list of equipment from json object, chooses first item from each choice (CAN'T HANDLE MULTIPLE ITEMS IN A SINGLE STRING)
        JSONObject jsonEquipment = newJob.getJSONObject("equipment");
        HashMap<String,Item> equipment = new HashMap<>();
        Iterator<String> equipmentKeys = jsonEquipment.keys();
        while (equipmentKeys.hasNext()) {
            String currKey = equipmentKeys.next();
            JSONArray currEquipmentChoice = jsonEquipment.getJSONArray(currKey);
            String itemString = currEquipmentChoice.getString(0);
            String itemName = itemString.split(" - ")[0];
            Item item = fac.createItem(itemName);
            equipment.put(item.getName(), item);
        }
        
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
        // equipment.put("Greataxe", fac.createItemWithCustomAmount("greataxe", 1));
        // equipment.put("Handaxe", fac.createItemWithCustomAmount("handaxe", 1));
        // equipment.put("Explorer's Pack", fac.createItemWithCustomAmount("explorer's pack", 1));
        // equipment.put("Javelin", fac.createItemWithCustomAmount("javelin", 4));

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
        JSONObject jsonExtraMechanics = newJob.getJSONObject("extra mechanics");
        Iterator<String> extraMechanicKeys = jsonExtraMechanics.keys();
        ExtraMechanics extraMechanics = new ExtraMechanics();
        while (extraMechanicKeys.hasNext()) {
            String currKey = extraMechanicKeys.next();
            switch (currKey) {
                case "number of rages":
                    extraMechanics.setMaxRages(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)));
                    break;
                case "rage damage":
                    extraMechanics.setRageDamage(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)));
                    break;
                case "current rages":
                    extraMechanics.setCurrRages(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)).get(0));
                    break;
                case "martial arts dice":
                    extraMechanics.setMartialArtsDice(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)));
                    break;
                case "ki points":
                    extraMechanics.setMaxKiPoints(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)));
                    break;
                case "current ki points":
                    extraMechanics.setCurrKiPoints(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)).get(0));
                    break;
                case "unarmored movement":
                    extraMechanics.setUnarmoredMovement(jsonArrayToArrayList(jsonExtraMechanics.get(currKey)));
                    break;
                default:
                    break;
            }
        }

        // Get magic from json object
        JSONObject magic = newJob.getJSONObject("magic");

        boolean hasMagic = magic.getBoolean("has magic");
        SpellSlots spellSlots;
        SpellBook spellBook;

        if (!hasMagic) {
            spellSlots = null;
            spellBook = null;
        } else {
            JSONObject jsonSpellSlots = magic.getJSONObject("spell slots");
            Iterator<String> spellSlotKeys = jsonSpellSlots.keys();
            ArrayList<Integer> cantrips = null;
            ArrayList<Integer> firstLevel = null;
            ArrayList<Integer> secondLevel = null;
            ArrayList<Integer> thirdLevel = null;
            ArrayList<Integer> fourthLevel = null;
            ArrayList<Integer> fifthLevel = null;
            ArrayList<Integer> sixLevel = null;
            ArrayList<Integer> seventhLevel = null;
            ArrayList<Integer> eighthLevel = null;
            ArrayList<Integer> ninthLevel = null;
            
            // Get Spell Slots
            while(spellSlotKeys.hasNext()) {
                String currKey = spellSlotKeys.next();
                switch (currKey) {
                    case "cantrips":
                        cantrips = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "first level":
                        firstLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "second level":
                        secondLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "third level":
                        thirdLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "fourth level":
                        fourthLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "fifth level":
                        fifthLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "sixth level":
                        sixLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "seventh level":
                        seventhLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "eighth level":
                        eighthLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    case "ninth level":
                        ninthLevel = jsonArrayToArrayList(jsonSpellSlots.get(currKey));
                        break;
                    default:
                        break;
                }
            }
            spellSlots = new SpellSlots(cantrips, firstLevel, secondLevel, thirdLevel, fourthLevel, fifthLevel, sixLevel, seventhLevel, eighthLevel, ninthLevel);

            String spellsKnownType = magic.getString("spells known type");
            ArrayList<Integer> spellsKnownAmount = new ArrayList<>();
            String spellCastingAbility = magic.getString("spellcasting ability");
            boolean ritualCasting = magic.getBoolean("ritual casting");

            // Get Number of Spells Known if possible
            if (spellsKnownType.equals("list")) {
                spellsKnownAmount = jsonArrayToArrayList(magic.getJSONArray("spells known amount"));
            } else {
                spellsKnownAmount.add(-1);
            }

            spellBook = new SpellBook(name, spellCastingAbility, -1, -1, ritualCasting, spellsKnownAmount, null, null, null, null, null, null, null, null, null, null);
        }

        switch (name) {
            case "Barbarian":
                return new Barbarian(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Bard":
                return new Bard(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Cleric":
                return new Cleric(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Druid":
                return new Druid(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Fighter":
                return new Fighter(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Monk":
                return new Monk(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Paladin":
                return new Paladin(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Ranger":
                return new Ranger(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Rogue":
                return new Rogue(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Sorcerer":
                return new Sorcerer(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Warlock":
                return new Warlock(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            case "Wizard":
                return new Wizard(name, hitDice, itemProficiencies, savingThrowProficiencies, skillProficiencies, equipment, features, subclass, extraMechanics, spellSlots, spellBook);
            default:
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
