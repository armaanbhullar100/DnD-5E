package item;

import java.util.ArrayList;

public class Weapon extends Item {
    String type;
    WeaponDamage damage;
    ArrayList<String> properties = new ArrayList<>();

    public Weapon(String name, int weight, Currency cost, String type, WeaponDamage damage, ArrayList<String> properties) {
        super(name, weight, cost);
        this.type = type;
        this.damage = damage;
        this.properties = properties;
    }
}
