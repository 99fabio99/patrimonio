package com.fabiozanela.patrimonio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.patrimonio.domain.Usuario;
import com.fabiozanela.patrimonio.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
