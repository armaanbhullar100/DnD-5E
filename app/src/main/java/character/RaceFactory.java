package character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import util.FileLoader;

public class RaceFactory {
    String jsonString;

    public RaceFactory() throws IOException {
        try {
            this.jsonString = FileLoader.loadResourceFile("races.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Race createRace(String raceName) throws IOException {
        JSONObject newRace;

        try {
            newRace = new JSONObject(jsonString).getJSONObject(raceName.toLowerCase());
        } catch (Exception e) {
            // If race cannot be found, return null
            return null;
        }

        String name = newRace.getString("name");
        String size = newRace.getString("size");
        int speed = newRace.getInt("speed");

        // Get main ability scores
        JSONObject abilityScoreIncreaseObject = newRace.getJSONObject("ability score increase");
        Iterator<String> objectKeys = abilityScoreIncreaseObject.keys();
        HashMap<String,Integer> abilityScoreIncrease = new HashMap<>();
        while(objectKeys.hasNext()) {
            String currAbility = objectKeys.next();
            abilityScoreIncrease.put(currAbility, abilityScoreIncreaseObject.getInt(currAbility));
        }

        // Get languages
        JSONArray languageArray = newRace.getJSONArray("languages");
        ArrayList<String> languages = new ArrayList<>();
        for (int i = 0; i < languageArray.length(); i++) {
            languages.add(languageArray.getString(i));
        }

        // Get main race features
        JSONArray jsonArrayFeatures = newRace.getJSONArray("features");
        ArrayList<Feature> features = new ArrayList<>();
        for (int i = 0; i < jsonArrayFeatures.length(); i++) {
            JSONObject currFeature = jsonArrayFeatures.getJSONObject(i);
            features.add(new Feature(currFeature.getString("name"), currFeature.getString("description"), name, currFeature.getInt("level")));
        }

        // Add ability to choose subrace

        JSONObject subrace = newRace.getJSONObject("subraces").getJSONObject("hill dwarf");
        String subraceName = subrace.getString("name");
        
        // Get ability score from subrace
        abilityScoreIncreaseObject = subrace.getJSONObject("ability score increase");
        objectKeys = abilityScoreIncreaseObject.keys();
        while(objectKeys.hasNext()) {
            String currAbility = objectKeys.next();
            abilityScoreIncrease.put(currAbility, abilityScoreIncreaseObject.getInt(currAbility));
        }

        // Get features from subrace
        jsonArrayFeatures = subrace.getJSONArray("features");
        for (int i = 0; i < jsonArrayFeatures.length(); i++) {
            JSONObject currFeature = jsonArrayFeatures.getJSONObject(i);
            features.add(new Feature(currFeature.getString("name"), currFeature.getString("description"), name, currFeature.getInt("level")));
        }

        return new Race(name, abilityScoreIncrease , size, speed, features, languages, subraceName);
    }
}
