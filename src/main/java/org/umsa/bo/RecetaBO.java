package org.umsa.bo;

import org.umsa.model.Receta;

import java.util.List;

public interface RecetaBO {
     List<Receta> getRecetas();

     Receta descargarReceta(Long idTurno,Long idUsuario);
}
