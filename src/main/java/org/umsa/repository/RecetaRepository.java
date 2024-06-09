package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Receta;

@ApplicationScoped
public class RecetaRepository implements PanacheRepository<Receta> {

    public Receta descargarReceta(Long idTurno,Long idUsuario){
        String query = "SELECT t.receta FROM Turno t WHERE t.id = :idTurno AND t.socio.id = :idUsuario";
        try {
            return getEntityManager().createQuery(query, Receta.class)
                    .setParameter("idTurno", idTurno)
                    .setParameter("idUsuario", idUsuario)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // hice esto pq viendo la docu parece que jqpl devuelve un error y no Null como esperaba
        }
    }

}
