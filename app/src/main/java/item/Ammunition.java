package item;

public class Ammunition extends Item {
    int amount;

    public Ammunition(String name, int weight, Currency cost, int amount) {
        super(name, weight, cost);
        this.amount = amount;
    }
    
}
