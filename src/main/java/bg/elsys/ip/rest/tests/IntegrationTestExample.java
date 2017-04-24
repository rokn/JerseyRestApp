package bg.elsys.ip.rest.tests;

import bg.elsys.ip.rest.data.DatabaseMock;
import bg.elsys.ip.rest.models.Product;
import bg.elsys.ip.rest.resources.PagedResponse;
import bg.elsys.ip.rest.resources.ProductFilter;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class IntegrationTestExample {
    @Test
    public void TestFilterWithDatabase() {
        TJWSEmbe
        //First component(database)
        List<Product> products = DatabaseMock.getInstance().getProducts();
        String provider = products.get(1).getProvider();
        System.out.println(provider);

        //Second component(filter component)
        ProductFilter productFilter = new ProductFilter(0, 5, null, null, null, provider, null, null);
        PagedResponse response = productFilter.filterProducts(products);
        List<Product> resultList = response.getProducts();
        System.out.println(resultList.size());

        for (Product product : resultList) {
            assertEquals(provider, product.getProvider());
        }
    }
}
