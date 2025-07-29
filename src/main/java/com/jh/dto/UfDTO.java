package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.UF;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class UfDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 
	private Integer id;
	 
	private String sigla;
	 
	private String nome;
	
	public UfDTO() {
	}
	
	public UfDTO(UF obj) {
		id = obj.getId();
		sigla = obj.getSigla();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
