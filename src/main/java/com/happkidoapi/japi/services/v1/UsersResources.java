
package com.happkidoapi.japi.services.v1;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/users")
public class UsersResources {

    @GET
    @Path("/xx")
    @Produces(MediaType.TEXT_PLAIN)
    public String xx() {
        return "Welcome to XX";
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success: {user profile}"),
            @ApiResponse(code = 400, message = "Failed: {\"error\":\"error description\", \"status\":\"FAIL\"}")
    })
    public Response getUserByID(@PathParam("userId") String userID) {
        if(userID == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Empty userID\", \"status\":\"FAIL\"}")
                    .build();
        }

        User user = new User();
        user.setId("1");
        user.setName("Rebekah");

        return Response.status(Response.Status.OK)
                .entity(user)
                .build();
    }
}

