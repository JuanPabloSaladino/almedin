package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@ApiModel(value="Profesional")
public class Profesional extends PanacheEntity {


    private String apellido;

    @ApiModelProperty(notes = "DNI del medico", example = "48265936")
    private String documento;


    private String email;

    @ApiModelProperty(notes = "Especilidad Medica", example = "Urologo , Dentista, Gastrointerologo")
    private String especialidad;

    @ApiModelProperty(notes="NUMERO de la Matricula", example = "142.198")
    private String matricula;

    private String nombre;

    @ApiModelProperty(notes = "Lugar donde ATIENDE el Profesional", example = "Centro Osde, ayacucho 210")
    private String ubicacion;

    @ApiModelProperty(notes = "UNICOS PLANES a los cuales el profesional PRESTA SERVICIOS", example = "osde210,osde410")
    @ManyToMany(mappedBy = "profesionales")
    private List<Plan> planes;

    @ApiModelProperty(notes = "Cuadrilla de turnos asignados al Profesional")
    @OneToMany(mappedBy = "profesional")
    private List<Turno> turnos;
}
