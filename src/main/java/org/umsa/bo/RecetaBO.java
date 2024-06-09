package org.umsa.bo;

import org.umsa.dto.RecetaDTO;
import org.umsa.model.Receta;

import java.util.List;

public interface RecetaBO {
     List<Receta> getRecetas();

     RecetaDTO descargarReceta(Long idTurno, Long idUsuario);
}
