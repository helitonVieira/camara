package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.Municipio;
import com.jh.domain.Vereador;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class VereadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    private Integer codVereador;
	    private String nomVereador;
	    private String sglPartido;
	    private String foto;
	    private Boolean indPresidente;	  
	    private Municipio municipio;

	   
	
	public VereadorDTO() {
	}
	
	public VereadorDTO(Vereador obj) {
		codVereador = obj.getCodVereador();
		nomVereador = obj.getNomVereador();
		sglPartido = obj.getSglPartido();
		foto = obj.getFoto();
		indPresidente = obj.getIndPresidente();
		municipio = obj.getMunicipio();	
	}

	public Integer getCodVereador() {
		return codVereador;
	}

	public void setCodVereador(Integer codVereador) {
		this.codVereador = codVereador;
	}

	public String getNomVereador() {
		return nomVereador;
	}

	public void setNomVereador(String nomVereador) {
		this.nomVereador = nomVereador;
	}

	public String getSglPartido() {
		return sglPartido;
	}

	public void setSglPartido(String sglPartido) {
		this.sglPartido = sglPartido;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getIndPresidente() {
		return indPresidente;
	}

	public void setIndPresidente(Boolean indPresidente) {
		this.indPresidente = indPresidente;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
