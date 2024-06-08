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
		String query = "SELECT t FROM Turno t WHERE t.id=id AND t.ocupado = false AND t.cancelado = false";
		return getEntityManager().createQuery(query, Turno.class).getResultList();
	}

	public Profesional getProfesionalById(Long id) {
		
		return Profesional.findById(id);
		
	}
	
}
