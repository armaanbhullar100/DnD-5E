package character;

public class SavingThrow {
    private boolean proficient;
    private int value;

    public SavingThrow(boolean proficient, int value) {
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
