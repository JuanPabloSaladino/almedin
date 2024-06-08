package org.umsa.bo.impl;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.bo.PlanBO;
import org.umsa.dao.PlanDAO;
import org.umsa.model.Plan;
import org.umsa.model.Profesional;

import jakarta.inject.Inject;

@ApplicationScoped
public class PlanBOImpl implements PlanBO{

	 @Inject
	 PlanDAO planDAO;
	
	public List<Plan> getPlanes(){
		return planDAO.getPlanes();
	}
	
	@Override
	public List<Profesional> getProfesionales(Long id) {
		// TODO Auto-generated method stub
		return planDAO.getProfesionales(id);
	}

}
