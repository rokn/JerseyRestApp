package bg.elsys.ip.rest.data;

import bg.elsys.ip.rest.models.Product;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rokner on 11/14/16.
 */
public class DataGenerator {
    public static List<Product> generateProducts(){
        List<Product> products = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            products.add(new Product("Coca Cola", df.parse("10/12/2017"), 100, 2.20f, "Coca Cola", "Food", "13908434"));
            products.add(new Product("Biscuits 'Izgrev'", df.parse("31/06/2017"), 24, 0.99f, "Pobeda", "Food", "54738988"));
            products.add(new Product("Lindt candy", df.parse("15/09/2017"), 16, 9.99f, "Inkofoods", "Food", "324978324"));
            products.add(new Product("Colgate toothpaste", df.parse("15/12/2018"), 24, 3.79f, "Colgate", "Non-Food", "43274239847"));
            products.add(new Product("Bushmil's whiskey", df.parse("12/12/2024"), 5, 32.99f, "Avendi", "Drinks", "42793247"));
            products.add(new Product("Yoghurt 'Vereia' 4.5%", df.parse("02/12/2016"), 42, 0.99f, "OMK", "Frishe", "32642632"));
            products.add(new Product("Yoghurt 'Activia'", df.parse("15/12/2016"), 18, 1.49f, "Danone", "Frishe", "34579347"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return products;
    }
}
