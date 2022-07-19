package com.baz.examen.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_EMPTY)
@Data
public class AmigoDTO implements Serializable {
	
	private static final long serialVersionUID = 8900603119240617393L;

	private Integer idUsuario;
	
	private Integer idAmigo;

	private String fhCreacion;
	
	private String fhModificacion;
	
}
