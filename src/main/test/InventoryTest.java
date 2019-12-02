import org.junit.*;

import java.util.HashMap;
import java.util.Map;

public class InventoryTest {
    Inventory inventory;

    @Before
    public void setup() {
        inventory = new Inventory();
    }


    @Test
    public void testCreateInventoryItemFormat() {
        String expected = "name:   Milk            seen:  0  times\n" +
                "===============         ===============";
        String actual = inventory.createInventoryItemFormat("Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDoubleLineFormat() {
        String expected = "===============         ===============";
        String actual = inventory.doubleLine();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSingleLineFormat() {
        String expected = "---------------         ---------------";
        String actual = inventory.singleLine();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreatePriceFormat() {
        System.out.println(inventory.createPriceFormat(new HashMap<String, Integer>()));
    }

}
