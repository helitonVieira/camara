package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.Municipio;
import com.jh.domain.Vereador;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class VereadorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    private Integer codVereador;
	    private String nomVereador;
	    private String email;
	    private String sglPartido;
	    private String foto;
	    private Boolean indPresidente;	 
	    private String senha;
	    private Municipio municipio;

	   
	
	public VereadorNewDTO() {
	}
	
	public VereadorNewDTO(Vereador obj) {
		this.codVereador = obj.getCodVereador();
		this.nomVereador = obj.getNomVereador();
		this.email = obj.getEmail();
		this.sglPartido = obj.getSglPartido();
		this.foto = obj.getFoto();
		this.indPresidente = obj.getIndPresidente();
		this.senha = obj.getSenha();
		this.municipio = obj.getMunicipio();	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
