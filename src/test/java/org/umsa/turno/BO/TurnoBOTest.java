package org.umsa.turno.BO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.umsa.bo.impl.TurnoBOImpl;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.dao.SocioDAO;
import org.umsa.dao.TurnoDAO;
import org.umsa.dto.GetTurnoDTO;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Profesional;
import org.umsa.model.Socio;
import org.umsa.model.Turno;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TurnoBOTest {
    @InjectMocks
    private TurnoBOImpl turnoBO;

    @Mock
    private TurnoDAO turnoDAO;

    @Mock
    private SocioDAO socioDAO;

    @Mock
    private ProfesionalDAO profesionalDAO;

    private TurnoDTO turnoDTO;
    private Turno turno;
    private Socio socio;
    private Profesional profesional;

    @BeforeEach
    public void setup() {
        turnoDTO = new TurnoDTO();
        turnoDTO.setSocioID(1L);
        turnoDTO.setProfesionalID(1L);
        turnoDTO.setFechaTurno(LocalDateTime.now());
        turnoDTO.setMotivoDeConsultaTurno("Consulta de prueba");

        socio = new Socio();
        socio.id = 1L;

        profesional = new Profesional();
        profesional.id = 1L;

        turno = new Turno();
        turno.id = 1L;
        turno.setSocio(socio);
        turno.setProfesional(profesional);
        turno.setFechaInicio(turnoDTO.getFechaTurno());
        turno.setMotivoDeConsulta(turnoDTO.getMotivoDeConsultaTurno());
        turno.setOcupado(true);
    }

    @Test
    public void testGetTurnos() {
        when(turnoDAO.getTurnos()).thenReturn(Collections.singletonList(turno));

        List<GetTurnoDTO> turnos = turnoBO.getTurnos();

        assertNotNull(turnos);
    }

    @Test
    public void testCrearTurno() throws Exception {
        when(socioDAO.getSocioById(1L)).thenReturn(socio);
        when(profesionalDAO.getProfesionalById(1L)).thenReturn(profesional);
        when(turnoDAO.crearTurno(any(Turno.class))).thenReturn(1L);

        Long turnoID = turnoBO.crearTurno(turnoDTO);

        assertNotNull(turnoID);
        assertEquals(1L, turnoID);

        verify(socioDAO, times(1)).getSocioById(1L);
        verify(profesionalDAO, times(1)).getProfesionalById(1L);
        verify(turnoDAO, times(1)).crearTurno(any(Turno.class));
    }

    @Test
    public void testCrearTurnoSocioNoEncontrado() {
        when(socioDAO.getSocioById(1L)).thenReturn(null);

        Exception exception = assertThrows(Exception.class, () -> {
            turnoBO.crearTurno(turnoDTO);
        });

        assertEquals("Socio no encontrado", exception.getMessage());
        verify(socioDAO, times(1)).getSocioById(1L);
        verify(profesionalDAO, never()).getProfesionalById(anyLong());
        verify(turnoDAO, never()).crearTurno(any(Turno.class));
    }

    @Test
    public void testEliminarTurno() throws Exception {
        doNothing().when(turnoDAO).eliminarTurno(1L);

        turnoBO.eliminarTurno(1L);

        verify(turnoDAO, times(1)).eliminarTurno(1L);
    }

    @Test
    public void testActualizarTurno() throws Exception {
        when(socioDAO.getSocioById(1L)).thenReturn(socio);
        when(profesionalDAO.getProfesionalById(1L)).thenReturn(profesional);
        doNothing().when(turnoDAO).actualizarTurno(anyLong(), any(Turno.class));

        turnoBO.actualizarTurno(1L, turnoDTO);

        verify(socioDAO, times(1)).getSocioById(1L);
        verify(profesionalDAO, times(1)).getProfesionalById(1L);
        verify(turnoDAO, times(1)).actualizarTurno(anyLong(), any(Turno.class));
    }
}
