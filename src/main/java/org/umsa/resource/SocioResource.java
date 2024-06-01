package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.umsa.model.Socio;
import org.umsa.repository.SocioRepository;

import java.util.List;

@Path("/socios")
public class SocioResource {
    @Inject
    SocioRepository socioRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Socio> getSocios() {
        return socioRepository.listAll();
    }
}
