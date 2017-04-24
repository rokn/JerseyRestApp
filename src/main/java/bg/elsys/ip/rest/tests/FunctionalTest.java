package bg.elsys.ip.rest.tests;


import bg.elsys.ip.rest.models.Product;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FunctionalTest {
    @Test
    public void functionalTest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("rest/products?page=1&perPage=5&prodName=\"Coca Cola\"");

        List<Product> products = target.request(MediaType.APPLICATION_JSON_TYPE).get(List.class);

        for(Product product:products) {
            assertEquals("Coca Cola", product.getName());
        }
    }
}
