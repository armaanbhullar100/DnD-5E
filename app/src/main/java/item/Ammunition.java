package item;

public class Ammunition extends Item {
    private int amount;

    public Ammunition(String name, Double weight, Currency cost, String description, int amount) {
        super(name, weight, cost, description);
        this.amount = amount;
    }
    
    public int getAmount() {
        return this.amount;
    }
}
