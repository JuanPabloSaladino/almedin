package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import org.jboss.logging.Logger;
import org.umsa.dao.TurnoDAO;
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
        logger.info("Se actualiza el turno con ID: " + turnoID);
        Turno turnoEncontrado = turnoRepository.findById(turnoID);

        if (turnoEncontrado != null) {
            turnoRepository.persist(turno);
        } else {
            throw new PersistenceException("El turno no existe");
        }
    }
}
