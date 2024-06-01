package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.umsa.model.Profesional;
import org.umsa.repository.ProfesionalRepository;

import java.util.List;

@Path("/profesionales")
public class ProfesionalResource {
    @Inject
    ProfesionalRepository profesionalRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profesional> getProfesionales() {
        return profesionalRepository.listAll();
    }
}
