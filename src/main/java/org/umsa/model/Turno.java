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

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Turno extends PanacheEntity {
	
	
	private String turnohash=UUID.randomUUID().toString();
	
    private LocalDateTime fecha;

    private LocalDateTime fechaCreacion;
    
    private boolean ocupado;
    
    private boolean cancelado;
    
    
    @ManyToOne
    private Socio socio;

    @ManyToOne
    private Profesional profesional;
    
}
