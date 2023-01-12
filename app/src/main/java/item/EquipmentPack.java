package item;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipmentPack extends Item {
    private ArrayList<Item> items = new ArrayList<>();
    private HashMap<String,Integer> quantities = new HashMap<>();

    public EquipmentPack(String name, Double weight, Currency cost, String description, ArrayList<Item> items, HashMap<String,Integer> quantities) {
        super(name, weight, cost, description);
        this.items = items;
        this.quantities = quantities;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public HashMap<String,Integer> getQuantities() {
        return quantities;
    }
    
    
}
