package org.umsa.model;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Plan extends PanacheEntity {

    private String nombre;
    private int precio;

    @ManyToMany
    private List<Profesional> profesional;

    @OneToMany(mappedBy = "planActual")
    private List<Socio> socios;
}