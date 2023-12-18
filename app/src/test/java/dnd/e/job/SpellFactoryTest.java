package dnd.e.job;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import magic.Spell;
import magic.SpellFactory;

public class SpellFactoryTest {
    @Test
    public void basicSpellTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        SpellFactory fac = new SpellFactory(scan);
        Spell s = fac.createSpell("acid splash");

        assertEquals("Acid Splash", s.getName());
        assertEquals(0, s.getLevel());
        assertEquals("Conjuration", s.getSchool());
        assertEquals("1 action", s.getCastingTime());
        assertEquals(60, s.getRange());
        assertEquals("V, S", s.getComponents());
        assertEquals("Instantaneous", s.getDuration());
        assertEquals(false, s.getRitual());
    }

    @Test
    public void spellUsedByTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        SpellFactory fac = new SpellFactory(scan);
        
        Spell s = fac.createSpell("acid splash");
        ArrayList<String> newUsedBy = new ArrayList<>();
        newUsedBy.add("Artificer");
        newUsedBy.add("Sorcerer");
        newUsedBy.add("Wizard");

        assertEquals(newUsedBy, s.getUsedBy());
    }
}
