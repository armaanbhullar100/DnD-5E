package dnd.e;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import item.Currency;

public class CurrencyTest {
    @Test
    public void basicTest() {

        Currency curr = new Currency(250);
        assertEquals(2, curr.getGoldPieces());
        assertEquals(5, curr.getSilverPieces());
    }

    @Test
    public void smallValueTest() {
        Currency curr = new Currency(1);
        assertEquals(1, curr.getCopperPieces());
    }

    @Test
    public void equalTest() {
        Currency curr1 = new Currency(200);
        Currency curr2 = new Currency(200);

        assertTrue(curr1.equals(curr2));
    }

}
