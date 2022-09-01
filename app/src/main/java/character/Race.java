package character;

import java.util.ArrayList;

public class Race {
    private String name;
    private ArrayList<AbilityScore> abilityScoreIncreases = new ArrayList<>();
    private int age;
    private String size;
    private int speed;
    private ArrayList<Feature> traits = new ArrayList<>();
    private ArrayList<String> languages = new ArrayList<>();
    private String subrace;

    public Race() {

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<AbilityScore> getAbilityScoreIncreases() {
        return this.abilityScoreIncreases;
    }

    public int getAge() {
        return this.age;
    }

    public String getSize() {
        return this.size;
    }

    public int getSpeed() {
        return this.speed;
    }

    public ArrayList<Feature> getTraits() {
        return this.traits;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public String getSubrace() {
        return this.subrace;
    }

    
}
