package org.umsa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class TurnoDTO {
    private Long id;

    private Long socioID;

    private String nombreProfesional;

    private LocalDateTime fechaTurno;

    private Long profesionalID;

    private String motivoDeConsultaTurno;

    private Boolean cancelado;
}
