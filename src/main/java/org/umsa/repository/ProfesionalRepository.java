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

	public Profesional getProfesionalById(Long id) {
		
		return Profesional.findById(id);
		
	}

	// esto va a verificar si el medico esta libre, como? : esto busca en la lista de turnos del medico y
	// si algun turno llegar a tener "ocupado=false" significa que ese turno esta libre, por ende el medico esta disponible y devuelve TRUE
	public boolean estaLibre(Long id){
		String query = "SELECT t FROM Turno t WHERE t.profesional.id = :id AND t.ocupado = false AND t.cancelado = false";
		return !getEntityManager().createQuery(query, Turno.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList().isEmpty();
	}

	
}
