package item;

public class Item {
    private String name;
    private Double weight;
    private Currency cost;
    private String description;

    public Item(String name, Double weight, Currency cost, String description) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public Double getWeight() {
        return this.weight;
    }

    public Currency getCost() {
        return this.cost;
    }

    public String getDescription() {
        return description;
    }
}
