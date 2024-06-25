package org.umsa.bo;

import org.umsa.dto.ProfesionalDTO;
import org.umsa.model.Profesional;

import java.util.List;

public interface ProfesionalBO {
	
	
	public Profesional getProfesionalById(Long id);

	public ProfesionalDTO getProfesionalDTOById(Long id);

	public List<ProfesionalDTO> getProfesionales();

	public boolean estaLibre(Long id);
    
}
