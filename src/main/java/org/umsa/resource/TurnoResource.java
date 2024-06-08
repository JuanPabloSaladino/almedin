package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.umsa.bo.TurnoBO;
import org.umsa.dto.TurnoDTO;

@Path("/turnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TurnoResource {
    private static final Logger logger = Logger.getLogger(TurnoResource.class);

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

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearTurno(TurnoDTO turnoDTO) {
        try {
            Long turnoID = turnoBO.crearTurno(turnoDTO);

            return Response
                    .ok(turnoID)
                    .build();
        } catch (Exception e) {
            String mensaje = "Error al crear turno";

            logger.error(mensaje, e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(mensaje)
                    .build();
        }
    }
}
