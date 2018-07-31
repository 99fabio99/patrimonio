package com.fabiozanela.patrimonio.dto;

import java.io.Serializable;

import com.fabiozanela.patrimonio.domain.Item;
import com.fabiozanela.patrimonio.domain.enums.EstadoEquipamento;

public class ItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String modelo;
	private String marca;
	private long numeroSerie;
	private Integer estadoEquipamento;
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(Item obj) {
		id = obj.getId();
		nome = obj.getNome();
		modelo = obj.getModelo();
		marca = obj.getMarca();
		numeroSerie = obj.getNumeroSerie();
		estadoEquipamento = obj.getEstadoEquipamento().getCod();
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public long getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(long numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public EstadoEquipamento getEstadoEquipamento() {
		return EstadoEquipamento.toEnum(this.estadoEquipamento);
	}

	public void setEstadoEquipamento(EstadoEquipamento estadoEquipamento) {
		this.estadoEquipamento = estadoEquipamento.getCod();
	}
	
	
}
