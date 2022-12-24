package character;

public class Feature {
    private String name;
    private String description;
    private String source;
    private int level;

    public Feature(String name, String description, String source, int level) {
        this.name = name;
        this.description = description;
        this.source = source;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public int getLevel() {
        return level;
    }

    
}
