package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.umsa.bo.TurnoBO;
import org.umsa.dto.TurnoDTO;

import java.util.UUID;

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

    @DELETE
    @Transactional
    @Path("/{turnoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarTurno(@PathParam("turnoId") Long turnoId) {
        try {
            turnoBO.eliminarTurno(turnoId);

            return Response
                    .ok("El turno con ID " + turnoId + " se eliminó exitosamente")
                    .build();
        } catch (Exception e) {
            String mensaje = "Error al eliminar turno";

            logger.error(mensaje, e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(mensaje)
                    .build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarTurno(@PathParam("id") Long id, TurnoDTO turnoDTO) {
        try {
            turnoBO.actualizarTurno(id, turnoDTO);

            return Response
                    .ok("El turno con ID " + id + " se actualizó exitosamente")
                    .build();
        } catch (Exception e) {
            String mensaje = "Error al actualizar turno";

            logger.error(mensaje, e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(mensaje)
                    .build();
        }
    }
}
