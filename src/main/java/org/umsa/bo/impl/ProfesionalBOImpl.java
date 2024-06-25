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
	public ProfesionalDTO getProfesionalDTOById(Long id) {
		return profesionalDAO.getProfesionalDTOById(id);
	}

	@Override
	public List<ProfesionalDTO> getProfesionales() {
		List <Profesional>profesionales=profesionalDAO.getProfesionales();
		List <ProfesionalDTO> profesionalesDTO= new ArrayList<>();

		for(Profesional profesional:profesionales){

			if(estaLibre(profesional.id)){

			ProfesionalDTO nuevoDTO = new ProfesionalDTO();
			nuevoDTO.setId(profesional.id);
			nuevoDTO.setNombreMedico(profesional.getNombre()+" "+profesional.getApellido());
			nuevoDTO.setEspecialidad(profesional.getEspecialidad());
			nuevoDTO.setUbicacion(profesional.getUbicacion());
			nuevoDTO.setHorarios(profesionalDAO.getTurnosDisponibles(profesional.id));

			profesionalesDTO.add(nuevoDTO);
			}
		}

		return profesionalesDTO;
	}

	@Override
	public boolean estaLibre(Long id) {
		return profesionalDAO.estaLibre(id);
	}


}
