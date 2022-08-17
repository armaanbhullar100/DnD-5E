package item;

public class Armor extends Item {
    String type;
    int armorClass;
    int strengthRequirement;
    boolean stealthDisadvantage;

    public Armor(String name, int weight, Currency cost, String type, int armorClass, int strengthRequirement, boolean stealthDisadvantage) {
        super(name, weight, cost);
        this.type = type;
        this.armorClass = armorClass;
        this.strengthRequirement = strengthRequirement;
        this.stealthDisadvantage = stealthDisadvantage;
    }
}
