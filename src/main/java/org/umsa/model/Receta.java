package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ApiModel(value="Receta")
public class Receta extends PanacheEntity {

    @ApiModelProperty(notes = "Contenido de la receta", example = "diclofenac cada 2 horas")
    private String contenido;

    @ApiModelProperty(notes = "Fecha que se emitio la receta", example = "21/7/2022")
    private LocalDateTime fechaCreacion;

    private String hash = UUID.randomUUID().toString();

    @ApiModelProperty(notes = "Turno donde fue asignado la receta")
    @OneToOne
    private Turno turno;

    @ApiModelProperty(notes = "Profesional Medico que emitio la Receta")
    @ManyToOne
    private Profesional profesional;

    @ApiModelProperty(notes = "Socio , destinatario UNICO de la receta")
    @ManyToOne
    private Socio socio;
}
