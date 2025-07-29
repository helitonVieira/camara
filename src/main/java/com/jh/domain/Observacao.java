package com.jh.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Observacao  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_observacao")
    private Integer codObservacao;

    @ManyToOne
    @JoinColumn(name = "cod_projeto")
    private Projeto projeto;

    @Column(name = "des_observacao",columnDefinition = "TEXT")
    private String desObservacao;

    public Observacao() {
    	
    }
    
    
	public Observacao(Integer codObservacao, Projeto projeto, String desObservacao) {
		super();
		this.codObservacao = codObservacao;
		this.projeto = projeto;
		this.desObservacao = desObservacao;
	}


	public Integer getCodObservacao() {
		return codObservacao;
	}

	public void setCodObservacao(Integer codObservacao) {
		this.codObservacao = codObservacao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getDesObservacao() {
		return desObservacao;
	}

	public void setDesObservacao(String desObservacao) {
		this.desObservacao = desObservacao;
	}

	

}
