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
    private Long socioID;

    private LocalDateTime fechaTurno;

    private Long profesionalID;

    private String motivoDeConsultaTurno;
}
