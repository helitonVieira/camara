package com.jh.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.jh.domain.Vereador;
import com.jh.domain.Votacao;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Votacao obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Votacao obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getVereador().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Voto confirmado! Código: " + obj.getCodVotacao());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	@Override
	public void sendNewPasswordEmail(Vereador vereador, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(vereador, newPass);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareNewPasswordEmail(Vereador vereador, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(vereador.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
}
