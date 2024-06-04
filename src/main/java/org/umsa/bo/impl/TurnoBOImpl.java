package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.TurnoBO;
import org.umsa.dao.TurnoDAO;
import org.umsa.model.Turno;

import java.util.List;

@ApplicationScoped
public class TurnoBOImpl implements TurnoBO {
    @Inject
    TurnoDAO turnoDAO;

    @Override
    public List<Turno> getTurnos() {
        return turnoDAO.getTurnos();
    }
}
