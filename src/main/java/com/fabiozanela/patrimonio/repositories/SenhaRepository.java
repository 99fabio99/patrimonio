package com.fabiozanela.patrimonio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.patrimonio.domain.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Integer>{

}
