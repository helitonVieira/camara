package com.jh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.domain.Votacao;

@Repository
public interface VotacaoRepository  extends JpaRepository<Votacao, Integer> {

	 List<Votacao> findByProjeto_CodProjeto(Integer codProjeto);
}
