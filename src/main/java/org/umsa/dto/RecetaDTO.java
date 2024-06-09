package org.umsa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecetaDTO {

	private String contenido;

    private String nombreProfesional;

    private String nroMatriculaProfesional;

    private String nombreSocio;

    private LocalDateTime fechaCreacion;
	
	
	
}
