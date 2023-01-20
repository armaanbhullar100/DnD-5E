package character;

public class AbilityScore {
    private int value;

    public AbilityScore(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        AbilityScore as = (AbilityScore) obj;

        if (value != as.getValue()) {
            return false;
        }

        return true;
    }

    public int getValue() {
        return value;
    }

    public int getModifier() {
        return Math.floorDiv((value - 10),2);
    }

}
