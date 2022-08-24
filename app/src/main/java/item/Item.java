package item;

public class Item {
    private String name;
    private int weight;
    private Currency cost;

    public Item(String name, int weight, Currency cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public Currency getCost() {
        return this.cost;
    }
}
