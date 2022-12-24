package item;

public class Item {
    private String name;
    private Double weight;
    private Currency cost;

    public Item(String name, Double weight, Currency cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
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
}
