package com.fabiozanela.patrimonio.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabiozanela.patrimonio.domain.Departamento;
import com.fabiozanela.patrimonio.domain.Empresa;
import com.fabiozanela.patrimonio.dto.DepartamentoDTO;
import com.fabiozanela.patrimonio.services.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResources {
	
	@Autowired
	private EmpresaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Empresa> find(@PathVariable Integer id) {
		Empresa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 Notação de @RequestBody é utilizada para converter o objeto json (obtido atraves da requisição)
	 para um objeto java(neste caso foi objeto da classe empresa).
	*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Empresa obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Empresa obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Empresa>> findAll() {
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/departamentos/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> findDepartamentos(@PathVariable Integer id) {
		List<Departamento> listDepartamento = service.find(id).getDepartamentos();
		List<DepartamentoDTO> listDepatamentoDTO = listDepartamento.stream().map(obj -> new DepartamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDepatamentoDTO);
	}
	
}
