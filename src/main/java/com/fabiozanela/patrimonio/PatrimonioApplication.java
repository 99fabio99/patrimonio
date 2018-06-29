package com.fabiozanela.patrimonio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiozanela.patrimonio.domain.Empresa;
import com.fabiozanela.patrimonio.domain.Usuario;
import com.fabiozanela.patrimonio.repositories.EmpresaRepository;
import com.fabiozanela.patrimonio.repositories.UsuarioRepository;

@SpringBootApplication
public class PatrimonioApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatrimonioApplication.class, args);
	}

	//Utilizado para inserir dados no banco dados local, assim que a aplicação é iniciada
	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null, "Fabio Miranda Zanela","fabio.fmz18@gmail.com","(62) 98121-8297", "999.999.999-99");
		Usuario usu2 = new Usuario(null, "Alziro Zanela", "alziro@hotmail.com","(62) 99665-5528", "999.999.999-99");
		Usuario usu3 = new Usuario(null, "Aroldo Medina","aroldo@gmail.com","(62) 9999-9999", "999.999.999-99");
		
		Empresa emp1 = new Empresa(null, "Marte Digital","81.906.269/0001-33");
		Empresa emp2 = new Empresa(null, "Casa de Saúde Nossa Senhora da Conceição","81.906.269/0001-33");
		
		usu1.getEmpresas().addAll(Arrays.asList(emp1,emp2));
		usu2.getEmpresas().addAll(Arrays.asList(emp1,emp2));
		usu3.getEmpresas().addAll(Arrays.asList(emp2));
		
		emp1.getUsuarios().addAll(Arrays.asList(usu1,usu2));
		emp2.getUsuarios().addAll(Arrays.asList(usu1,usu2,usu3));
		
		usuarioRepository.save(Arrays.asList(usu1,usu2,usu3));
		empresaRepository.save(Arrays.asList(emp1,emp2));
		
		
		
		
	}
}
