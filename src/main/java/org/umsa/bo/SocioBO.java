package org.umsa.bo;
import org.umsa.dto.SocioDTO;
import org.umsa.model.Socio;

import java.util.List;

public interface SocioBO {
    public List<SocioDTO> getSocios();
}
