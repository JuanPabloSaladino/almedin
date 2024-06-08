package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Turno;

@ApplicationScoped
public class TurnoRepository implements PanacheRepository<Turno> {



}
