package bg.elsys.ip.rest.data;

import bg.elsys.ip.rest.models.Product;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by rokner on 11/14/16.
 */
public class DatabaseMock {
    private static DatabaseMock instance = null;

    private List<Product> products;

    protected DatabaseMock() {
        products = DataGenerator.generateProducts();
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
}
