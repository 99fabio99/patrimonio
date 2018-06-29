package com.fabiozanela.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.patrimonio.domain.Usuario;
import com.fabiozanela.patrimonio.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		Usuario obj = repo.findOne(id);
		return obj;
	}
}
