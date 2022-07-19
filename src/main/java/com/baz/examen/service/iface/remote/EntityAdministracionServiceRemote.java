package com.baz.examen.service.iface.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.baz.examen.model.AmigoDTO;
import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.service.impl.remote.EntityAdministracionServiceFallback;

//@FeignClient(name = "entity-administracion", url = "localhost:8080", fallback=EntityAdministracionServiceFallback.class)
@FeignClient(name = "entity-administracion", fallback=EntityAdministracionServiceFallback.class)
public interface EntityAdministracionServiceRemote {
	
	@PostMapping("/solicitud/amigo")
	public SolicitudAmigoDTO guardarSolicitudAmigo(@RequestBody SolicitudAmigoDTO solicitudAmigo);
	
	@GetMapping("/solicitudes/from/others/to/usuario/{idUsuario}")
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(@PathVariable Integer idUsuario);
	
	@PutMapping("/solicitud/estatus")
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(@RequestBody SolicitudAmigoDTO solicitudAmigo);
	
	@PostMapping("/amigo")
	public AmigoDTO guardarAmigo(@RequestBody AmigoDTO amigo);

}
