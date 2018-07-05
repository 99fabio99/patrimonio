package com.fabiozanela.patrimonio.domain.enums;

public enum EstadoEquipamento {

	USO(1, "Uso"), DISPONIVEL(2, "Disponivel"), DEFEITO(3, "Defeito"), MANUTENCAO(4, "Manutencao"), INUTILIZAVEL(5,
			"Inutilizavel");

	private int cod;
	private String descricao;

	private EstadoEquipamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoEquipamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (EstadoEquipamento x : EstadoEquipamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
