package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
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
public class Socio extends PanacheEntity {
    private String apellido;

    private boolean autorizado;

    private String documento;

    private int edad;

    private String email;

    private String nombre;

    @ManyToOne
    private Plan plan;

    @OneToMany(mappedBy = "socio")
    private List<Turno> turnos;

    @OneToMany(mappedBy = "socio")
    private List<Receta> recetas;
}
