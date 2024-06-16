package org.umsa.model;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ApiModel(value="Turno")
public class Turno extends PanacheEntity {

    @ApiModelProperty(notes = "Si el turno FUE CANCELADO o NO")
    private boolean cancelado;

    @ApiModelProperty(notes = "Fecha agendada para el turno Medico", example = "2023-06-21 T 11:45:00")
    private LocalDateTime fechaInicio;

    @ApiModelProperty(notes = "Fecha del momento en que FUE CREADO el turno", example = "2023-04-16 T 10:45:00")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private String hash = UUID.randomUUID().toString();

    @ApiModelProperty(notes = "Si el turno esta OCUPADO por un socio o Si esta Libre")
    private boolean ocupado;

    @ApiModelProperty(notes = "Motivo por el cual se socilito este turno", example = "Revision general")
    private String motivoDeConsulta;

    @ManyToOne
    private Profesional profesional;

    @ManyToOne
    private Socio socio;

    @OneToOne(mappedBy = "turno")
    private Receta receta;
}
