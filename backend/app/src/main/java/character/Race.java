package character;

import java.util.ArrayList;
import java.util.HashMap;

public class Race {
    private String name;
    private HashMap<String,Integer> abilityScoreIncreases = new HashMap<>();
    private int age;
    private String size;
    private int speed;
    private ArrayList<Feature> features = new ArrayList<>();
    private ArrayList<String> languages = new ArrayList<>();
    private String subrace;

    public Race(String name, HashMap<String,Integer> abilityScoreIncrease, String size, int speed, ArrayList<Feature> features, ArrayList<String> languages, String subrace) {
        this.name = name;
        this.abilityScoreIncreases = abilityScoreIncrease;
        this.size = size;
        this.speed = speed;
        this.features = features;
        this.languages = languages;
        this.subrace = subrace;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Race r = (Race) obj;
        if (!name.equals(r.getName())) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public HashMap<String,Integer> getAbilityScoreIncreases() {
        return abilityScoreIncreases;
    }

    public int getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String getSubrace() {
        return subrace;
    }

    
}
