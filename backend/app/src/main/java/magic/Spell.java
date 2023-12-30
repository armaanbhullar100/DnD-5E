package magic;

import java.util.ArrayList;

public class Spell {
    private String name;
    private int level;
    private String school;
    private String castingTime;
    private int range;
    private String components;
    private String duration;
    private String description;
    private ArrayList<String> usedBy;
    private Boolean ritual;
    
    public Spell(String name, int level, String school, String castingTime, int range, String components, String duration, String description, ArrayList<String> usedBy, Boolean ritual) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.castingTime = castingTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
        this.usedBy = usedBy;
        this.ritual = ritual;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getSchool() {
        return school;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public int getRange() {
        return range;
    }

    public String getComponents() {
        return components;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getUsedBy() {
        return usedBy;
    }
    
    public Boolean getRitual() {
        return ritual;
    }
}
