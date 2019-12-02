import org.junit.*;

public class ItemTest {
    private Item item;

    @Before
    public void setup(){
        item = new Item("name", "price", "type", "expiration");
    }

    @Test
    public void replaceMilkValuePatternTest(){
        String expected = "Milk";
        String actual= item.fixMilk("mIlK");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceCookiesValuePatternTest(){
        String expected = "Cookies";
        String actual= item.fixCookies("c00KiE");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceBreadValuePatternTest(){
        String expected = "Bread";
        String actual= item.fixBread("BrEaD");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceApplesValuePatternTest() {
        String expected = "Apples";
        String actual = item.fixApples("ApPlEs");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPriceTest() {
        Item item1 = new Item("Milk", "3.23", "Food", "1/25/2016");
        try {
            item1.fixMilk(item1.getName());
        } catch (Exception e) {

        }
        Integer expected = 2;
        Integer actual = Item.getCount("Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceAllFoodObjectNamesTest() {
        try {
            item.replaceAllFoodObjectNames(item.getName());
        } catch (Exception e) {

        }
        String expected = "Milk";
        String actual = item.fixMilk("mIlK");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCounterTest(){
        Item item1 = new Item("Milk", "3.23", "Food", "1/25/2016");
        item1.fixMilk(item1.getName());
        Integer expected = 4;
        Integer actual= Item.getCount("Milk") ;
        Assert.assertEquals(expected, actual);
    }


}
