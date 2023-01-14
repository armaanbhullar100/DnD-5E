package dnd.e;

import org.junit.jupiter.api.Test;

import item.EquipmentPack;
import item.Item;
import item.ItemFactory;
import job.Job;
import job.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class JobFactoryTest {
    @Test
    public void basicJobTest() throws IOException {
        JobFactory fac = new JobFactory();
        Job j = fac.createJob("barbarian");

        assertEquals("Barbarian", j.getName());
        assertEquals(12, j.getHitDice());
    }

    @Test
    public void itemProficienciesTest() throws IOException {
        JobFactory fac = new JobFactory();
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
        JobFactory fac = new JobFactory();
        Job j = fac.createJob("barbarian");

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("Strength");
        newProficiencies.add("Constitution");

        assertEquals(newProficiencies, j.getSavingThrowProficiencies());
    }

    @Test
    public void skillProficienciesTest() throws IOException {
        JobFactory fac = new JobFactory();
        Job j = fac.createJob("barbarian");

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("Athletics");
        newProficiencies.add("Intimidation");

        assertEquals(newProficiencies, j.getSkillProficiencies());
    }

    @Test
    public void equipmentTest() throws IOException {
        JobFactory fac1 = new JobFactory();
        Job j = fac1.createJob("barbarian");

        ItemFactory fac2 = new ItemFactory();
        
        EquipmentPack ep1 = (EquipmentPack) fac2.createItem("explorer's pack");
        EquipmentPack ep2 = (EquipmentPack) fac2.createItem("explorer's pack");

        // Currently incomplete

        assertTrue(ep1.equals(ep2));
    }
}
