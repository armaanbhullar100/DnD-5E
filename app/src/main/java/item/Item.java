package item;

public class Item {
    String name;
    int weight;
    Currency cost;

    public Item(String name, int weight, Currency cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
}
