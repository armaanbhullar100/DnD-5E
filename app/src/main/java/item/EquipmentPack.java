package item;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }

        EquipmentPack ep = (EquipmentPack) obj;

        ArrayList<Item> list1 = items;
        ArrayList<Item> list2 = ep.getItems();
        Collections.sort(list1, new ItemComparator());
        Collections.sort(list2, new ItemComparator());

        if (!getName().equals(ep.getName())) {
            return false;
        } else if (!getWeight().equals(ep.getWeight())) {
            return false;
        } else if (!getCost().equals(ep.getCost())) {
            return false;
        } else if (!getDescription().equals(ep.getDescription())) {
            return false;
        } else if (!items.equals(ep.getItems())) {
            return false;
        } else if (!quantities.equals(ep.getQuantities())) {
            return false;
        }

        return true;
    }
    
}
