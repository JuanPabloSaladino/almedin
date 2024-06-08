package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.umsa.bo.PlanBO;

@Path("/plan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PlanResource {
    private static final Logger logger = Logger.getLogger(PlanResource.class);

    @Inject
    PlanBO planBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanes() {
        try {
            return Response
                    .ok(planBO.getPlanes())
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener los planes", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener planes")
                    .build()
                    ;
        }
    }

    // 2 endpoint revisar, modificar el dato que devuelve el repoPlan
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfesionales(@PathParam("especialistas") Long id) {
        try {
            return Response
                    .ok(planBO.getProfesionales(id))
                    .build();
        } catch (Exception e) {
            logger.error("Error al obtener los especialistas ", e);

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener los especialistas")
                    .build();
        }
    }

}
