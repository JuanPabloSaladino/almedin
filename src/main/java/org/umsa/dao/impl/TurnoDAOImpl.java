package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.dao.TurnoDAO;
import org.umsa.model.Turno;
import org.umsa.repository.TurnoRepository;

import java.util.List;

@ApplicationScoped
public class TurnoDAOImpl implements TurnoDAO {
    @Inject
    TurnoRepository turnoRepository;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.listAll();
    }
}
