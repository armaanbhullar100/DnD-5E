package item;

import java.util.ArrayList;

public class Weapon extends Item {
    private String weaponType;
    private WeaponDamage damage;
    private ArrayList<String> properties = new ArrayList<>();

    public Weapon(String name, Double weight, Currency cost, String description, String itemType, int amount, String weaponType, WeaponDamage damage, ArrayList<String> properties) {
        super(name, weight, cost, description, itemType, amount);
        this.weaponType = weaponType;
        this.damage = damage;
        this.properties = properties;
    }

    public String getWeaponType() {
        return this.weaponType;
    }

    public WeaponDamage getDamage() {
        return this.damage;
    }

    public ArrayList<String> getProperties() {
        return this.properties;
    }
}
