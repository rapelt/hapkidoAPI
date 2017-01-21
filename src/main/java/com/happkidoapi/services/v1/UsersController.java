package com.happkidoapi.services.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import java.util.List;


@Path("/users")
@Api(value = "/users", description = "Manage Users" )

public class UsersController {

	private static final Logger log = Logger.getLogger(UsersController.class.getName());

	@GET
	@Path("/xx")
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get All Users", notes = "This returns all the Users from the Hapkido DB")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success: { list of users }"),
			@ApiResponse(code = 400, message = "Failed: {\"error\":\"error description\", \"status\":\"FAIL\"}") 
			} )
	public Response getUserById() {

		System.out.print("-------------------------------------------- sdkfjlskfs;");

		log.info("UsersController::getUserById");
		
		try {
			List<User> user = UserRepository.getInstance().findAllUsers();
			
			return Response.status(Response.Status.OK).entity(user).build();
		}
		catch (Exception e) {
			log.error("UsersController::getUserById" + e.toString());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("{\"error\":\"Could Not Find User\", \"status\":\"FAIL\"}")
					.build();
		}
	}
}
