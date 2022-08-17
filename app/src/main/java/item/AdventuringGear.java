package item;

public class AdventuringGear extends Item {
    String description;

    public AdventuringGear(String name, int weight, Currency cost, String description) {
        super(name, weight, cost);
        this.description = description;
    }
}
