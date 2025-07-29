package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.Municipio;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class MunicipioResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codMunicipio;
	
	//@NotEmpty(message="Preenchimento obrigatório")
	//@Length(min=2, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nomMunicipio;	
	private UfDTO uf;
	
	public MunicipioResponseDTO() {
	}
	
	public MunicipioResponseDTO(Municipio obj) {
		codMunicipio = obj.getCodMunicipio();
		nomMunicipio = obj.getNomMunicipio();
		uf = new UfDTO(obj.getUF());
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

	public UfDTO getUf() {
		return uf;
	}

	public void setUf(UfDTO uf) {
		this.uf = uf;
	}	
	
	

}
