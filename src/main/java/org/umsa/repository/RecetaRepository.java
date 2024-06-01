package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Receta;

@ApplicationScoped
public class RecetaRepository implements PanacheRepository<Receta> {
}
