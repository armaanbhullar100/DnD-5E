package dnd.e;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import item.WeaponDamage;

public class WeaponDamagetest {
    @Test
    public void basicTest() {
        WeaponDamage damage = new WeaponDamage("1d4 bludgeoning");
        assertEquals(4, damage.getHitDice());
        assertEquals(1, damage.getNumDice());
        assertEquals("bludgeoning", damage.getDamageType());
    }
}
