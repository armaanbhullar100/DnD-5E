package dnd.e.character;

import org.junit.jupiter.api.Test;

import character.AbilityScore;
import character.BackgroundFactory;
import character.Character;
import character.Feature;
import character.HitDice;
import character.RaceFactory;
import character.SavingThrow;
import character.Skill;
import item.Currency;
import item.Item;
import item.ItemFactory;
import item.Weapon;
import job.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CharacterTest {
    @Test
    public void basicTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        assertEquals("John", c.getCharacterName());
        assertEquals("James", c.getPlayerName());
        assertEquals(jfac.createJob("barbarian"), c.getCharacterClass());
        assertEquals(rfac.createRace("dwarf"), c.getRace());
        assertEquals(bfac.createBackground("acolyte"), c.getBackground());
        assertEquals("Lawful Good", c.getAlignment());
        assertEquals(1, c.getLevel());
        assertEquals(0, c.getExpPoints());

        assertEquals(2, c.getProficiencyBonus());
        assertEquals(14, c.getMaxHitPoints());
        assertEquals(14, c.getCurrHitPoints());
        assertEquals(0, c.getTempHitPoints());
        assertEquals(new HitDice(12), c.getHitDice());
        assertEquals(0, c.getArmorClass());
        assertEquals(2, c.getInitiative());
        assertEquals(false, c.getInspiration());
    }

    @Test
    public void abilityScoreTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        assertEquals(new AbilityScore(12), c.getAbilityScores().get("Strength"));
        assertEquals(new AbilityScore(14), c.getAbilityScores().get("Dexerity"));
        assertEquals(new AbilityScore(14), c.getAbilityScores().get("Constitution"));
        assertEquals(new AbilityScore(16), c.getAbilityScores().get("Intelligence"));
        assertEquals(new AbilityScore(18), c.getAbilityScores().get("Wisdom"));
        assertEquals(new AbilityScore(20), c.getAbilityScores().get("Charisma"));
    }

    @Test
    public void savingThrowTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        assertEquals(new SavingThrow(true, 1), c.getSavingThrows().get("Strength"));
        assertEquals(new SavingThrow(false, 2), c.getSavingThrows().get("Dexerity"));
        assertEquals(new SavingThrow(true, 2), c.getSavingThrows().get("Constitution"));
        assertEquals(new SavingThrow(false, 3), c.getSavingThrows().get("Intelligence"));
        assertEquals(new SavingThrow(false, 4), c.getSavingThrows().get("Wisdom"));
        assertEquals(new SavingThrow(false, 5), c.getSavingThrows().get("Charisma"));
    }

    @Test
    public void skillTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        assertEquals(new Skill(false, 2), c.getSkills().get("Acrobatics"));
        assertEquals(new Skill(false, 4), c.getSkills().get("Animal Handling"));
        assertEquals(new Skill(false, 3), c.getSkills().get("Arcana"));
        assertEquals(new Skill(true, 5), c.getSkills().get("Intimidation"));
        assertEquals(new Skill(true, 1), c.getSkills().get("Athletics"));
        assertEquals(new Skill(true, 4), c.getSkills().get("Insight"));
    }

    @Test
    public void languageTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        ArrayList<String> newLanguages = new ArrayList<>();
        newLanguages.add("Any");
        newLanguages.add("Common");
        newLanguages.add("Dwarvish");

        assertEquals(newLanguages, c.getLanguages());
    }

    @Test
    public void itemProficiencyTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        ArrayList<String> newProficiencies = new ArrayList<>();
        newProficiencies.add("light armor");
        newProficiencies.add("medium armor");
        newProficiencies.add("shields");
        newProficiencies.add("simple weapons");
        newProficiencies.add("martial weapons");

        assertEquals(newProficiencies, c.getItemProficiencies());
    }

    @Test
    public void equipmentTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);
        ItemFactory ifac = new ItemFactory();

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        HashMap<String,Item> newEquipment = new HashMap<>();
        newEquipment.put("holy symbol", ifac.createItem("holy symbol"));
        newEquipment.put("prayer book", ifac.createItem("prayer book"));
        newEquipment.put("stick of incense", ifac.createItemWithCustomAmount("stick of incense", 5));
        newEquipment.put("vestments", ifac.createItem("vestments"));
        newEquipment.put("common clothes", ifac.createItem("common clothes"));
        newEquipment.put("Currency Pouch", ifac.createItemWithCustomAmount("currency pouch", 15));
        newEquipment.put("Greataxe", ifac.createItem("greataxe"));
        newEquipment.put("Handaxe", ifac.createItemWithCustomAmount("handaxe", 2));
        newEquipment.put("Explorer's Pack", ifac.createItem("explorer's pack"));
        newEquipment.put("Javelin", ifac.createItemWithCustomAmount("javelin", 4));

        assertEquals(newEquipment, c.getEquipment());
    }

    @Test
    public void wealthTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        assertEquals(new Currency(1500), c.getWealth());
    }

    @Test
    public void featureTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        Feature backgroundFeature = new Feature("Shelter of the Faithful", "As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle.\n\nYou might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.", "Acolyte", 1);
        Feature raceFeature = new Feature("Dwarven Resilience", "You have advantage on saving throws against poison, and you have resistance against poison damage.", "Dwarf", 1);
        Feature classFeature = new Feature("Fast Movement", "Starting at 5th level, your speed increases by 10 feet while you aren’t wearing heavy armor.", "Barbarian", 5);

        assertTrue(c.getFeatures().contains(backgroundFeature));
        assertTrue(c.getFeatures().contains(raceFeature));
        assertTrue(c.getFeatures().contains(classFeature));
    }

    @Test
    public void weaponTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        BackgroundFactory bfac = new BackgroundFactory(scan);
        RaceFactory rfac = new RaceFactory(scan);
        JobFactory jfac = new JobFactory(scan);
        ItemFactory ifac = new ItemFactory();

        ArrayList<Integer> abilityScores = new ArrayList<>();
        abilityScores.add(12);
        abilityScores.add(14);
        abilityScores.add(14);
        abilityScores.add(16);
        abilityScores.add(18);
        abilityScores.add(20);

        Character c = new Character("John", "James", jfac.createJob("barbarian"), rfac.createRace("dwarf"), bfac.createBackground("acolyte"), "Lawful Good", abilityScores);

        ArrayList<Weapon> newWeapons = new ArrayList<>();
        newWeapons.add((Weapon) ifac.createItem("greataxe"));
        newWeapons.add((Weapon) ifac.createItemWithCustomAmount("javelin", 4));
        newWeapons.add((Weapon) ifac.createItemWithCustomAmount("handaxe", 2));

        assertEquals(newWeapons, c.getWeapons());
    }
} 
