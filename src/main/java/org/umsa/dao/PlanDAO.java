package org.umsa.dao;

import java.util.List;

import org.umsa.model.Plan;
import org.umsa.model.Profesional;

public interface PlanDAO {

	public List<Plan> getPlanes ();
	
	public List<Profesional> getProfesionales(Long id);
	
}
