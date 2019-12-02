import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
    ArrayList<Item> itemList = new ArrayList<>();
    private Map<String, Map<String, Integer>> priceList = new LinkedHashMap<>();
    private Map<String, Integer> milkPrices = new HashMap<>();
    private Map<String, Integer> breadPrices = new HashMap<>();
    private Map<String, Integer> cookiePrices = new HashMap<>();
    private Map<String, Integer> applePrices = new HashMap<>();

    public void populateMap(Item item, Map<String, Integer> map){
        String price = item.getPrice();
        if(map.containsKey(price)){
            map.put(price, map.get(price) + 1);
        } else {
            map.put(price, 1);
        }
    }

    public void fixItem(Item item) throws NullValueException {
        item.replaceAllFoodObjectNames(item.getName());
        item.checkPrice();
    }


    public void inventoryPrices() {
        for (Item item : itemList) {
            try {
                fixItem(item);
                    switch (item.getName()) {
                        case "Milk":
                            populateMap(item, milkPrices);
                            break;
                        case "Bread":
                            populateMap(item, breadPrices);
                            break;
                        case "Cookies":
                            populateMap(item, cookiePrices);
                            break;
                        case "Apples":
                            populateMap(item, applePrices);
                }

            } catch (Exception e) {
                NullValueException.count++;
            }
        }
    }

    public void populateMapList(){
        priceList.put("Milk", milkPrices);
        priceList.put("Bread", breadPrices);
        priceList.put("Cookies", cookiePrices);
        priceList.put("Apples", applePrices);
    }


    public String createInventoryItemFormat(String name){
        return String.format("name:%10s" + "         seen:  " + Item.getCount(name) + "  times\n" + doubleLine(), name);

    }

    public String doubleLine(){
        return "===============         ===============";
    }

    public String singleLine(){
        return "---------------         ---------------";
    }

    public String createPriceFormat(Map<String, Integer> map){
        StringBuilder priceGroup = new StringBuilder();
        for (String price : map.keySet()){
            StringBuilder priceLine = new StringBuilder("Price:   " +
                    price + "           seen:  " +
                    map.get(price) + " times\n" +
                    singleLine() + "\n");
            priceGroup.append(priceLine.toString());
        }
        return priceGroup.toString();
    }

    public String printErrors() {
        StringBuilder errorLine = new StringBuilder("Errors:      ");
        errorLine.append("            ");
        errorLine.append("seen:  ");
        errorLine.append(NullValueException.count);
        errorLine.append(" times");
        return errorLine.toString();
    }

    public void printInventory(){
        populateMapList();
        for (String name: priceList.keySet()) {
            System.out.println(createInventoryItemFormat(name));
            System.out.println(createPriceFormat(priceList.get(name)));
        }
        System.out.println(printErrors());
    }
}
