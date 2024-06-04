package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.model.Profesional;
import org.umsa.repository.ProfesionalRepository;

import java.util.List;

@ApplicationScoped
public class ProfesionalDAOImpl implements ProfesionalDAO {
    @Inject
    ProfesionalRepository profesionalRepository;

    @Override
    public List<Profesional> getProfesionales() {
        return profesionalRepository.listAll();
    }
}
