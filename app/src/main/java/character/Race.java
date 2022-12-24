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

    public Race(String name, ArrayList<AbilityScore> abilityScoreIncrease, int age, String size, int speed, ArrayList<Feature> traits, ArrayList<String> languages, String subrace) {
        this.name = name;
        this.abilityScoreIncreases = abilityScoreIncrease;
        this.age = age;
        this.size = size;
        this.speed = speed;
        this.traits = traits;
        this.languages = languages;
        this.subrace = subrace;
    }

    public String getName() {
        return name;
    }

    public ArrayList<AbilityScore> getAbilityScoreIncreases() {
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

    public ArrayList<Feature> getTraits() {
        return traits;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String getSubrace() {
        return subrace;
    }

    
}
