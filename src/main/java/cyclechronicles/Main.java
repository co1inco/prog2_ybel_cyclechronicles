package cyclechronicles;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        var shopLogger = Logger.getLogger(Shop.class.getName());
        shopLogger.setLevel(Level.INFO);

//        var logger = Logger.getLogger("");
//        logger.setLevel(Level.WARNING);

        var shop = new Shop();

        var order = new Order(Type.RACE, "customer1");

        shop.accept(order);
        shop.repair();
        shop.deliver("customer1");
    }
}
