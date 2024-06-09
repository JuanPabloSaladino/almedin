package org.umsa.dao;

import org.umsa.model.Receta;

import java.util.List;

public interface RecetaDAO {
    public List<Receta> getRecetas();

    public Receta descargarReceta(Long idTurno,Long idUsuario);
}
