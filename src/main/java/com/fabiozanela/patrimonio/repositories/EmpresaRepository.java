package com.fabiozanela.patrimonio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.patrimonio.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
