package com.fabiozanela.patrimonio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.patrimonio.domain.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}
