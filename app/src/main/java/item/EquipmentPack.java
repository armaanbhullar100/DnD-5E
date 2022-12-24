package item;

import java.util.ArrayList;

public class EquipmentPack extends Item {

    private ArrayList<Item> items = new ArrayList<>();

    public EquipmentPack(String name, Double weight, Currency cost, ArrayList<Item> items) {
        super(name, weight, cost);
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
}
