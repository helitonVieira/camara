package com.jh.dto;

import java.io.Serializable;

import com.jh.domain.Votacao;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class VotacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codVotacao;     
    private Integer vereador;     
    private Integer projeto;     
    private String voto;
	
	
	public VotacaoDTO() {
	}
	
	public VotacaoDTO(Votacao obj) {
		codVotacao = obj.getCodVotacao();
		vereador = obj.getVereador().getCodVereador();
		projeto = obj.getProjeto().getCodProjeto();
		voto = obj.getVoto();
	}

	public Integer getCodVotacao() {
		return codVotacao;
	}

	public void setCodVotacao(Integer codVotacao) {
		this.codVotacao = codVotacao;
	}

	public Integer getVereador() {
		return vereador;
	}

	public void setVereador(Integer vereador) {
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
