package com.jh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Vereador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_vereador")
    private Integer codVereador;

    @Column(name = "nom_vereador")
    private String nomVereador;

    @Column(name = "sgl_partido")
    private String sglPartido;

    private String foto;

    @Column(name = "ind_presidente")
    private Boolean indPresidente;

    @ManyToOne
    @JoinColumn(name = "cod_municipio")
    private Municipio municipio;

    @OneToMany(mappedBy = "vereador")
    private List<Projeto> projetos;

    @OneToMany(mappedBy = "vereador")
    private List<Votacao> votacao;

    public Vereador() {
    	
    }
    
	public Vereador(Integer codVereador, String nomVereador, String sglPartido, String foto, Boolean indPresidente,
			Municipio municipio) {
		super();
		this.codVereador = codVereador;
		this.nomVereador = nomVereador;
		this.sglPartido = sglPartido;
		this.foto = foto;
		this.indPresidente = indPresidente;
		this.municipio = municipio;		
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

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Votacao> getVotacao() {
		return votacao;
	}

	public void setVotacao(List<Votacao> votacao) {
		this.votacao = votacao;
	}    

}
