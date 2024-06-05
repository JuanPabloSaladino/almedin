package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.umsa.bo.TurnoBO;

@Path("/turnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TurnoResource {
    private static final Logger logger = LogManager.getLogger(ProfesionalResource.class);

    @Inject
    TurnoBO turnoBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTurnos() {
        try {
            return Response
                    .ok(turnoBO.getTurnos())
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener turnos", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener turnos")
                    .build();
        }
    }
}
