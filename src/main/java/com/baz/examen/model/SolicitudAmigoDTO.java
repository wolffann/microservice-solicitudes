package com.baz.examen.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_EMPTY)
@Data
public class SolicitudAmigoDTO implements Serializable {
	
	private static final long serialVersionUID = 4160195415232009250L;

	private Integer idSolicitud;
	
	private Integer idUsuario;
	
	private Integer idAmigo;
	
	private Character stSolicitud;
	
	private String txSolicitud;
	
	private String fhCreacion;
	
	private String fhModificacion;
	
}
