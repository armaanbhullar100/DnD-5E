package item;

import java.io.IOException;

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
            newItem = new JSONObject(jsonString).getJSONObject(itemName);
        } catch (Exception e) {
            throw new JSONException("item does not exist");
        } 
        
        // Create item based on its type
        String itemType = newItem.getString("itemtype");
        if (itemType.equals("Armor")) {
            return createArmor(newItem);
        } else if (itemType.equals("Weapon")) {
            return createWeapon(newItem);
        } else if (itemType.equals("Adventuring Gear")) {
            return createAdventuringGear(newItem);
        } else {
            return createBasicItem(newItem);
        }
    }

    private Item createBasicItem(JSONObject newItem) {
        return null;
    }

    private Armor createArmor(JSONObject armor) {
        return null;
    }

    private Weapon createWeapon(JSONObject weapon) {
        return null;
    }

    private AdventuringGear createAdventuringGear(JSONObject gear) {
        return null;
    }
}
