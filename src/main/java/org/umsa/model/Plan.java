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
public class Plan extends PanacheEntity {
    private String nombre;

    private int precio;

    @ManyToMany
    private List<Profesional> profesionales;

    @OneToMany(mappedBy = "plan")
    private List<Socio> socios;

    public List<Profesional> getProfesionales() {

        return this.profesionales;
    }


}