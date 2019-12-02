import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {
    private ArrayList<String[]> itemList = new ArrayList<>();
    private Inventory inventory = new Inventory();

    public void parse(String input) {
        createFoodDataList(input);
        createFoodList();
        inventory.inventoryPrices();
        inventory.printInventory();
    }

    public String[] splitByObjects(String input) {
        return input.split("##");
    }

    public String[] splitIntoPairs(String input) {
        return input.split("[^\\w:./]");
    }

    public String valueStringPattern(String item) {
        Pattern p = Pattern.compile("(?<=[:])\\w+");
        Matcher m = p.matcher(item);
        while (m.find()) {
            return m.group();
        }
        return null;
    }

    public String valuePricePattern(String item) {
        Pattern p = Pattern.compile("(?<=[:])\\w+\\W+\\w+\\b");
        Matcher m = p.matcher(item);
        while (m.find()) {
            return m.group();
        }
        return null;
    }

    public String valueDatePattern(String item) {
        Pattern p = Pattern.compile("(?<=[:])\\w+\\W++\\w+\\W+\\w+\\b");
        Matcher m = p.matcher(item);
        while (m.find()) {
            return m.group();
        }
        return null;
    }


    public ArrayList createFoodDataList(String input) {
        String[] objects = splitByObjects(input);
        for (int i = 0; i < objects.length; i++) {
            String[] foodObject = splitIntoPairs(objects[i]);
            itemList.add(foodObject);
        }
        return null;
    }

    public ArrayList createFoodList() {
        for (String[] item : itemList) {
            String name = valueStringPattern(item[0]);
            String price = valuePricePattern(item[1]);
            String expiration = valueDatePattern(item[2]);
            String type = valueStringPattern(item[3]);

            Item newItem = new Item(name, price, expiration, type);
            inventory.itemList.add(newItem);
        }
        return null;
    }
}
