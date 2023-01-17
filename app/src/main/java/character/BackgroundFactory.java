package character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import item.Item;
import item.ItemFactory;
import util.FileLoader;

public class BackgroundFactory {
    String jsonString;

    public BackgroundFactory() throws IOException {
        try {
            this.jsonString = FileLoader.loadResourceFile("backgrounds.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Background createBackground(String backgroundName) throws IOException {
        ItemFactory fac = new ItemFactory();
        JSONObject newBackground;
        try {
            newBackground = new JSONObject(jsonString).getJSONObject(backgroundName.toLowerCase());
        } catch (Exception e) {
            // If item cannot be found, return null
            return null;
        }

        String name = newBackground.getString("name");

        JSONArray jsonSkillProficiencies = newBackground.getJSONArray("skill proficiencies");
        ArrayList<String> skillProficiencies = new ArrayList<>();
        for (int i = 0; i < jsonSkillProficiencies.length(); i++) {
            skillProficiencies.add(jsonSkillProficiencies.getString(i));
        }

        JSONArray jsonToolProficiencies = newBackground.getJSONArray("tool proficiencies");
        ArrayList<String> toolProficiencies = new ArrayList<>();
        for (int i = 0; i < jsonToolProficiencies.length(); i++) {
            toolProficiencies.add(jsonToolProficiencies.getString(i));
        }

        // WARNING: Add code to handle case where any language can be chosen
        JSONArray jsonLanguages = newBackground.getJSONArray("languages");
        ArrayList<String> languages = new ArrayList<>();
        for (int i = 0; i < jsonLanguages.length(); i++) {
            languages.add(jsonLanguages.getString(i));
        }

        JSONObject jsonEquipment = newBackground.getJSONObject("equipment");
        Iterator<String> iteratorEquipment = jsonEquipment.keys();
        ArrayList<Item> equipment = new ArrayList<>();
        while (iteratorEquipment.hasNext()) {
            String itemName = iteratorEquipment.next();
            int itemAmount = jsonEquipment.getInt(itemName);
            equipment.add(fac.createItemWithCustomAmount(itemName, itemAmount));
        }

        JSONArray jsonFeatures = newBackground.getJSONArray("features");
        ArrayList<Feature> features = new ArrayList<>();
        for (int i = 0; i < jsonFeatures.length(); i++) {
            JSONObject currFeature = jsonFeatures.getJSONObject(i);
            features.add(new Feature(currFeature.getString("name"), currFeature.getString("description"), name, currFeature.getInt("level")));
        }

        return new Background(name, skillProficiencies, toolProficiencies, languages, equipment, features);
    }
}
