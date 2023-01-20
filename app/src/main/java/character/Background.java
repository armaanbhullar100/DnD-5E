package character;

import java.util.ArrayList;

import item.Item;

public class Background {
    private String name;
    private ArrayList<String> skillProficiencies = new ArrayList<>();
    private ArrayList<String> toolProficiencies = new ArrayList<>();
    private ArrayList<String> languages = new ArrayList<>();
    private ArrayList<Item> equipment = new ArrayList<>();
    private ArrayList<Feature> features = new ArrayList<>();

    public Background(String name, ArrayList<String> skillProficiencies, ArrayList<String> toolProficiencies, ArrayList<String> languages, ArrayList<Item> equipment, ArrayList<Feature> features) {
        this.name = name;
        this.skillProficiencies = skillProficiencies;
        this.toolProficiencies = toolProficiencies;
        this.languages = languages;
        this.equipment = equipment;
        this.features = features;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Background b = (Background) obj;
        if (!name.equals(b.getName())) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSkillProficiencies() {
        return skillProficiencies;
    }

    public ArrayList<String> getToolProficiencies() {
        return toolProficiencies;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public ArrayList<Item> getEquipment() {
        return equipment;
    }
    
    public ArrayList<Feature> getFeatures() {
        return features;
    }

    
}

