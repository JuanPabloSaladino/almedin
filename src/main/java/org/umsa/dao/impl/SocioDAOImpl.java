package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.dao.SocioDAO;
import org.umsa.model.Socio;
import org.umsa.repository.SocioRepository;

import java.util.List;

@ApplicationScoped
public class SocioDAOImpl implements SocioDAO {
    @Inject
    SocioRepository socioRepository;

    @Override
    public List<Socio> getSocios() {
        return socioRepository.listAll();
    }

    @Override
    public Socio getSocioById(Long id) {
        return socioRepository.findById(id);
    }
}
