package com.jh.repositories;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.domain.Vereador;

@Repository
public interface VereadorRepository  extends JpaRepository<Vereador, Integer> {

	@Transactional(readOnly=true)
	Vereador findByEmail(String email);
}
