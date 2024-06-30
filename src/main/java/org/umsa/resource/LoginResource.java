package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.umsa.bo.LoginBO;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LoginResource {
    private static final Logger logger = Logger.getLogger(LoginResource.class);

    @Inject
    LoginBO loginBO;



    @GET
    @Transactional
    @Produces (MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("login") String email, @QueryParam("password") String password) {
        try {

            return Response
                    .ok(loginBO.login(email, password))
                    .build();

        }catch (Exception e) {
            //logger.error("Error al loguearse", e);
            String msg = "Error al querer logearse, algo ha ocurridooo";

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(msg)
                    .build();


        }


    }

}
