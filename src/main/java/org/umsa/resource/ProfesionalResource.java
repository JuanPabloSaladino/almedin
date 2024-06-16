package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.logging.Logger;
import org.umsa.bo.ProfesionalBO;

@Path("/especialistas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfesionalResource {
    private static final Logger logger = Logger.getLogger(ProfesionalResource.class);

    @Inject
    ProfesionalBO profesionalBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "obtiene todos los profesionales Disponibles", description="retorna todos los profesionales que tengan almenos un turno disponible, RETORNA UN List<DTOProfesional>")
    @APIResponses(value ={
            @APIResponse(responseCode = "200", description = "Solicitud exitosa"),
            @APIResponse(responseCode = "500",description = "Error interno del servidor")
    })
    public Response getProfesionales() {
        try {
            return Response
                    .ok(profesionalBO.getProfesionales())
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener profesionales", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener profesionales")
                    .build();
        }
    }
}

   /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfesionalById(@PathParam("id") Long idUsuario) {
        try {
            return Response
                    .ok("PROBANDINGGGGGG")
                    .build();
        } catch (Exception e) {
            logger.error

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener profesionales")
                    .build();
        }
    }*/



