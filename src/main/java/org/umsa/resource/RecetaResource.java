package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    @Path ("/descargar/{idTurno}/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response descargarReceta(@PathParam("idTurno") Long idTurno, @PathParam("idUsuario") Long idUsuario) {
       try {

           RecetaDTO receta = recetaBO.descargarReceta(idTurno,idUsuario);

           return Response
                   .ok(receta)
                   .build();

       }catch (Exception e){
           logger.error("error al descargar receta : ",e);

           return Response
                   .status(Response.Status.INTERNAL_SERVER_ERROR)
                   .entity("error al descargar receta : "+ e.getMessage())
                   .build();

       }

    }





}
