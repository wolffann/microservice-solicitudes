package com.baz.examen.service.impl.remote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.baz.examen.model.AmigoDTO;
import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.service.iface.remote.EntityAdministracionServiceRemote;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntityAdministracionServiceFallback implements EntityAdministracionServiceRemote {

	@Override
	public SolicitudAmigoDTO guardarSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo) {
		log.error("Error controlado, servicio entity administracion con endpoint /solicitud/amigo no disponible, evitando timeout");
		return new SolicitudAmigoDTO();
	}

	@Override
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(Integer idUsuario) {
		log.error("Error controlado, servicio entity administracion con endpoint /solicitudes/from/others/to/usuario/{idUsuario} no disponible, evitando timeout");
		return new ArrayList<SolicitudAmigoDTO>();
	}

	@Override
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo) {
		log.error("Error controlado, servicio entity administracion con endpoint /solicitud/estatus no disponible, evitando timeout");
		return new SolicitudAmigoDTO();
	}
	
	@Override
	public AmigoDTO guardarAmigo(AmigoDTO amigo) {
		log.error("Error controlado, servicio entity administracion con endpoint /amigo no disponible, evitando timeout");
		return new AmigoDTO();
	}
	
}
