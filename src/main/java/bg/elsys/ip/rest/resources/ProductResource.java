package bg.elsys.ip.rest.resources;

import bg.elsys.ip.rest.data.DatabaseMock;
import bg.elsys.ip.rest.models.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(DatabaseMock.getInstance().getProducts()).build();
	}

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        DatabaseMock.getInstance().addProduct(product);
        return Response.ok(product).build();
    }
}
