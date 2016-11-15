package bg.elsys.ip.rest.resources;

import bg.elsys.ip.rest.data.DatabaseMock;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(DatabaseMock.getInstance().getProducts()).build();
	}
}
