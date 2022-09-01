package character;

import java.util.ArrayList;

import item.Item;

public class CharacterDescription {
    private int age;
    private int height;
    private int weight;
    private String eyes;
    private String skin;
    private String hair;
    private String size;

    private String alliesAndOrganisations;
    private String backstory;
    private String extraFeatures;
    private ArrayList<Item> treasure = new ArrayList<>();
    
    public CharacterDescription() {

    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getEyes() {
        return this.eyes;
    }

    public String getSkin() {
        return this.skin;
    }

    public String getHair() {
        return this.hair;
    }

    public String getSize() {
        return this.size;
    }

    public String getAlliesAndOrganisations() {
        return this.alliesAndOrganisations;
    }

    public String getBackstory() {
        return this.backstory;
    }

    public String getExtraFeatures() {
        return this.extraFeatures;
    }

    public ArrayList<Item> getTreasure() {
        return this.treasure;
    }

    
    
}
