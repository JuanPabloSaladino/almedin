package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.SocioBO;
import org.umsa.dao.SocioDAO;
import org.umsa.model.Socio;

import java.util.List;

@ApplicationScoped
public class SocioBOImpl implements SocioBO {
    @Inject
    SocioDAO socioDAO;

    @Override
    public List<Socio> getSocios() {
        return socioDAO.getSocios();
    }
}
