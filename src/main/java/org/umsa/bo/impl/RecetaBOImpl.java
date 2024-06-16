package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.umsa.bo.RecetaBO;
import org.umsa.dao.RecetaDAO;
import org.umsa.dto.RecetaDTO;
import org.umsa.model.Receta;

import java.util.List;

@ApplicationScoped
public class RecetaBOImpl implements RecetaBO {

    private static final Logger logger = Logger.getLogger(TurnoBOImpl.class);

    @Inject
    RecetaDAO recetaDAO;

    @Override
    public List<Receta> getRecetas() {
        return recetaDAO.getRecetas();
    }

    @Override
    public RecetaDTO descargarReceta(Long idTurno, Long idUsuario){

        try {
            Receta receta = recetaDAO.descargarReceta(idTurno,idUsuario);

            if(receta==null) throw new RuntimeException("receta Nulaa");

            RecetaDTO recetaDTO = new RecetaDTO();

            recetaDTO.setContenido(receta.getContenido());

            recetaDTO.setNombreProfesional(receta.getProfesional().getNombre()+" "+receta.getProfesional().getApellido());

            recetaDTO.setNombreSocio(receta.getSocio().getNombre()+" "+receta.getSocio().getApellido());

            recetaDTO.setNroMatriculaProfesional(receta.getProfesional().getMatricula());

            recetaDTO.setContenido(receta.getContenido());

            return recetaDTO;

        }catch (Exception ex) {
            logger.error(ex.getMessage());
                throw new RuntimeException(ex.getMessage());
            }
        }

    }

