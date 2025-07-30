package com.jh.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jh.domain.Projeto;
import com.jh.domain.Votacao;

//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;

public class ProjetoVotacaoResponseDTO implements Serializable {
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
	private MunicipioResponseDTO municipio;
	private VereadorResponseDTO vereador;	 
    private List<VotacaoProjetoDTO> votacao;

	public ProjetoVotacaoResponseDTO() {
	}

	public ProjetoVotacaoResponseDTO(Projeto obj) {
		codProjeto = obj.getCodProjeto();
		numProjeto = obj.getNumProjeto();
		nomProjeto = obj.getNomProjeto();
		desProjeto = obj.getDesProjeto();
		pdf = obj.getPdf();
		flgVotacaoProj = obj.getFlgVotacaoProj();
		dtaVotacao = obj.getDtaVotacao();
		sim = obj.getSim();
		nao = obj.getNao();
		abstencao = obj.getAbstencao();
		municipio = new MunicipioResponseDTO(obj.getMunicipio());
		vereador = new VereadorResponseDTO(obj.getVereador());
		
		List<Votacao> list = obj.getVotacao();
		votacao = list.stream().map(obj2 -> new VotacaoProjetoDTO(obj2)).collect(Collectors.toList());
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

	public void setAbstencao(Integer abstencao) {
		this.abstencao = abstencao;
	}

	public MunicipioResponseDTO getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioResponseDTO municipio) {
		this.municipio = municipio;
	}

	public VereadorResponseDTO getVereador() {
		return vereador;
	}

	public void setVereador(VereadorResponseDTO vereador) {
		this.vereador = vereador;
	}

	public List<VotacaoProjetoDTO> getVotacao() {
		return votacao;
	}

	public void setVotacao(List<VotacaoProjetoDTO> votacao) {
		this.votacao = votacao;
	}	


}
