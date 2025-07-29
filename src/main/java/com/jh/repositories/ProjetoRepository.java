package com.jh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.domain.Projeto;

@Repository
public interface ProjetoRepository  extends JpaRepository<Projeto, Integer> {

}
