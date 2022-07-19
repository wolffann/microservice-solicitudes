package com.baz.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baz.examen.model.AmigoDTO;
import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.service.iface.SolicitudesService;
import com.baz.examen.service.iface.remote.EntityAdministracionServiceRemote;

@Service
public class SolicitudesServiceImpl implements SolicitudesService {
	
	@Autowired
	private EntityAdministracionServiceRemote entityAdministracionServiceRemote;
	
	@Override
	public SolicitudAmigoDTO guardarSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo) {				
		return entityAdministracionServiceRemote.guardarSolicitudAmigo(solicitudAmigo);
	}
	
	@Override
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(Integer idUsuario) {				
		return entityAdministracionServiceRemote.consultarSolicitudesFromOthersToIdUsuario(idUsuario);
	}
	
	@Override
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo) {
		SolicitudAmigoDTO solicitudAmigoRespuesta = new SolicitudAmigoDTO();
		
		solicitudAmigoRespuesta = entityAdministracionServiceRemote.actualizarStatusSolicitudAmigo(solicitudAmigo);
		
		if(Character.valueOf('1').equals(solicitudAmigo.getStSolicitud())) {
			AmigoDTO amigoDTO = new AmigoDTO();
			amigoDTO.setIdAmigo(solicitudAmigoRespuesta.getIdAmigo());
			amigoDTO.setIdUsuario(solicitudAmigoRespuesta.getIdUsuario());
			entityAdministracionServiceRemote.guardarAmigo(amigoDTO);
			
			amigoDTO.setIdAmigo(solicitudAmigoRespuesta.getIdUsuario());
			amigoDTO.setIdUsuario(solicitudAmigoRespuesta.getIdAmigo());
			entityAdministracionServiceRemote.guardarAmigo(amigoDTO);
			
			solicitudAmigoRespuesta.setTxSolicitud("Solicitud aceptada, se ha agregado a la lista de amigos");
		} else {
			solicitudAmigoRespuesta.setTxSolicitud("Solicitud no aceptada, no se ha agregado a la lista de amigos");
		}
		
		return solicitudAmigoRespuesta;
	}

}
