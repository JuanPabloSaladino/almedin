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

import java.util.ArrayList;
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
    public List<TurnoDTO> getTurnos() {
        List<TurnoDTO> turnos = new ArrayList<>();

        for (Turno turno : turnoDAO.getTurnos()) {
            TurnoDTO turnoDTO = new TurnoDTO();

            turnoDTO.setID(turno.id);
            turnoDTO.setMotivoDeConsultaTurno(turno.getMotivoDeConsulta());
            turnoDTO.setProfesionalID(turno.getProfesional().id);
            turnoDTO.setFechaTurno(turno.getFechaInicio());

            if (turno.getSocio() != null) {
                turnoDTO.setSocioID(turno.getSocio().id);
            }

            turnos.add(turnoDTO);
        }

        return turnos;
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

            turno.setFechaInicio(turnoDTO.getFechaTurno());

            turno.setMotivoDeConsulta(turnoDTO.getMotivoDeConsultaTurno());

            turno.setOcupado(true);

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

    @Override
    public void actualizarTurno(Long turnoID, TurnoDTO turnoDTO) throws Exception {
        try {
            Turno turno = new Turno();

            Profesional profesional = profesionalDAO.getProfesionalById(turnoDTO.getProfesionalID());

            if (profesional == null) {
                throw new Exception("Profesional no encontrado");
            }

            Socio socio = socioDAO.getSocioById(turnoDTO.getSocioID());

            if (socio == null) {
                throw new Exception("Socio no encontrado");
            }

            turno.setFechaInicio(turnoDTO.getFechaTurno());
            turno.setProfesional(profesional);
            turno.setSocio(socio);
            turno.setMotivoDeConsulta(turnoDTO.getMotivoDeConsultaTurno());
            turno.setOcupado(true);

            turnoDAO.actualizarTurno(turnoID, turno);
        } catch (PersistenceException e) {
            String mensaje = "Error al actualizar turno";

            logger.error(mensaje, e);

            throw new Exception(mensaje);
        }
    }
}
