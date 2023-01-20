package dnd.e.item;

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

    @Test
    public void totalCurrencyTest() {
        Currency curr = new Currency(125);
        assertEquals(125, curr.getTotalCurrency());
    }

    @Test
    public void increaseCurrencyTest() {
        Currency curr = new Currency(126);
        curr.increaseCurrency(125);
        
        assertEquals(251, curr.getTotalCurrency());
    }

}
