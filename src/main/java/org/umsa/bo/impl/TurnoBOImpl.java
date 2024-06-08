package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import org.jboss.logging.Logger;
import org.umsa.bo.TurnoBO;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.dao.SocioDAO;
import org.umsa.dao.TurnoDAO;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Profesional;
import org.umsa.model.Socio;
import org.umsa.model.Turno;

import java.util.List;

@ApplicationScoped
public class TurnoBOImpl implements TurnoBO {
    private static final Logger logger = Logger.getLogger(TurnoBOImpl.class);

    @Inject
    TurnoDAO turnoDAO;

    @Inject
    SocioDAO socioDAO;

    @Inject
    ProfesionalDAO profesionalDAO;

    @Override
    public List<Turno> getTurnos() {
        return turnoDAO.getTurnos();
    }

    @Override
    public Long crearTurno(TurnoDTO turnoDTO) throws Exception {
        try {
            Turno turno = new Turno();

            Socio socio = socioDAO.getSocioById(turnoDTO.getSocioID());

            if (socio != null) {
                turno.setSocio(socio);
            } else {
                throw new Exception("Socio no encontrado");
            }

            Profesional profesional = profesionalDAO.getProfesionalById(turnoDTO.getProfesionalID());

            if (profesional != null) {
                turno.setProfesional(profesional);
            } else {
                throw new Exception("Profesional no encontrado");
            }

            turno.setFecha(turnoDTO.getFechaTurno());

            turno.setMotivoDeConsulta(turnoDTO.getMotivoDeConsultaTurno());

            Long turnoID = turnoDAO.crearTurno(turno);

            return turnoID;
        } catch (PersistenceException e) {
            String mensaje = "Error al crear turno";

            logger.error(mensaje, e);

            throw new Exception(mensaje);
        }
    }

    @Override
    public void eliminarTurno(Long turnoID) throws Exception {
        try {
            turnoDAO.eliminarTurno(turnoID);
        } catch (PersistenceException e) {
            String mensaje = "Error al eliminar turno";

            logger.error(mensaje, e);

            throw new Exception(mensaje);
        }
    }
}
