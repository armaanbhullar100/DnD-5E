package dnd.e;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import item.Item;
import item.Armor;
import item.EquipmentPack;
import item.ItemFactory;
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
        assertEquals(2, i.getCost().getGoldPieces());
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

        Item i1 = fac.createItem("torch");
        Item i2 = fac.createItem("torch");
        assertEquals(i2, i1);

        System.err.println(ep.getItems());
        System.err.println(ep.getQuantities());
    }
}
