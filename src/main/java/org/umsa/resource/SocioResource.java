package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.logging.Logger;
import org.umsa.bo.SocioBO;

@Path("/socios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SocioResource {
    private static final Logger logger = Logger.getLogger(SocioResource.class);

    @Inject
    SocioBO socioBO;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "obtiene todos los socios", description="retorna todos los socios registrados")
    public Response getSocios(@QueryParam("idUsuario") Long idUsuario,@QueryParam("rol")String rol) {
        try {
            return Response
                    .ok(socioBO.getSocios(idUsuario,rol))
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener socios", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener socios")
                    .build();
        }
    }


}
