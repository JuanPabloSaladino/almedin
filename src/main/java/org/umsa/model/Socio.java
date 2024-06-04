package org.umsa.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Socio extends Persona {
    
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private int idSocio;
	
    private boolean autorizado;
    
    @ManyToOne
    private Plan planActual;
    
    @OneToMany
    private List<Turno>turnos;

    @OneToMany
    private List<Receta>recetas; 
}
