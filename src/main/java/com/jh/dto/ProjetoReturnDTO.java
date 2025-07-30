package com.jh.dto;

import java.io.Serializable;
import java.util.Date;

import com.jh.domain.Projeto;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class ProjetoReturnDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// @NotEmpty(message="Preenchimento obrigatório")
	// @Length(min=2, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private Integer codProjeto;
	private String numProjeto;
	private String nomProjeto;
	private String desProjeto;
	private String pdf;
	private Boolean flgVotacaoProj;
	private Date dtaVotacao;
	private Integer sim = 0;
	private Integer nao = 0;
	private Integer abstencao = 0;
	private String indAbrirVotacao;
	private String indPainelVotacao;
	private MunicipioDTO municipio;
	private VereadorDTO vereador;

	public ProjetoReturnDTO() {
	}

	public ProjetoReturnDTO(Projeto obj) {
		this.codProjeto = obj.getCodProjeto();
		this.numProjeto = obj.getNumProjeto();
		this.nomProjeto = obj.getNomProjeto();
		this.desProjeto = obj.getDesProjeto();
		this.pdf = obj.getPdf();
		this.flgVotacaoProj = obj.getFlgVotacaoProj();
		this.dtaVotacao = obj.getDtaVotacao();
		this.sim = obj.getSim();
		this.nao = obj.getNao();
		this.abstencao = obj.getAbstencao();
		this.indAbrirVotacao = obj.getIndAbrirVotacao();
		this.indPainelVotacao = obj.getIndPainelVotacao();
		this.municipio = new MunicipioDTO(obj.getMunicipio());
		this.vereador = new VereadorDTO(obj.getVereador());
	}

	public Integer getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Integer codProjeto) {
		this.codProjeto = codProjeto;
	}

	public String getNumProjeto() {
		return numProjeto;
	}

	public void setNumProjeto(String numProjeto) {
		this.numProjeto = numProjeto;
	}

	public String getNomProjeto() {
		return nomProjeto;
	}

	public void setNomProjeto(String nomProjeto) {
		this.nomProjeto = nomProjeto;
	}

	public String getDesProjeto() {
		return desProjeto;
	}

	public void setDesProjeto(String desProjeto) {
		this.desProjeto = desProjeto;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public Boolean getFlgVotacaoProj() {
		return flgVotacaoProj;
	}

	public void setFlgVotacaoProj(Boolean flgVotacaoProj) {
		this.flgVotacaoProj = flgVotacaoProj;
	}

	public Date getDtaVotacao() {
		return dtaVotacao;
	}

	public void setDtaVotacao(Date dtaVotacao) {
		this.dtaVotacao = dtaVotacao;
	}

	public Integer getSim() {
		return sim;
	}

	public void setSim(Integer sim) {
		this.sim = sim;
	}

	public Integer getNao() {
		return nao;
	}

	public void setNao(Integer nao) {
		this.nao = nao;
	}

	public Integer getAbstencao() {
		return abstencao;
	}
	
	public String getIndAbrirVotacao() {
		return indAbrirVotacao;
	}

	public void setIndAbrirVotacao(String indAbrirVotacao) {
		this.indAbrirVotacao = indAbrirVotacao;
	}

	public String getIndPainelVotacao() {
		return indPainelVotacao;
	}

	public void setIndPainelVotacao(String indPainelVotacao) {
		this.indPainelVotacao = indPainelVotacao;
	}

	public void setAbstencao(Integer abstencao) {
		this.abstencao = abstencao;
	}

	public MunicipioDTO getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioDTO municipio) {
		this.municipio = municipio;
	}

	public VereadorDTO getVereador() {
		return vereador;
	}

	public void setVereador(VereadorDTO vereador) {
		this.vereador = vereador;
	}	

}
