package character;

public class Skill {
    private boolean proficient;
    private int value;

    public Skill(boolean proficient, int value) {
        this.proficient = proficient;
        this.value = value;
    }

    public boolean getProficient() {
        return proficient;
    }

    public int getValue() {
        return value;
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }
}
