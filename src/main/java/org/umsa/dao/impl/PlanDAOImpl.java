package org.umsa.dao.impl;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.dao.PlanDAO;
import org.umsa.model.Plan;
import org.umsa.model.Profesional;
import org.umsa.repository.PlanRepository;

import jakarta.inject.Inject;

@ApplicationScoped
public class PlanDAOImpl implements PlanDAO{
	
	@Inject
	PlanRepository planRepository;

	@Override
	public List<Plan> getPlanes() {
		return planRepository.listAll();
	}
	
	public List<Profesional> getProfesionales(Long id) {
		return planRepository.getProfesionales(id);
	}


	


	

}
