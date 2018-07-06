package com.fabiozanela.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fabiozanela.patrimonio.domain.Empresa;
import com.fabiozanela.patrimonio.repositories.EmpresaRepository;
import com.fabiozanela.patrimonio.services.exceptions.DataIntegrityException;
import com.fabiozanela.patrimonio.services.exceptions.ObjectNotFoundException;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;
	
	public Empresa find(Integer id) {
		Empresa obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Empresa não encontrada! Id:" + id
					+ ", Tipo: " + Empresa.class.getName());
		}
		return obj;
	}
	
	public Empresa insert(Empresa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Empresa update(Empresa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		} 
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma empresa que possui usuários e departamentos");
		}
	}
}
