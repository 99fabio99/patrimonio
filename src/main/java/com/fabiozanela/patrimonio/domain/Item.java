package com.fabiozanela.patrimonio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fabiozanela.patrimonio.domain.enums.EstadoEquipamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String modelo;
	private String marca;
	private long numeroSerie;
	private Integer estadoEquipamento;
	
	@ManyToOne
	@JoinColumn(name="sala_id")
	private Sala sala;
	
	@OneToMany(mappedBy="item")
	private List<Item> itens = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="item")
	private Senha senha;
	
	public Item() {
		
	}

	public Item(Integer id, String nome, String modelo, String marca, long numeroSerie, Integer estadoEquipamento,
			Sala sala, Item item, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.modelo = modelo;
		this.marca = marca;
		this.numeroSerie = numeroSerie;
		this.estadoEquipamento = estadoEquipamento;
		this.sala = sala;
		this.item = item;
		this.categoria = categoria;
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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
