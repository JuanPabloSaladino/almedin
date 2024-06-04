package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.umsa.bo.TurnoBO;

@Path("/turnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TurnoResource {
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
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener turnos")
                    .build();
        }
    }
}
