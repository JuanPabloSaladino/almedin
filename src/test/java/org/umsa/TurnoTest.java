package org.umsa;



import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.umsa.bo.TurnoBO;
import org.umsa.dao.ProfesionalDAO;
import org.umsa.dao.SocioDAO;
import org.umsa.dao.TurnoDAO;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Profesional;
import org.umsa.model.Socio;
import org.umsa.model.Turno;
import org.mockito.Mock;


import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@QuarkusTest
public class TurnoTest {

    @Mock
    SocioDAO socioDAO;

    @Mock
    ProfesionalDAO profesionalDAO;

    @Mock
    TurnoDAO turnoDAO;

    @InjectMock
    TurnoBO turnoBO;




    @Test
    public void testCrearTurno() throws Exception {

        TurnoDTO turnoDTO = new TurnoDTO();
        Turno turno = new Turno();

        // Setear datos en turnoDTO

        // Simular el comportamiento de las dependencias
        when(socioDAO.getSocioById(anyLong())).thenReturn(new Socio());
        when(profesionalDAO.getProfesionalById(anyLong())).thenReturn(new Profesional());
        when(turnoDAO.crearTurno(turno)).thenReturn(1L);// o el valor que esperes


        // Llamar al método de servicio
        Long turnoID = turnoBO.crearTurno(turnoDTO);

        // Verificar el resultado
        assertNotNull(turnoID); // o alguna otra validación que esperes
    }



}
