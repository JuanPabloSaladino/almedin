package org.umsa.bo;

import org.umsa.model.Receta;

import java.util.List;

public interface RecetaBO {
    public List<Receta> getRecetas();

    public Receta descargarReceta(Long idTurno,Long idUsuario);
}
