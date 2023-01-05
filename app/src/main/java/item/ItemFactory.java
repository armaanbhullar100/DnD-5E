package item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.FileLoader;

public class ItemFactory {
    String jsonString;

    public ItemFactory() throws IOException {
        try {
            this.jsonString = FileLoader.loadResourceFile("items.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Searches 'items.json' for itemName and uses it to create new Item object 
     * @param itemName the name of the item to be created
     * @return The newly created item
     * @throws JSONException If the item name is wrong or it doesn't exist
     */
    public Item createItem(String itemName) {
        
        JSONObject newItem;
        try {
            newItem = new JSONObject(jsonString).getJSONObject(itemName.toLowerCase());
        } catch (Exception e) {
            // If item cannot be found, return basic info
            return null;
        } 

        String name = newItem.getString("name");
        Double weight = newItem.getDouble("weight");
        Currency cost = new Currency(newItem.getInt("cost"));
        String description = newItem.getString("description");
        
        // Create item based on its type
        String itemType = newItem.getString("itemType");
        if (itemType.equals("Armor")) {
            return createArmor(newItem, name, weight, cost, description);
        } else if (itemType.equals("Weapon")) {
            return createWeapon(newItem, name, weight, cost, description);
        } else if (itemType.equals("Ammunition")) {
            return createAmmunition(newItem, name, weight, cost, description);
        } else if (itemType.equals("Equipment Pack")) {
            return creatEquipmentPack(newItem, name, weight, cost, description);
        } else if (itemType.equals("Mount")) {
            return createMount(newItem, name, weight, cost, description);
        } else {
            return new Item(name, weight, cost, description);
        }
    }

    private Armor createArmor(JSONObject armor, String name, Double weight, Currency cost, String description) {
        String armorType = armor.getString("armorType");
        int armorClass = armor.getInt("armorClass");
        int strengthRequirement = armor.getInt("strengthRequirement");
        boolean stealthDisadvantage = armor.getBoolean("stealthDisadvantage");

        return new Armor(name, weight, cost, description, armorType, armorClass, strengthRequirement, stealthDisadvantage);
    }

    private Weapon createWeapon(JSONObject weapon, String name, Double weight, Currency cost, String description) {
        String weaponType = weapon.getString("weaponType");
        WeaponDamage damage = new WeaponDamage(weapon.getString("damage"));

        JSONArray jsonArray = weapon.getJSONArray("properties");
        ArrayList<String> properties = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                properties.add(jsonArray.getString(i));
            }
        }

        return new Weapon(name, weight, cost, description, weaponType, damage, properties);
    }

    private Ammunition createAmmunition(JSONObject ammo, String name, Double weight, Currency cost, String description) {
        int amount = ammo.getInt("amount");

        return new Ammunition(name, weight, cost, description, amount);
    }

    private EquipmentPack creatEquipmentPack(JSONObject pack, String name, Double weight, Currency cost, String description) {
        JSONObject jsonItems = pack.getJSONObject("items");
        Iterator<String> iteratorItems = jsonItems.keys();
        ArrayList<Item> items = new ArrayList<>();
        HashMap<String,Integer> quantities = new HashMap<>();
        
        while (iteratorItems.hasNext()) {
            String itemName = iteratorItems.next();
            int num = jsonItems.getInt(itemName);
            items.add(createItem(itemName));
            quantities.put(itemName, num);
        }

        return new EquipmentPack(name, weight, cost, description, items, quantities);
    }

    private Mount createMount(JSONObject mount, String name, Double weight, Currency cost, String description) {
        int speed = mount.getInt("speed");
        int carryingCapacity = mount.getInt("carryingCapacity");

        return new Mount(name, weight, cost, description, speed, carryingCapacity);
    }
}
