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
public class GetTurnoDTO {
    private Long ID;

    private Long socioID;

    private String nombreSocio;

    private LocalDateTime fechaTurno;

    private Long profesionalID;

    private String nombreProfesional;

    private String motivoDeConsultaTurno;
}
