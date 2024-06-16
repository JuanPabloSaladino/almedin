package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ApiModel(value="Socio")
public class Socio extends PanacheEntity {
    private String apellido;

    @ApiModelProperty(notes = "Si el socio esta dado ALTA o BAJA", example = "ALTA = true / BAJA =false")
    private boolean autorizado;

    @ApiModelProperty(notes = "DNI del SOCIO", example = "42265936")
    private String documento;

    private int edad;

    private String email;

    private String nombre;

    @ApiModelProperty(notes = "Plan MEDICO ACTUAL del Socio", example ="osde210")
    @ManyToOne
    private Plan plan;

    @ApiModelProperty(notes = "Turnos VIGENTES asignados al Socio")
    @OneToMany(mappedBy = "socio")
    private List<Turno> turnos;

    @ApiModelProperty(notes = "historial de recetas medicas, aqui se guardan todas las recetas otorgadas al Socio desde que es dado de alta en la APP")
    @OneToMany(mappedBy = "socio")
    private List<Receta> recetas;
}
