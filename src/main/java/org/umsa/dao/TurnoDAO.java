package org.umsa.dao;

import jakarta.persistence.PersistenceException;
import org.umsa.model.Turno;

import java.util.List;

public interface TurnoDAO {
    public List<Turno> getTurnos();

    public Long crearTurno(Turno turno) throws PersistenceException;

    public void eliminarTurno(Long turnoID) throws PersistenceException;
}
