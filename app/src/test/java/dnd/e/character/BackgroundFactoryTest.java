package dnd.e.character;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import character.Background;
import character.BackgroundFactory;
import item.Item;
import item.ItemComparator;
import item.ItemFactory;

public class BackgroundFactoryTest {
    @Test
    public void basicBackgroundTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory fac = new BackgroundFactory(scan);
        Background b = fac.createBackground("acolyte");

        assertEquals("Acolyte", b.getName());
    }

    @Test
    public void skillProficienciesTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory fac = new BackgroundFactory(scan);
        Background b = fac.createBackground("acolyte");

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("Insight");
        newProficiencies.add("Religion");

        assertEquals(newProficiencies, b.getSkillProficiencies());
    }

    @Test
    public void toolProficienciesTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory fac = new BackgroundFactory(scan);
        Background b = fac.createBackground("acolyte");

        ArrayList<String> newProficiencies = new ArrayList<>();

        assertEquals(newProficiencies, b.getToolProficiencies());
    }

    @Test
    public void languages() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory fac = new BackgroundFactory(scan);
        Background b = fac.createBackground("acolyte");

        ArrayList<String> newLanguages = new ArrayList<>();
        newLanguages.add("Any");
        newLanguages.add("Any");

        assertEquals(newLanguages, b.getLanguages());
    }

    @Test
    public void equipmentTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory fac1 = new BackgroundFactory(scan);
        Background b = fac1.createBackground("acolyte");

        ItemFactory fac2 = new ItemFactory();

        ArrayList<Item> backgroundEquipment = b.getEquipment();
        ArrayList<Item> newEquipment = new ArrayList<>();
        newEquipment.add(fac2.createItemWithCustomAmount("holy symbol", 1));
        newEquipment.add(fac2.createItemWithCustomAmount("prayer book", 1));
        newEquipment.add(fac2.createItemWithCustomAmount("stick of incense", 5));
        newEquipment.add(fac2.createItemWithCustomAmount("vestments", 1));
        newEquipment.add(fac2.createItemWithCustomAmount("common clothes", 1));
        newEquipment.add(fac2.createItemWithCustomAmount("currency pouch", 15));
        
        Collections.sort(backgroundEquipment, new ItemComparator());
        Collections.sort(newEquipment, new ItemComparator());

        assertEquals(backgroundEquipment, newEquipment);
    }

    @Test
    public void featureTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory fac1 = new BackgroundFactory(scan);
        Background b = fac1.createBackground("acolyte");

        assertEquals("Shelter of the Faithful", b.getFeatures().get(0).getName());
    }
}
