package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import org.jboss.logging.Logger;
import org.umsa.dao.TurnoDAO;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Turno;
import org.umsa.repository.TurnoRepository;

import java.util.List;

@ApplicationScoped
public class TurnoDAOImpl implements TurnoDAO {
    private static final Logger logger = Logger.getLogger(TurnoDAOImpl.class);

    @Inject
    TurnoRepository turnoRepository;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.listAll();
    }

    @Override
    public TurnoDTO getTurnoByID(Long ID) {
        Turno turno = turnoRepository.findById(ID);

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setFechaTurno(turno.getFechaInicio());
        turnoDTO.setMotivoDeConsultaTurno(turno.getMotivoDeConsulta());
        turnoDTO.setId(turno.id);


        if(turno.getSocio() != null){
            turnoDTO.setSocioID(turno.getSocio().id);
        }

        if(turno.getProfesional() != null){
            turnoDTO.setProfesionalID(turno.getProfesional().id);
            turnoDTO.setNombreProfesional(turno.getProfesional().getApellido() + ", " + turno.getProfesional().getNombre());
        }

        return turnoDTO;
    }

    @Override
    public Long crearTurno(Turno turno) {
        try {
            turnoRepository.persist(turno);

            return turno.id;
        } catch (PersistenceException e) {
            String mensaje = "Error al persistir turno: " + turno;

            logger.error(mensaje, e);

            throw new PersistenceException(mensaje);
        }
    }

    @Override
    public void eliminarTurno(Long turnoID) throws PersistenceException {
        Turno turno = turnoRepository.findById(turnoID);

        if (turno == null) {
            throw new PersistenceException("El turno no existe");
        } else {
            turnoRepository.deleteById(turnoID);
        }
    }

    @Override
    public void actualizarTurno(Long turnoID, Turno turno) throws PersistenceException {
        Turno turnoEncontrado = turnoRepository.findById(turnoID);

        if (turnoEncontrado != null) {
            logger.info("Se actualiza el turno con ID: " + turnoID);

            turnoEncontrado.setFechaInicio(turno.getFechaInicio());
            turnoEncontrado.setProfesional(turno.getProfesional());
            turnoEncontrado.setSocio(turno.getSocio());
            turnoEncontrado.setMotivoDeConsulta(turno.getMotivoDeConsulta());
            turnoEncontrado.setOcupado(turno.isOcupado());

            turnoRepository.persist(turnoEncontrado);
        } else {
            throw new PersistenceException("El turno no existe");
        }
    }
}
