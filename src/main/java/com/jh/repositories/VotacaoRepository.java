package com.jh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VotacaoRepository  extends JpaRepository<com.jh.domain.Votacao, Integer> {

}
