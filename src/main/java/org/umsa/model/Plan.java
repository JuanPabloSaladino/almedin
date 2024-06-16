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
@ApiModel(value="Plan")
public class Plan extends PanacheEntity {

    @ApiModelProperty(notes = "Nombre del Plan", example = "osde 210")
    private String nombre;

    @ApiModelProperty(notes = "Costo total del Plan por Persona", example = "$115.210,15 pesos")
    private int precio;

    @ApiModelProperty(notes = "Lista de los profesionales que atienden en este Plan en ESPECIFICO")
    @ManyToMany
    private List<Profesional> profesionales;

    @ApiModelProperty(notes = "Socios adheridos a este plan")
    @OneToMany(mappedBy = "plan")
    private List<Socio> socios;

    // este metodo se creo adrede, por que por alguna razon esta fallando cuando es llamado, deberia funcionar por la anotacion @Getter pero NO.
    public List<Profesional> getProfesionales() {
        return this.profesionales;
    }
}