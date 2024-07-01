package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Turno;
import java.util.List;

@ApplicationScoped
public class TurnoRepository implements PanacheRepository<Turno> {

    public List<Turno> getTurnosPorUsuario(Long idUsuario){

        String query = "SELECT t FROM Turno t WHERE t.socio.id = :idUsuario";

        try {

            return getEntityManager().createQuery(query,Turno.class)
                    .setParameter("idUsuario",idUsuario)
                    .getResultList();

        }catch (Exception e){
           return null;
        }

    }


}
