package bg.elsys.ip.rest.resources;

import bg.elsys.ip.rest.data.DatabaseMock;
import bg.elsys.ip.rest.models.Product;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(
                        @QueryParam("page") int page,
                        @QueryParam("perPage") int perPage,
                        @QueryParam("prodName") String prodName,
                        @QueryParam("minQuantity") Integer minQuantity,
                        @QueryParam("maxPrice") Float maxPrice,
                        @QueryParam("providerName") String providerName,
                        @QueryParam("depName") String department,
                        @QueryParam("withBarCode") String barcode) {
        ProductFilter filter = new ProductFilter(page, perPage, prodName,minQuantity,maxPrice,providerName,department,barcode);
		return Response.ok(filter.filterProducts(DatabaseMock.getInstance().getProducts())).build();
	}

	@Path("/auto")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutoCompleteLists() {
        return Response.ok(DatabaseMock.getInstance().generateAutoCompleter()).build();
    }

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        DatabaseMock.getInstance().addProduct(product);
        return Response.ok(product).build();
    }
}
