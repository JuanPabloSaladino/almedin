package org.umsa.dao;

import org.umsa.model.Socio;

import java.util.List;

public interface SocioDAO {
    public List<Socio> getSocios();

    public Socio getSocioById(Long id);
}
