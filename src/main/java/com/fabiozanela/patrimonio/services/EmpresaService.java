package com.fabiozanela.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.patrimonio.domain.Empresa;
import com.fabiozanela.patrimonio.repositories.EmpresaRepository;
import com.fabiozanela.patrimonio.services.exceptions.ObjectNotFoundException;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;
	
	public Empresa buscar(Integer id) {
		Empresa obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Empresa não encontrada! Id:" + id
					+ ", Tipo: " + Empresa.class.getName());
		}
		return obj;
	}
}
