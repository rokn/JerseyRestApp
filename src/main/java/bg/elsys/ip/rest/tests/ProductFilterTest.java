package bg.elsys.ip.rest.tests;

import bg.elsys.ip.rest.models.Product;
import bg.elsys.ip.rest.resources.PagedResponse;
import bg.elsys.ip.rest.resources.ProductFilter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ProductFilterTest {
    @Test
    public void filterProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Banan", "05/11/2020", 50, 2, "DOLE", "Food", "123456789"));
        products.add(new Product("Portokal", "05/11/2020", 1000, 1, "DOLE", "Food", "123456789"));
        ProductFilter productFilter = new ProductFilter(0, 5, "Banan", null, null, null, null, null);
        PagedResponse response = productFilter.filterProducts(products);
        List<Product> resultList = response.getProducts();

        for (Product product : resultList) {
            assertEquals("Banan", product.getName());
        }
    }
}

