package com.jh.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jh.dto.MunicipioDTO;

@Entity
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_municipio")
	private Integer codMunicipio;

	@Column(name = "nom_municipio")
	private String nomMunicipio;

	@ManyToOne
    @JoinColumn(name = "uf_id")	
	private UF uf;

	@OneToMany(mappedBy = "municipio")
	private List<Vereador> vereadores;

	@OneToMany(mappedBy = "municipio")
	private List<Projeto> projetos;

	public Municipio() {
	}

	public Municipio(Integer codMunicipio, String nomMunicipio, UF uf) {
		super();
		this.codMunicipio = codMunicipio;
		this.nomMunicipio = nomMunicipio;
		this.uf = uf;
	}
	
	public Municipio(MunicipioDTO dto) {
		super();
		this.codMunicipio = dto.getCodMunicipio();
		this.nomMunicipio = dto.getNomMunicipio();
		 
		this.uf = dto.getUf();  
	}

	public Integer getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getNomMunicipio() {
		return nomMunicipio;
	}

	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}

	public UF getUF() {
		return uf;
	}

	public void setUF(UF uf) {
		this.uf = uf;
	}

}
