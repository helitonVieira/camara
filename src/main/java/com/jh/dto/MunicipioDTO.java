package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.Municipio;
import com.jh.domain.UF;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class MunicipioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codMunicipio;
	
	//@NotEmpty(message="Preenchimento obrigatório")
	//@Length(min=2, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nomMunicipio;	
	private UF uf;
	
	public MunicipioDTO() {
	}
	
	public MunicipioDTO(Municipio obj) {
		codMunicipio = obj.getCodMunicipio();
		nomMunicipio = obj.getNomMunicipio();
		uf = obj.getUF();
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

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}	
	
	

}
