package org.umsa.profesional.BO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.umsa.bo.impl.ProfesionalBOImpl;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.dto.ProfesionalDTO;
import org.umsa.model.Profesional;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfesionalBOTest {

    @InjectMocks
    private ProfesionalBOImpl profesionalBO;

    @Mock
    private ProfesionalDAO profesionalDAO;

    private Profesional profesional;

    @BeforeEach
    public void setup() {
        profesional = new Profesional();
        profesional.id = 1L;
        profesional.setNombre("Mariano");
        profesional.setApellido("Marthonez");
        profesional.setEspecialidad("Cirujano Plástico");
        profesional.setUbicacion("Hospital Italiano de Saturno");
    }

    @Test
    public void testGetProfesionales() {
        when(profesionalDAO.getProfesionales()).thenReturn(Collections.singletonList(profesional));
        when(profesionalDAO.estaLibre(1L)).thenReturn(true);
        when(profesionalDAO.getTurnosDisponibles(1L)).thenReturn(Collections.emptyList());

        List<ProfesionalDTO> profesionalesDTO = profesionalBO.getProfesionales();

        assertNotNull(profesionalesDTO);
        assertEquals(1, profesionalesDTO.size());
        ProfesionalDTO dto = profesionalesDTO.get(0);
        assertEquals("Mariano Marthonez", dto.getNombreMedico());
        assertEquals("Cirujano Plástico", dto.getEspecialidad());
        assertEquals("Hospital Italiano de Saturno", dto.getUbicacion());
        assertTrue(dto.getHorarios().isEmpty());

        verify(profesionalDAO, times(1)).getProfesionales();
        verify(profesionalDAO, times(1)).estaLibre(1L);
        verify(profesionalDAO, times(1)).getTurnosDisponibles(1L);
    }

    @Test
    public void testEstaLibre() {
        when(profesionalDAO.estaLibre(1L)).thenReturn(true);

        boolean result = profesionalBO.estaLibre(1L);

        assertTrue(result);

        verify(profesionalDAO, times(1)).estaLibre(1L);
    }
}