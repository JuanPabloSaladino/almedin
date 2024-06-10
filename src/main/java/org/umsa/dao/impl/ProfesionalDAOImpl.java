package org.umsa.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.umsa.dao.ProfesionalDAO;
import org.umsa.model.Profesional;
import org.umsa.model.Turno;
import org.umsa.repository.ProfesionalRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesionalDAOImpl implements ProfesionalDAO {
    @Inject
    ProfesionalRepository profesionalRepository;

    public List <LocalDateTime> getTurnosDisponibles(Long id){
        List <Turno> turnosDisponibles = profesionalRepository.obtenerTurnosDisponibles(id);
        List <LocalDateTime> horariosDisponibles = new ArrayList<>() ;

        for(Turno turno: turnosDisponibles){
            horariosDisponibles.add(turno.getFechaCreacion());
        }

        return horariosDisponibles;}

    @Override
    public boolean estaLibre(Long id) {
       return profesionalRepository.estaLibre(id);
    }

    @Override
    public List<Profesional> getProfesionales() {
        return profesionalRepository.listAll();
    }

	@Override
	public Profesional getProfesionalById(Long id) {
		return profesionalRepository.getProfesionalById(id);
	}
}
