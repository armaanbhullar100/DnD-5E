package dnd.e;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import character.Race;
import character.RaceFactory;

public class RaceFactoryTest {
    @Test
    public void basicRaceTest() throws IOException {
        RaceFactory fac = new RaceFactory();
        Race r = fac.createRace("dwarf");

        assertEquals("Dwarf", r.getName());
        assertEquals("Medium", r.getSize());
        assertEquals(25, r.getSpeed());
        assertEquals("Hill Dwarf", r.getSubrace());
    }

    @Test
    public void abilityScoreTest() throws IOException {
        RaceFactory fac = new RaceFactory();
        Race r = fac.createRace("dwarf");

        HashMap<String,Integer> abilityScores = new HashMap<>();
        abilityScores.put("Constitution", 2);
        abilityScores.put("Wisdom", 1);

        assertEquals(abilityScores, r.getAbilityScoreIncreases());
    } 

    @Test
    public void languageTest() throws IOException {
        RaceFactory fac = new RaceFactory();
        Race r = fac.createRace("dwarf");

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Common");
        languages.add("Dwarvish");

        assertEquals(languages, r.getLanguages());
    }

    @Test
    public void featureTest() throws IOException {
        RaceFactory fac = new RaceFactory();
        Race r = fac.createRace("dwarf");

        assertEquals("Darkvision", r.getFeatures().get(0).getName());
        assertEquals("Dwarven Toughness", r.getFeatures().get(5).getName());
    }
}
