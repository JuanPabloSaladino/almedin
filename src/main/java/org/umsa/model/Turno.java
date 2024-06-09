package org.umsa.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Turno extends PanacheEntity {
    private boolean cancelado;    //preguntar, como lo ve pq pasaria de false a true y devuelta a false , a menos que sea cancelado definitivo (baja del turno) 

    private LocalDateTime fechaInicio;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private String hash = UUID.randomUUID().toString();

    private boolean ocupado;

    private String motivoDeConsulta;

    @ManyToOne
    private Profesional profesional;

    @ManyToOne
    private Socio socio;

    @OneToOne(mappedBy = "turno")
    private Receta receta;
}
