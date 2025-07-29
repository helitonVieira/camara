package com.jh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.domain.Vereador;

@Repository
public interface VereadorRepository  extends JpaRepository<Vereador, Integer> {

}
