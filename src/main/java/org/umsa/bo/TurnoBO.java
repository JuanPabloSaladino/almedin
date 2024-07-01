package org.umsa.bo;

import jakarta.persistence.PersistenceException;
import org.umsa.dto.GetTurnoDTO;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Turno;

import java.util.List;

public interface TurnoBO {
    public List<GetTurnoDTO> getTurnos();

    public TurnoDTO getTurnoByID(Long ID);

    public Long crearTurno(TurnoDTO turnoDTO) throws Exception;

    public void eliminarTurno(Long turnoID) throws Exception;

    public void actualizarTurno(Long turnoID, TurnoDTO turnoDTO) throws Exception;

    public List<GetTurnoDTO> getTurnosPorUsuario(Long idUsuario, String rol);
}
