package dnd.e.job;

import org.junit.jupiter.api.Test;

import character.Feature;
import item.Item;
import item.ItemFactory;
import job.Job;
import job.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class JobFactoryTest {
    @Test
    public void basicJobTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        assertEquals("Barbarian", j.getName());
        assertEquals(12, j.getHitDice());
    }

    @Test
    public void itemProficienciesTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("light armor");
        newProficiencies.add("medium armor");
        newProficiencies.add("shields");
        newProficiencies.add("simple weapons");
        newProficiencies.add("martial weapons");

        assertEquals(newProficiencies, j.getItemProficiencies());
    }

    @Test
    public void savingThrowProficienciesTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("Strength");
        newProficiencies.add("Constitution");

        assertEquals(newProficiencies, j.getSavingThrowProficiencies());
    }

    @Test
    public void skillProficienciesTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("Athletics");
        newProficiencies.add("Intimidation");

        assertEquals(newProficiencies, j.getSkillProficiencies());
    }

    @Test
    public void equipmentTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac1 = new JobFactory(scan);
        Job j = fac1.createJob("barbarian");

        ItemFactory fac2 = new ItemFactory();

        HashMap<String,Item> newEquipment = new HashMap<>();
        newEquipment.put("Greataxe", fac2.createItemWithCustomAmount("greataxe", 1));
        newEquipment.put("Handaxe", fac2.createItemWithCustomAmount("handaxe", 1));
        newEquipment.put("Explorer's Pack", fac2.createItemWithCustomAmount("explorer's pack", 1));
        newEquipment.put("Javelin", fac2.createItemWithCustomAmount("javelin", 4));

        assertTrue(newEquipment.equals(j.getEquipment()));
    }

    @Test
    public void featureTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        ArrayList<Feature> features = new ArrayList<>();
        features.add(new Feature("Unarmored Defense", "While you are not wearing any armor, your Armor Class equals 10 + your Dexterity modifier + your Constitution modifier. You can use a shield and still gain this benefit.", "Barbarian", 1));
        features.add(new Feature("Fast Movement", "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.", "Barbarian", 5));

        assertTrue(features.get(0).equals(j.getFeatures().get(1)));
        assertTrue(features.get(1).equals(j.getFeatures().get(7)));
    }

    // Test subclasses later

    @Test
    public void otherJobValuesTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        ArrayList<Integer> newRageDam = new ArrayList<>();
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(2);
        newRageDam.add(3);
        newRageDam.add(3);
        newRageDam.add(3);
        newRageDam.add(3);
        newRageDam.add(3);
        newRageDam.add(3);
        newRageDam.add(3);
        newRageDam.add(4);
        newRageDam.add(4);
        newRageDam.add(4);
        newRageDam.add(4);
        newRageDam.add(4);

        assertEquals(newRageDam, j.getOtherJobValues().get("rage damage"));
    }
}
