package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.Vereador;
import com.jh.domain.Votacao;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class VotacaoProjetoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codVotacao;     
    private VereadorResponseDTO vereador;     
    private Integer projeto;     
    private String voto;
	
	
	public VotacaoProjetoDTO() {
	}
	
	public VotacaoProjetoDTO(Votacao obj) {
		codVotacao = obj.getCodVotacao();
		
		this.vereador = new VereadorResponseDTO(obj.getVereador());
		
		projeto = obj.getProjeto().getCodProjeto();
		voto = obj.getVoto();
	}

	public Integer getCodVotacao() {
		return codVotacao;
	}

	public void setCodVotacao(Integer codVotacao) {
		this.codVotacao = codVotacao;
	}

	public VereadorResponseDTO getVereador() {
		return vereador;
	}

	public void setVereador(VereadorResponseDTO vereador) {
		this.vereador = vereador;
	}

	public Integer getProjeto() {
		return projeto;
	}

	public void setProjeto(Integer projeto) {
		this.projeto = projeto;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
}
