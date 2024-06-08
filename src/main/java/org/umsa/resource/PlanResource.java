package org.umsa.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.umsa.bo.PlanBO;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/plan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PlanResource {

    private static final Logger logger = LogManager.getLogger(PlanResource.class);

	
	@Inject
	PlanBO planBO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlanes() {
       try {
    	   return Response
    			   .ok(planBO.getPlanes())
    			   .build();
       }catch (Exception e) {
    	   logger.error("Error al obtener los planes",e); 
    	   
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
	public Response getProfesionales(@PathParam ("especialistas") Long id) {
		try {
			return Response
					.ok(planBO.getProfesionales(id))
					.build();
		}catch (Exception e) {
			logger.error("Error al obtener los especialistas ", e);
			
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Error al obtener los especialistas")
					.build();
		}
	}

}
