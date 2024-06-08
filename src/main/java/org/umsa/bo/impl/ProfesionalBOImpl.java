package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.ProfesionalBO;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.model.Profesional;

import java.util.List;

@ApplicationScoped
public class ProfesionalBOImpl implements ProfesionalBO {
	//CAPA SERVICE
	
    @Inject
    ProfesionalDAO profesionalDAO;

 

	@Override
	public Profesional getProfesionalById(Long id) {
		// TODO Auto-generated method stub
		return profesionalDAO.getProfesionalById(id);
	}



	@Override
	public List<Profesional> getProfesionales() {
		// TODO Auto-generated method stub
		return profesionalDAO.getProfesionales();
	}
	
	
}
