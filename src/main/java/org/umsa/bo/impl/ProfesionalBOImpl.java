package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.ProfesionalBO;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.model.Profesional;

import java.util.List;

@ApplicationScoped
public class ProfesionalBOImpl implements ProfesionalBO {
    @Inject
    ProfesionalDAO profesionalDAO;

    @Override
    public List<Profesional> getProfesionales() {
        return profesionalDAO.getProfesionales();
    }
}
