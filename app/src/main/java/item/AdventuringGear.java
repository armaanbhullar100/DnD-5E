package item;

public class AdventuringGear extends Item {
    private String description;

    public AdventuringGear(String name, int weight, Currency cost, String description) {
        super(name, weight, cost);
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
