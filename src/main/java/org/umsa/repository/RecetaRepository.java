package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import org.umsa.bo.impl.TurnoBOImpl;
import org.umsa.model.Receta;

@ApplicationScoped
public class RecetaRepository implements PanacheRepository<Receta> {

    //private static final Logger logger = Logger.getLogger(RecetaRepository.class);

    public Receta descargarReceta(Long idTurno,Long idUsuario){

        String query = "SELECT t.receta FROM Turno t WHERE t.id = :idTurno AND t.socio.id = :idUsuario";
        try {

            //logger.info("Ejecutando consulta: " + query + " con idTurno: " + idTurno + " y idUsuario: " + idUsuario);
            Receta receta= getEntityManager().createQuery(query, Receta.class)
                    .setParameter("idTurno", idTurno)
                    .setParameter("idUsuario", idUsuario)
                    .getSingleResult();
            //logger.info("Receta encontrada: " + receta);

            return receta;
        } catch (Exception e) {
           // logger.error("Error ejecutando consulta: ", e);
            return null;
        }
    }

}
