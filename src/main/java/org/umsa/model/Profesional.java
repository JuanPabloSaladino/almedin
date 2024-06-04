package org.umsa.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Profesional extends Persona {
    
	
	private String especialidad;
	
    private String matricula;
    
    
    
    @OneToMany
    private List<Turno>turnos;
    
    @OneToMany
    private List<Receta>recetas;

   
}
