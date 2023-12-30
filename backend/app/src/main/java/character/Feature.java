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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Feature f = (Feature) obj;
        if (!name.equals(f.getName())) {
            return false;
        } else if (!description.equals(f.getDescription())) {
            return false;
        } else if (!source.equals(f.getSource())) {
            return false;
        } else if (level != f.getLevel()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return name;
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
