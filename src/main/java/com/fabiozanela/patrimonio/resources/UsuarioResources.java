package com.fabiozanela.patrimonio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.patrimonio.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {

	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario usu1 = new Usuario(1, "Fabio Miranda Zanela","fabio.fmz18@gmail.com","(62) 98121-8297", "999.999.999-99");
		Usuario usu2 = new Usuario(2, "Alziro Zanela", "alziro@hotmail.com","(62) 99665-5528", "999.999.999-99");
		
		List<Usuario> lista = new ArrayList<>();
		
		lista.add(usu1);
		lista.add(usu2);
		
		return lista; 
	}
}
