package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.RecetaBO;
import org.umsa.dao.RecetaDAO;
import org.umsa.model.Receta;

import java.util.List;

@ApplicationScoped
public class RecetaBOImpl implements RecetaBO {
    @Inject
    RecetaDAO recetaDAO;

    @Override
    public List<Receta> getRecetas() {
        return recetaDAO.getRecetas();
    }
}
