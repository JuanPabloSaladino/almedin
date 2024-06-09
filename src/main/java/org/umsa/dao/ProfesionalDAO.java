package org.umsa.dao;

import org.umsa.model.Profesional;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfesionalDAO {
    public List<Profesional> getProfesionales();
    
    public Profesional getProfesionalById(Long id);

    public List <LocalDateTime> getTurnosDisponibles(Long id);

    public boolean estaLibre(Long id);
    
}
