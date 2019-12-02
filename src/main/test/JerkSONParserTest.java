import org.junit.*;

public class JerkSONParserTest {
    private JerkSONParser jerkSONParser;
    private Inventory inventory;

    @Before
    public void setUp(){
        jerkSONParser = new JerkSONParser();
        inventory = new Inventory();
    }

    @Test
    public void splitByObjectTest(){
        String[] expected = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016", "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};
        String[] actual= jerkSONParser.splitByObjects("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void splitByPairsTest(){
        String[] expected = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016", "naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016", "NAMe:BrEAD", "price:1.23", "type:Food", "expiration:2/25/2016"};
        String[] actual= jerkSONParser.splitIntoPairs("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016;naME:BreaD;price:1.23;type:Food;expiration:1/02/2016;NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void valueStringPatternTest() {
        String expected = "Milk";
        String actual= jerkSONParser.valueStringPattern("naMe:Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valuePricePatternTest() {
        String expected = "3.23";
        String actual= jerkSONParser.valuePricePattern("price:3.23");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueDatePatternTest() {
        String expected = "1/25/2016";
        String actual= jerkSONParser.valueDatePattern("expiration:1/25/2016");
        Assert.assertEquals(expected, actual);
    }


}
