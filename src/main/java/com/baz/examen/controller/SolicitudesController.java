package com.baz.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.service.iface.SolicitudesService;

@RestController
public class SolicitudesController {
	
	@Autowired
	private SolicitudesService solicitudesService;
	
	@PostMapping("/solicitud/amigo")
	public ResponseEntity<SolicitudAmigoDTO> guardarSolicitudAmigo(@RequestBody SolicitudAmigoDTO solicitudAmigo) {
		return new ResponseEntity<>(solicitudesService.guardarSolicitudAmigo(solicitudAmigo), HttpStatus.CREATED);
	}
	
	@GetMapping("/solicitudes/from/others/to/usuario/{idUsuario}")
	public ResponseEntity<List<SolicitudAmigoDTO>> consultarSolicitudesFromOthersToIdUsuario(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(solicitudesService.consultarSolicitudesFromOthersToIdUsuario(idUsuario), HttpStatus.OK);
	}
	
	@PutMapping("/solicitud/estatus")
	public ResponseEntity<SolicitudAmigoDTO> actualizarStatusSolicitudAmigo(@RequestBody SolicitudAmigoDTO solicitudAmigo) {
		return new ResponseEntity<>(solicitudesService.actualizarStatusSolicitudAmigo(solicitudAmigo), HttpStatus.OK);
	}

}
