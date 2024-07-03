package org.umsa.dao;

import org.umsa.dto.SocioDTO;
import org.umsa.model.Socio;

import java.util.List;

public interface SocioDAO {
    public List<SocioDTO> getSocios();

    public Socio getSocioById(Long id);

    public List<SocioDTO> getSocioUnico(Long idUser);
}
