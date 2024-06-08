package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
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
public class Profesional extends PanacheEntity {
    private String apellido;

    private String documento;

    private String email;

    private String especialidad;

    private String matricula;

    private String nombre;

    private String ubicacion;

    @ManyToMany(mappedBy = "profesional")
    private List<Plan> planes;

    @OneToMany(mappedBy = "profesional")
    private List<Turno> turnos;
}
