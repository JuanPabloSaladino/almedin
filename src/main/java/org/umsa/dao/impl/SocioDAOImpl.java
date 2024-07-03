package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.dao.SocioDAO;
import org.umsa.dto.SocioDTO;
import org.umsa.model.Socio;
import org.umsa.model.Turno;
import org.umsa.repository.SocioRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SocioDAOImpl implements SocioDAO {
    @Inject
    SocioRepository socioRepository;

    @Override
    public List<SocioDTO> getSocios() {
        List<SocioDTO> sociosDTO = new ArrayList<>();

        for (Socio socio : socioRepository.buscarSocios()) {


            SocioDTO socioDTO = new SocioDTO();
            socioDTO.setNombre(socio.getApellido() + ", " + socio.getNombre());
            socioDTO.setEmail(socio.getEmail());
            socioDTO.setId(socio.id);

            sociosDTO.add(socioDTO);
        }

        return sociosDTO;
    }

    // este metodo devuelve una lista con 1 (UN) solo integrante , o devuelve una listaVacia
    public List<SocioDTO> getSocioUnico(Long idUser) {
        List<SocioDTO> sociosDTO = new ArrayList<>();
        Socio socio = socioRepository.findById(idUser);
        SocioDTO socioDTO = new SocioDTO();

        if(socio !=null ) {
            socioDTO.setNombre(socio.getApellido() + ", " + socio.getNombre());
            socioDTO.setEmail(socio.getEmail());
            socioDTO.setId(socio.id);

            sociosDTO.add(socioDTO);

        }


        return sociosDTO;
    }

    @Override
    public Socio getSocioById(Long id) {
        return socioRepository.findById(id);
    }

}
