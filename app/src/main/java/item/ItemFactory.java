package item;

import java.io.IOException;
import java.util.ArrayList;

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
            throw new JSONException("item does not exist");
        } 

        String name = newItem.getString("name");
        int weight = newItem.getInt("weight");
        Currency cost = new Currency(newItem.getInt("cost"));
        
        // Create item based on its type
        String itemType = newItem.getString("itemtype");
        if (itemType.equals("Armor")) {
            return createArmor(newItem, name, weight, cost);
        } else if (itemType.equals("Weapon")) {
            return createWeapon(newItem, name, weight, cost);
        } else if (itemType.equals("Adventuring Gear")) {
            return createAdventuringGear(newItem, name, weight, cost);
        } else {
            return new Item(name, weight, cost);
        }
    }

    private Armor createArmor(JSONObject armor, String name, int weight, Currency cost) {
        String armorType = armor.getString("armortype");
        int armorClass = armor.getInt("armorClass");
        int strengthRequirement = armor.getInt("strengthRequirement");
        boolean stealthDisadvantage = armor.getBoolean("stealthDisadvantage");

        return new Armor(name, weight, cost, armorType, armorClass, strengthRequirement, stealthDisadvantage);
    }

    private Weapon createWeapon(JSONObject weapon, String name, int weight, Currency cost) {
        String weaponType = weapon.getString("weaponType");
        WeaponDamage damage = new WeaponDamage(weapon.getString("damage"));

        JSONArray jsonArray = weapon.getJSONArray("properties");
        ArrayList<String> properties = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                properties.add(jsonArray.getString(i));
            }
        }

        return new Weapon(name, weight, cost, weaponType, damage, properties);
    }

    private AdventuringGear createAdventuringGear(JSONObject gear, String name, int weight, Currency cost) {
        String description = gear.getString("description");

        return new AdventuringGear(name, weight, cost, description);
    }
}
