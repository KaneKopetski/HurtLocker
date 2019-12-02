import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    private String name;
    private String price;
    private String type;
    private String expiration;
    private static Integer milkCount = 0;
    private static Integer breadCount = 0;
    private static Integer appleCount = 0;
    private static Integer cookieCount = 0;

    public Item() {
    }

    public Item(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }


    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }


    public String fixMilk(String foodName) {
        Pattern p = Pattern.compile("(?i)^m\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            this.name = "Milk";
            milkCount++;
            return this.name;
        }
        return null;
    }

    public String fixCookies(String foodName) {
        Pattern p = Pattern.compile("(?i)^c\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            this.name = "Cookies";
            cookieCount++;
            return this.name;
        }
        return null;
    }

    public String fixBread(String foodName) {
        Pattern p = Pattern.compile("(?i)^b\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            this.name = "Bread";
            breadCount++;
            return this.name;
        }
        return null;
    }

    public String fixApples(String foodName) {
        Pattern p = Pattern.compile("(?i)^a\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            this.name = "Apples";
            appleCount++;
            return this.name;
        }
        return null;
    }

    public static Integer getCount(String name) {
        Integer temp = 0;
        switch (name) {
            case "Milk":
                temp = milkCount;
                break;
            case "Bread":
                temp = breadCount;
                break;
            case "Cookies":
                temp = cookieCount;
                break;
            case "Apples":
                temp = appleCount;
        }
        return temp;
    }

    public void replaceAllFoodObjectNames(String itemName) throws NullValueException {
        if (itemName == null) {
            throw new NullValueException("Name is null.");
        }
        fixMilk(itemName);
        fixCookies(itemName);
        fixBread(itemName);
        fixApples(itemName);
    }

    public void checkPrice() throws NullValueException {
        if(this.price == null){
            switch (name) {
                case "Milk":
                    milkCount--;
                    break;
                case "Bread":
                    breadCount--;
                    break;
                case "Cookies":
                    cookieCount--;
                    break;
                case "Apples":
                    appleCount--;
            }
            throw new NullValueException("Null Value");
        }
    }
}
