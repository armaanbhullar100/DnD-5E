package item;

public class Mount extends Item {

    private int speed;
    private int carryingCapacity;

    public Mount(String name, Double weight, Currency cost, String description, String itemType, int amount, int speed, int carryingCapacity) {
        super(name, weight, cost, description, itemType, amount);
        this.speed = speed;
        this.carryingCapacity = carryingCapacity;
    }
    
    public int getSpeed() {
        return this.speed;
    }

    public int getCarryingCapacity() {
        return this.carryingCapacity;
    }
}
