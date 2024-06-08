package org.umsa.repository;

import java.util.Collections;
import java.util.List;

import org.umsa.model.Plan;
import org.umsa.model.Profesional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlanRepository implements PanacheRepository<Plan> {

	
	public List<Profesional> getProfesionales(Long id) {

		// firstResult en este contexto : es para obtener el primer plan que coincida con la consulta
		Plan plan = find("FROM Plan p LEFT JOIN FETCH p.profesional WHERE p.id = ?1", id).firstResult();
		return (plan != null) ? plan.getProfesional() : Collections.emptyList();

	}

}
