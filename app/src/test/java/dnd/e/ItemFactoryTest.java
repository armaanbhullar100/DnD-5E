package dnd.e;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import item.Currency;
import item.Item;
import item.ItemFactory;
import item.Weapon;
import item.WeaponDamage;

public class ItemFactoryTest {
    @Test
    public void basicItemTest() throws IOException {
        ItemFactory fac = new ItemFactory();
        Item i = fac.createItem("barrel");
        
        assertEquals("barrel", i.getName());
        assertEquals(70, i.getWeight());
        assertEquals(new Currency(2), i.getCost());
    }

    @Test
    public void armorTest() throws IOException {

    }

    @Test
    public void weaponTest() throws IOException {

    }

    @Test void adventuringGearTest() throws IOException {
        
    }
}
