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
        String expected = "name:      Milk         seen:  0  times\n" +
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
        Map<String, Integer> map = new HashMap();
        map.put("Milk", 1);

        String expected = "Price:     Milk         seen:  1 times\n" +
                "---------------         ---------------\n";
        String actual = inventory.createPriceFormat(map);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printErrorsTest() {
        String expected = "Errors:                 seen:  0 times";
        String actual =inventory.printErrors();

        Assert.assertEquals(expected, actual);
    }

}
