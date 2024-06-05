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

    private boolean autorizado;

    @ManyToOne
    private Plan planActual;

    @OneToMany(mappedBy = "socio")
    private List<Turno> turnos;

    @OneToMany(mappedBy = "socio")
    private List<Receta> recetas;
}
