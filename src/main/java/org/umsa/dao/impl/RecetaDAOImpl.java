package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.dao.RecetaDAO;
import org.umsa.model.Receta;
import org.umsa.repository.RecetaRepository;

import java.util.List;

@ApplicationScoped
public class RecetaDAOImpl implements RecetaDAO {
    @Inject
    RecetaRepository recetaRepository;

    @Override
    public List<Receta> getRecetas() {
        return recetaRepository.listAll();
    }
}
