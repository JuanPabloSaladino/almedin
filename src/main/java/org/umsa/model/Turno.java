package org.umsa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Turno extends PanacheEntity {
    private boolean cancelado;

    private LocalDateTime fecha;

    private LocalDateTime fechaCreacion;

    private String hash = UUID.randomUUID().toString();

    private boolean ocupado;

    @ManyToOne
    private Profesional profesional;

    @ManyToOne
    private Socio socio;
}
