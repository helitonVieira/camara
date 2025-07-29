package com.jh.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jh.dto.UfDTO;

@Entity
public class UF implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "sigla")
	private String sigla;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "uf") // se quiser acessar os municípios por estado
    private List<Municipio> municipios;
	

	public UF() {
	}
	
	public UF(UfDTO dto) {
		this.id = dto.getId();
		this.sigla = dto.getSigla();
		this.nome = dto.getNome();
	}

	public UF(Integer id, String sigla, String nome) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
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

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
	

	
}
