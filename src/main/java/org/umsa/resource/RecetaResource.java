package org.umsa.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.logging.Logger;
import org.umsa.bo.RecetaBO;
import org.umsa.dto.RecetaDTO;

import org.umsa.model.Receta;

@Path("/recetas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecetaResource {
    private static final Logger logger = Logger.getLogger(RecetaResource.class);

    @Inject
    RecetaBO recetaBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecetas() {
        try {
            return Response
                    .ok(recetaBO.getRecetas())
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener recetas", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener recetas")
                    .build();
        }
    }


    @GET
    @Path("/descargar/{idTurno}/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "busca una receta medica por TurnoID y por SocioID ", description="esta operacion devuelve la informacion de una receta del Socio solicitante")
    @APIResponses(value ={
            @APIResponse(responseCode = "200", description = "RecetaDTO"),
            @APIResponse(responseCode = "500",description = "Error interno del servidor, usuario no permitido o receta inexistente")
    })
    @ApiOperation(value="devuelve una receta", notes="le pasamos el ID de un turno (el cual tiene asociado una receta) y el id del Socio que solicita esa Receta. si el Socio(SocioID) tiene el Turno (TurnoID) se buscara la receta asociada a ese turno y se retornara. si no la tiene se devolvera un error")
    public Response descargarReceta(
            @ApiParam(value= "dato del turno", name = "turnoId",example ="2",required = true) @PathParam("idTurno") Long idTurno,
            @ApiParam(value = "Dato del usuario", name ="idSocio",example="3",required = true) @PathParam("idUsuario") Long idUsuario) {
        try {
            logger.info("Request received for descargarReceta");
            logger.info("idTurno: " + idTurno + ", idUsuario: " + idUsuario);

            RecetaDTO receta = recetaBO.descargarReceta(idTurno, idUsuario);
            logger.info("Receta found: " + receta);

            return Response
                    .ok(receta)
                    .build();

        } catch (Exception e) {
            logger.error("Error al descargar receta: ", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al descargar receta: " + e.getMessage())
                    .build();
        }
    }
}


