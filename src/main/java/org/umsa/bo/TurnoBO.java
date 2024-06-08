package org.umsa.bo;

import jakarta.persistence.PersistenceException;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Turno;

import java.util.List;

public interface TurnoBO {
    public List<Turno> getTurnos();

    public Long crearTurno(TurnoDTO turnoDTO) throws Exception;

    public void eliminarTurno(Long turnoID) throws Exception;
}
