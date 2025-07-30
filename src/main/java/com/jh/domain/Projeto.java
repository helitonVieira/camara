package com.jh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_projeto")
	private Integer codProjeto;
	
	@Column(name = "num_projeto")
	private String numProjeto;

	@Column(name = "nom_projeto")
	private String nomProjeto;

	@Column(name = "des_projeto",columnDefinition = "TEXT")
	private String desProjeto;

	private String pdf;

	@Column(name = "flg_votacao_proj")
	private Boolean flgVotacaoProj;

	@Temporal(TemporalType.DATE)
	@Column(name = "dta_votacao")
	private Date dtaVotacao;

	private Integer sim = 0;
	private Integer nao = 0;
	private Integer abstencao = 0;
	
	@Column(name = "ind_abrir_votacao")
	private String indAbrirVotacao;
	
	@Column(name = "ind_painel_votacao")
	private String indPainelVotacao;
	
	@ManyToOne
	@JoinColumn(name = "cod_municipio")
	private Municipio municipio;

	@ManyToOne
	@JoinColumn(name = "cod_vereador")
	private Vereador vereador;

	@OneToMany(mappedBy = "projeto")
	private List<Votacao> votacao;

	@OneToMany(mappedBy = "projeto")
	private List<Observacao> observacoes;

	public Projeto() {

	}

	public Projeto(Integer codProjeto, String numProjeto, String nomProjeto, String desProjeto, String pdf, 
			Boolean flgVotacaoProj,Date dtaVotacao, Integer sim, Integer nao, 
			Integer abstencao, String indAbrirVotacao, String indPainelVotacao, Integer municipioId, Integer vereadorId
			) {
		super();
		this.codProjeto = codProjeto;
		this.numProjeto = numProjeto;
		this.nomProjeto = nomProjeto;
		this.desProjeto = desProjeto;
		this.pdf = pdf;
		this.flgVotacaoProj = flgVotacaoProj;
		this.dtaVotacao = dtaVotacao;
		this.sim = sim;
		this.nao = nao;
		this.abstencao = abstencao;
		this.indAbrirVotacao = indAbrirVotacao;
		this.indPainelVotacao = indPainelVotacao;

		// Criando apenas com ID (sem buscar no banco aqui)
		this.municipio = new Municipio();
		this.municipio.setCodMunicipio(municipioId);

		this.vereador = new Vereador();
		this.vereador.setCodVereador(vereadorId);
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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	public List<Votacao> getVotacao() {
		return votacao;
	}

	public void setVotacao(List<Votacao> votacao) {
		this.votacao = votacao;
	}

	public List<Observacao> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(List<Observacao> observacoes) {
		this.observacoes = observacoes;
	}

}
