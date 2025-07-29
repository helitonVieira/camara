package com.jh.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "votacao", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"cod_projeto", "cod_vereador"})
	})
public class Votacao implements Serializable {
    private static final long serialVersionUID = 1L;   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_votacao")
    private Integer codVotacao;

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_vereador", nullable = false)    
    private Vereador vereador;
   
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_projeto", nullable = false)
    private Projeto projeto;     
    private String voto; // sim, nao ou abstencao   
    
    public Votacao() {
    	
    }
    
    public Votacao(Integer codVotacao,Integer vereadorId,Integer projetoId ,String voto ) {
    	this.codVotacao = codVotacao;
    	
    	this.vereador = new Vereador();
    	this.vereador.setCodVereador(vereadorId);
    	
    	this.projeto = new Projeto();
    	this.projeto.setCodProjeto(projetoId);
    	
    	this.voto = voto;
    	
    }

	public Integer getCodVotacao() {
		return codVotacao;
	}

	public void setCodVotacao(Integer codVotacao) {
		this.codVotacao = codVotacao;
	}

	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

}
