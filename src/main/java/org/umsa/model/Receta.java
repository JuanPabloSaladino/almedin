package org.umsa.model;

import java.time.LocalDateTime;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Receta extends PanacheEntity {

    private String recetaHash = UUID.randomUUID().toString();
    private String contenido;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private Socio socio;

    @ManyToOne
    private Profesional profesional;
}
