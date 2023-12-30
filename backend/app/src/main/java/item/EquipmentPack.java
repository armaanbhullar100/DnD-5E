package item;

import java.util.ArrayList;
import java.util.Collections;

public class EquipmentPack extends Item {
    private ArrayList<Item> items = new ArrayList<>();

    public EquipmentPack(String name, Double weight, Currency cost, String description, String itemType, int amount, ArrayList<Item> items) {
        super(name, weight, cost, description, itemType, amount);
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
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
        }

        return true;
    }
    
}
