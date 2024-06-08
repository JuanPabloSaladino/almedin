package org.umsa.bo;

import org.umsa.model.Profesional;

import java.util.List;

public interface ProfesionalBO {
	
	
	public Profesional getProfesionalById(Long id);
	
	public List<Profesional> getProfesionales();
    
}
