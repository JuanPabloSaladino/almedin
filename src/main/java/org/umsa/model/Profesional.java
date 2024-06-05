package org.umsa.model;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Profesional extends Persona{

	
    private String especialidad;
    private String matricula;
    
    @ManyToMany
    private List<Plan>planes;

    @OneToMany(mappedBy = "profesional")
    private List<Turno> turnos;

    @OneToMany(mappedBy = "profesional")
    private List<Receta> recetas;
}
