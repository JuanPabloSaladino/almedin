package org.umsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.umsa.model.Turno;
import org.umsa.repository.TurnoRepository;

import java.util.List;

@Path("/turnos")
public class TurnoResource {
    @Inject
    TurnoRepository turnoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Turno> getTurnos() {
        return turnoRepository.listAll();
    }
}
