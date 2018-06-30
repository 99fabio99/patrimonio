package com.fabiozanela.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.patrimonio.domain.Empresa;
import com.fabiozanela.patrimonio.domain.Usuario;
import com.fabiozanela.patrimonio.repositories.UsuarioRepository;
import com.fabiozanela.patrimonio.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		Usuario obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Usuário não encontrado! Id:" + id
					+ ", Tipo: " + Empresa.class.getName());
		}
		return obj;
	}
}
