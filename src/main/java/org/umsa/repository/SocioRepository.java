package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Socio;

@ApplicationScoped
public class SocioRepository implements PanacheRepository<Socio> {
}
