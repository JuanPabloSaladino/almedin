package org.umsa.dao;

import jakarta.persistence.PersistenceException;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Turno;

import java.util.List;

public interface TurnoDAO {
    public List<Turno> getTurnos();

    public TurnoDTO getTurnoByID(Long ID);

    public Long crearTurno(Turno turno) throws PersistenceException;

    public void eliminarTurno(Long turnoID) throws PersistenceException;

    public void actualizarTurno(Long turnoID, Turno turno) throws PersistenceException;

    public List<Turno>getTurnosPorUsuario(Long idUsuario);
}
