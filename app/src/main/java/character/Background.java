package character;

import java.util.ArrayList;

import item.Item;

public class Background {
    private String name;
    private ArrayList<Skill> skillProficiencies = new ArrayList<>();
    private ArrayList<Item> toolProficiencies = new ArrayList<>();
    private ArrayList<String> languages = new ArrayList<>();
    private ArrayList<Item> equipment = new ArrayList<>();

    public Background() {

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Skill> getSkillProficiencies() {
        return this.skillProficiencies;
    }

    public ArrayList<Item> getToolProficiencies() {
        return this.toolProficiencies;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<Item> getEquipment() {
        return equipment;
    }

    
}

