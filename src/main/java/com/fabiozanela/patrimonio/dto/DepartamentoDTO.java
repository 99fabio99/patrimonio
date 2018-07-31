package com.fabiozanela.patrimonio.dto;

import java.io.Serializable;

import com.fabiozanela.patrimonio.domain.Departamento;

public class DepartamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public DepartamentoDTO(){
		
	}
	
	public DepartamentoDTO(Departamento obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
