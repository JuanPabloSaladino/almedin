package org.umsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Profesional;

@ApplicationScoped
public class ProfesionalRepository implements PanacheRepository<Profesional> {


	public Profesional getProfesionalById(Long id) {
		
		return Profesional.findById(id);
		
	}
	
}
