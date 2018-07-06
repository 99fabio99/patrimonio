package com.fabiozanela.patrimonio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.patrimonio.domain.Item;
import com.fabiozanela.patrimonio.services.ItemService;

@RestController
@RequestMapping(value="/itens")
public class ItemResources {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Item obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
