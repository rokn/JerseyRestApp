package bg.elsys.ip.rest.data;

import bg.elsys.ip.rest.models.AutoCompleter;
import bg.elsys.ip.rest.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rokner on 11/14/16.
 */
public class DatabaseMock {
    private static DatabaseMock instance = null;

    private List<Product> products;

    protected DatabaseMock() {
        products = DataGenerator.generateProducts(50);
    }

    public static DatabaseMock getInstance(){
        if(instance == null){
            instance = new DatabaseMock();
        }

        return instance;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public AutoCompleter generateAutoCompleter(){
        List<String> productNames = products.stream().map(Product::getName).distinct().collect(Collectors.toList());
        List<String> providerNames = products.stream().map(Product::getProvider).distinct().collect(Collectors.toList());
        List<String> departmentNames = products.stream().map(Product::getDepartment).distinct().collect(Collectors.toList());
        List<String> barcodes = products.stream().map(Product::getBarcode).distinct().collect(Collectors.toList());

        return new AutoCompleter(productNames, providerNames, departmentNames, barcodes);
    }
}
