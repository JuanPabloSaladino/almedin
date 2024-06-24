package org.umsa.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
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

    @GET
    @Path("/{turnoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTurnoByID(@PathParam("turnoId") Long turnoId) {
        try {
            return Response
                    .ok(turnoBO.getTurnoByID(turnoId))
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener turno", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener turno")
                    .build();
        }
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Crea un nuevo Turno ", description="esta operacion recibe la informacion Necesaria de un Turno y crea un nuevo Turno medico")
    @ApiOperation(value="crea y guarda un nuevo turno", notes="recibe tanto SocioID, fechaTurno, ProfesionalID y un motivoDeConsulta por parametro y en base a eso crea y agenda un NUEVO turno")
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
    @Operation(summary = "Elimina un turno medico por ID ", description="recibe el id de un Turno y lo elimina en caso de existir ese turno")
    public Response eliminarTurno(@ApiParam(value ="identificador del turno",name ="turnoId",example = "5",required = true) @PathParam("turnoId") Long turnoId) {
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
    @Operation(summary = "Actualiza un Turno por ID ", description=" actualiza el turno recibido por parametro con los cambios obtenidos por parametro")

    public Response actualizarTurno(@ApiParam (value ="id del turno", name= "turnoId",example = "2", required = true)@PathParam("id") Long id, TurnoDTO turnoDTO) {
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
