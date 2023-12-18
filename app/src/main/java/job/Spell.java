package job;

import java.util.ArrayList;

public class Spell {
    private String name;
    private String castingTime;
    private int range;
    private String components;
    private String duration;
    private String description;
    private ArrayList<String> usedBy;
    
    public Spell(String name, String castingTime, int range, String components, String duration, String description, ArrayList<String> usedBy) {
        this.name = name;
        this.castingTime = castingTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
        this.usedBy = usedBy;
    }

    public String getName() {
        return name;
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
    
}
