package dnd.e;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import item.Item;
import item.ItemComparator;
import item.Armor;
import item.Currency;
import item.EquipmentPack;
import item.ItemFactory;
import item.Mount;
import item.Weapon;
import item.WeaponDamage;

public class ItemFactoryTest {
    // Test basic item
    @Test
    public void basicItemTest() throws IOException {
        ItemFactory fac = new ItemFactory();
        Item i = fac.createItem("barrel");
        
        assertEquals("Barrel", i.getName());
        assertEquals(70, i.getWeight());
        assertEquals(new Currency(200), i.getCost());
        assertEquals("", i.getDescription());
    }

    // Test armor
    @Test
    public void armorTest() throws IOException {
        ItemFactory fac = new ItemFactory();
        Armor a = (Armor) fac.createItem("padded");

        assertEquals("Light", a.getArmorType());
        assertEquals(11, a.getArmorClass());
        assertEquals(0, a.getStrengthRequirement());
        assertEquals(true, a.getStealthDisadvantage());
    }

    // Test weapon
    @Test
    public void weaponTest() throws IOException {
        ItemFactory fac = new ItemFactory();
        Weapon w = (Weapon) fac.createItem("club");

        assertEquals("Simple Melee", w.getWeaponType());
        assertEquals("Light", w.getProperties().get(0));

        // Test weapon damage
        WeaponDamage damage = w.getDamage();
        assertEquals(4, damage.getHitDice());
        assertEquals(1, damage.getNumDice());
        assertEquals("bludgeoning", damage.getDamageType());
    }

    // Test equipment pack
    @Test
    public void equipmentPackTest() throws IOException {
        ItemFactory fac = new ItemFactory();
        EquipmentPack ep = (EquipmentPack) fac.createItem("explorer's pack");

        ArrayList<Item> itemList = new ArrayList<>();
        HashMap<String,Integer> quantities = new HashMap<>();

        // Add equipment pack items to itemList
        itemList.add(fac.createItem("backpack"));
        itemList.add(fac.createItem("bedroll"));
        itemList.add(fac.createItem("mess kit"));
        itemList.add(fac.createItem("torch"));
        itemList.add(fac.createItem("rations"));
        itemList.add(fac.createItem("waterskin"));
        itemList.add(fac.createItem("rope, hempen"));

        // Add quantities of each item to hashmap
        quantities.put("backpack", 1);
        quantities.put("bedroll", 1);
        quantities.put("mess kit", 1);
        quantities.put("torch", 10);
        quantities.put("rations", 10);
        quantities.put("waterskin", 1);
        quantities.put("rope, hempen", 1);

        EquipmentPack newPack = new EquipmentPack("Explorer's Pack", 59.0, new Currency(1000), "", itemList, quantities);
        
        assertTrue(newPack.equals(ep));
    }

    // Test mount
    @Test
    public void mountTest() throws IOException {
        ItemFactory fac = new ItemFactory();
        Mount m = (Mount) fac.createItem("camel");

        assertEquals(50, m.getSpeed());
        assertEquals(480, m.getCarryingCapacity());
    }
}
