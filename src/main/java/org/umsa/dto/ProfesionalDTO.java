package org.umsa.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProfesionalDTO {
    private Long id;

    private String nombreMedico;

    private String especialidad;

    private List<LocalDateTime> horarios;

    private String ubicacion;

}
