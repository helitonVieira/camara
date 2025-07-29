package com.jh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.domain.Municipio;

@Repository
public interface MunicipioRepository  extends JpaRepository<Municipio, Integer> {

}
