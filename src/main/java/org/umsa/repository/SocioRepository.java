package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Socio;

import java.util.List;

@ApplicationScoped
public class SocioRepository implements PanacheRepository<Socio> {

    public List<Socio> buscarSocios() {
        String query = "SELECT s FROM Socio s WHERE s.rol = :rol";

            return getEntityManager().createQuery(query, Socio.class)
                    .setParameter("rol", "USUARIO")
                    .getResultList();

    }


}
