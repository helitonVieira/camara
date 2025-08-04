package com.jh.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.domain.enums.Perfil;

@Entity
public class Vereador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_vereador")
    private Integer codVereador;

    @Column(name = "nom_vereador")
    private String nomVereador;
    
    @Column(unique=true)
	private String email;

    @Column(name = "sgl_partido")
    private String sglPartido;

    private String foto;

    @Column(name = "ind_presidente")
    private Boolean indPresidente;
    
    @JsonIgnore
    private String senha;
    
    @ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();    
    
    @ManyToOne
    @JoinColumn(name = "cod_municipio")
    private Municipio municipio;

    @OneToMany(mappedBy = "vereador")
    private List<Projeto> projetos;

    @OneToMany(mappedBy = "vereador")
    private List<Votacao> votacao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "vereador")
    private List<UsuarioLogado> logins;

    public Vereador() {
    	addPerfil(Perfil.CLIENTE);
    }
    
	public Vereador(Integer codVereador, String nomVereador, String email, String sglPartido, String foto, Boolean indPresidente,
			String senha, Municipio municipio) {
		super();
		this.codVereador = codVereador;
		this.nomVereador = nomVereador;
		this.email = email;
		this.sglPartido = sglPartido;
		this.foto = foto;
		this.indPresidente = indPresidente;
		this.municipio = municipio;	
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
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

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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

	public List<UsuarioLogado> getLogins() {
		return logins;
	}

	public void setLogins(List<UsuarioLogado> logins) {
		this.logins = logins;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}    
	
}
