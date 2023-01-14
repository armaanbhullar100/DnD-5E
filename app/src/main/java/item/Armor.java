package item;

public class Armor extends Item {
    private String armorType;
    private int armorClass;
    private int strengthRequirement;
    private boolean stealthDisadvantage;

    public Armor(String name, Double weight, Currency cost, String description, int amount, String armorType, int armorClass, int strengthRequirement, boolean stealthDisadvantage) {
        super(name, weight, cost, description, amount);
        this.armorType = armorType;
        this.armorClass = armorClass;
        this.strengthRequirement = strengthRequirement;
        this.stealthDisadvantage = stealthDisadvantage;
    }

    public String getArmorType() {
        return this.armorType;
    }

    public int getArmorClass() {
        return this.armorClass;
    }

    public int getStrengthRequirement() {
        return this.strengthRequirement;
    }

    public boolean getStealthDisadvantage() {
        return this.stealthDisadvantage;
    }
}
