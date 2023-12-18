package magic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import util.FileLoader;

public class SpellFactory {
    String jsonString;
    Scanner scan;

    public SpellFactory(Scanner scan) throws IOException {
        this.scan = scan;
        try {
            this.jsonString = FileLoader.loadResourceFile("spells.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Spell createSpell(String spellName) throws IOException {
        JSONObject newSpell;

        try {
            newSpell = new JSONObject(jsonString).getJSONObject(spellName.toLowerCase());
        } catch (Exception e) {
            // If item cannot be found, return basic item
            return new Spell(spellName, 0, "", "", 0, "", "", "", null, null);
        } 

        String name = newSpell.getString("name");
        int level = newSpell.getInt("level");
        String school = newSpell.getString("school");
        String castingTime = newSpell.getString("castingTime");
        int range = newSpell.getInt("range");
        String components = newSpell.getString("components");
        String duration = newSpell.getString("duration");
        String description = newSpell.getString("description");
        
        JSONArray jsonUsedBy = newSpell.getJSONArray("usedBy");
        ArrayList<String> usedBy = new ArrayList<>();
        for (int i = 0; i < jsonUsedBy.length(); i++) {
            usedBy.add(jsonUsedBy.getString(i));
        }
        
        Boolean ritual = newSpell.getBoolean("ritual");
        
        return new Spell(name, level, school, castingTime, range, components, duration, description, usedBy, ritual);
    }

}
