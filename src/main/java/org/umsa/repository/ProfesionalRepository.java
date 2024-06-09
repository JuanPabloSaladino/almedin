package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Profesional;
import org.umsa.model.Turno;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ProfesionalRepository implements PanacheRepository<Profesional> {


	public List<Turno> obtenerTurnosDisponibles(long id) {
		String query = "SELECT t FROM Turno t WHERE t.profesional.id = :id AND t.ocupado = false AND t.cancelado = false";
		return getEntityManager().createQuery(query, Turno.class)
				.setParameter("id", id)
				.getResultList();

	}

	/*String query = "SELECT t FROM Turno t WHERE t.id=id AND t.ocupado = false AND t.cancelado = false";
		return getEntityManager().createQuery(query, Turno.class).getResultList();*/
	/*String query = "SELECT t.fechaInicio FROM Turno t WHERE t.profesional.id = ?1 AND t.ocupado = false AND t.cancelado = false";
		return list(query,id);*/

	public Profesional getProfesionalById(Long id) {
		
		return Profesional.findById(id);
		
	}

	public boolean estaLibre(Long id){
		String query = "SELECT t FROM Turno t WHERE t.profesional.id = :id AND t.ocupado = false AND t.cancelado = false";
		return !getEntityManager().createQuery(query, Turno.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList().isEmpty();
	}

	/*String query = "SELECT t FROM Turno t WHERE t.profesional.id = ?1 AND t.ocupado = false AND t.cancelado = false";
		return find(query, id).firstResult() != null;*/
	
}
