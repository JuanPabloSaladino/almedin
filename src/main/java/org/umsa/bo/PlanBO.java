package org.umsa.bo;

import java.util.List;

import org.umsa.model.Plan;
import org.umsa.model.Profesional;

public interface PlanBO {
	
	
	public List<Plan> getPlanes();

	public List<Profesional>getProfesionales(Long id);
	
	
}
