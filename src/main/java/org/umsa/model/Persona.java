package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona extends PanacheEntity {

    private String nombre;
    private String apellido;
    private String documento;
    private String email;
    private int edad;
}