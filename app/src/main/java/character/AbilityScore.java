package character;

public class AbilityScore {
    private int value;
    private int modifier;

    public AbilityScore(int value) {
        this.value = value;
        this.modifier = Math.floorDiv((value - 10),2);
    }

    public int getValue() {
        return value;
    }

    public int getModifier() {
        return modifier;
    }

}
