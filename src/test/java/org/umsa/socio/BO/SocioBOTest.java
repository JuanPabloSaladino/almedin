package org.umsa.socio.BO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.umsa.dao.SocioDAO;
import org.umsa.dao.TurnoDAO;
import org.umsa.dto.SocioDTO;
import org.umsa.model.Plan;
import org.umsa.model.Profesional;
import org.umsa.model.Turno;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocioBOTest {
    @Mock
    private SocioDAO socioDAO;

    @Mock
    private TurnoDAO turnoDAO;

    private SocioDTO socio1;
    private SocioDTO socio2;

    @BeforeEach
    public void setup() {
        Plan plan = new Plan();
        plan.setNombre("110");
        plan.setPrecio(1000);
        plan.setNombre("Plan 110");

        Profesional profesional = new Profesional();
        profesional.id = 1L;
        profesional.setNombre("Alferto");
        profesional.setApellido("Bernandez");
        profesional.setDocumento("22333444");
        profesional.setEmail("alfertobernandez@gmail.com");
        profesional.setEspecialidad("Gerontólogo");

        Turno turno1 = new Turno();
        turno1.id = 1L;
        turno1.setOcupado(true);
        turno1.setSocio(null);
        turno1.setProfesional(profesional);
        turno1.setHash("5e2b6b4a-a913-4d85-ac35-6524e7c0fa35");
        turno1.setCancelado(false);

        Turno turno2 = new Turno();
        turno2.id = 2L;
        turno2.setOcupado(true);
        turno2.setSocio(null);
        turno2.setProfesional(profesional);
        turno2.setHash("7f2b6b4a-a913-4d85-ac35-6524e7c0fa45");
        turno2.setCancelado(false);

        List<Turno> turnos = new ArrayList<>();
        turnos.add(turno1);
        turnos.add(turno2);

        socio1 = new SocioDTO();
        socio1.setEmail("macriciomauri@gmail.com");
        socio1.setNombre("Macricio" + ", " + "Mauri");

        socio2 = new SocioDTO();
        socio2.setNombre("Perez" + ", " + "Juan");
        socio2.setEmail("juanperez@gmail.com");
    }

    @Test
    public void testGetSocios() {
        when(socioDAO.getSocios()).thenReturn(List.of(socio1, socio2));

        List<SocioDTO> socios = socioDAO.getSocios();

        assertNotNull(socios);
        assertEquals(2, socios.size());
        assertEquals(socio1, socios.get(0));
        assertEquals(socio2, socios.get(1));

        verify(socioDAO, times(1)).getSocios();
    }
}
