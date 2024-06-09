package org.umsa.dao;

import org.umsa.model.Receta;

import java.util.List;

public interface RecetaDAO {
     List<Receta> getRecetas();

     Receta descargarReceta(Long idTurno,Long idUsuario);
}
