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

    public CharacterDescription(int age, int height, int weight, String eyes, String skin, String hair, String size, String alliesAndOrganisations, String backstory, String extraFeatures, ArrayList<Item> treasure) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.eyes = eyes;
        this.skin = skin;
        this.hair = hair;
        this.size = size;

        this.alliesAndOrganisations = alliesAndOrganisations;
        this.backstory = backstory;
        this.extraFeatures = extraFeatures;
        this.treasure = treasure;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getEyes() {
        return eyes;
    }

    public String getSkin() {
        return skin;
    }

    public String getHair() {
        return hair;
    }

    public String getSize() {
        return size;
    }

    public String getAlliesAndOrganisations() {
        return alliesAndOrganisations;
    }

    public String getBackstory() {
        return backstory;
    }

    public String getExtraFeatures() {
        return extraFeatures;
    }

    public ArrayList<Item> getTreasure() {
        return treasure;
    }
    
}
