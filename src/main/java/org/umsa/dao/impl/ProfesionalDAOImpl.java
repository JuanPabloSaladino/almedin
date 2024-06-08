package org.umsa.dao.impl;

import java.util.List;

import org.umsa.dao.ProfesionalDAO;
import org.umsa.model.Profesional;
import org.umsa.repository.ProfesionalRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesionalDAOImpl implements ProfesionalDAO {
    @Inject
    ProfesionalRepository profesionalRepository;

    @Override
    public List<Profesional> getProfesionales() {
        return profesionalRepository.listAll();
    }

	@Override
	public Profesional getProfesionalById(Long id) {
		// TODO Auto-generated method stub
		return profesionalRepository.getProfesionalById(id);
	}
}
