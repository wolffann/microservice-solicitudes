package com.baz.examen.service.iface;

import java.util.List;

import com.baz.examen.model.SolicitudAmigoDTO;

public interface SolicitudesService {
	
	public SolicitudAmigoDTO guardarSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo);
	
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(Integer idUsuario);
	
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo);

}
