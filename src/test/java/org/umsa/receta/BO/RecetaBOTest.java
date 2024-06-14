package org.umsa.receta.BO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.umsa.bo.impl.RecetaBOImpl;
import org.umsa.dao.RecetaDAO;
import org.umsa.dto.RecetaDTO;
import org.umsa.model.Profesional;
import org.umsa.model.Receta;
import org.umsa.model.Socio;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecetaBOTest {

    @InjectMocks
    private RecetaBOImpl recetaBO;

    @Mock
    private RecetaDAO recetaDAO;

    private Receta receta;

    @BeforeEach
    public void setup() {
        Profesional profesional = new Profesional();
        profesional.setNombre("Gómez Bolaños");
        profesional.setMatricula("12345");
        profesional.setApellido("Roberto");

        Socio socio = new Socio();
        socio.setNombre("Ramón");
        socio.setApellido("Valdez");

        receta = new Receta();
        receta.setContenido("Tomar cada 12 horas");
        receta.setProfesional(profesional);
        receta.setSocio(socio);
    }

    @Test
    public void testGetRecetas() {
        when(recetaDAO.getRecetas()).thenReturn(Collections.singletonList(receta));

        List<Receta> recetas = recetaBO.getRecetas();

        assertNotNull(recetas);
        assertEquals(1, recetas.size());
        assertEquals(receta, recetas.get(0));

        verify(recetaDAO, times(1)).getRecetas();
    }

    @Test
    public void testDescargarReceta() {
        when(recetaDAO.descargarReceta(1L, 1L)).thenReturn(receta);

        RecetaDTO recetaDTO = recetaBO.descargarReceta(1L, 1L);

        assertNotNull(recetaDTO);
        assertEquals("Tomar cada 12 horas", recetaDTO.getContenido());
        assertEquals("Gómez Bolaños Roberto", recetaDTO.getNombreProfesional());
        assertEquals("Ramón Valdez", recetaDTO.getNombreSocio());
        assertEquals("12345", recetaDTO.getNroMatriculaProfesional());

        verify(recetaDAO, times(1)).descargarReceta(1L, 1L);
    }
}