package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.ProfesionalBO;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.dto.ProfesionalDTO;
import org.umsa.model.Profesional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProfesionalBOImpl implements ProfesionalBO {
	//CAPA SERVICE
	
    @Inject
    ProfesionalDAO profesionalDAO;

 

	@Override
	public Profesional getProfesionalById(Long id) {

		return profesionalDAO.getProfesionalById(id);
	}



	@Override
	public List<ProfesionalDTO> getProfesionales() {
		List <Profesional>profesionales=profesionalDAO.getProfesionales();
		List <ProfesionalDTO> profesionalesDTO= new ArrayList<ProfesionalDTO>();

		for(Profesional profesional:profesionales){
			ProfesionalDTO nuevoDTO = new ProfesionalDTO();
			nuevoDTO.setNombreMedico(profesional.getNombre());
			nuevoDTO.setEspecialidad(profesional.getEspecialidad());
			nuevoDTO.setUbicacion(profesional.getUbicacion());
			nuevoDTO.setHorarios(profesionalDAO.getTurnosDisponibles(profesional.id));

			profesionalesDTO.add(nuevoDTO);
		}

		return profesionalesDTO;
	}

	@Override
	public boolean estaLibre(Long id) {
		/*profesionalDAO.estaLibre(id)*/
		return false;
	}


}
