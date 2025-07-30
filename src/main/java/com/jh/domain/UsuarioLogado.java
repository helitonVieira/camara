package com.jh.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario_logado")
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario_logado")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_login", nullable = false)
	private Date dtaLogin;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cod_vereador", nullable = false)
	private Vereador vereador;

	public UsuarioLogado() {
		this.dtaLogin = new Date(); // Define o login como o momento atual
	}

	public UsuarioLogado(Vereador vereador) {
		this.vereador = vereador;
		this.dtaLogin = new Date();
	}

	// Getters e setters

	public Long getId() {
		return id;
	}

	public Date getDtaLogin() {
		return dtaLogin;
	}

	public void setDtaLogin(Date dtaLogin) {
		this.dtaLogin = dtaLogin;
	}

	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}
}
