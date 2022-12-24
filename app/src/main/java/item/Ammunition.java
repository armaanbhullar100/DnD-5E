package item;

public class Ammunition extends Item {
    private int amount;

    public Ammunition(String name, Double weight, Currency cost, int amount) {
        super(name, weight, cost);
        this.amount = amount;
    }
    
    public int getAmount() {
        return this.amount;
    }
}
