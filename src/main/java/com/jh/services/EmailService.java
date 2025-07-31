package com.jh.services;

import org.springframework.mail.SimpleMailMessage;

import com.jh.domain.Vereador;
import com.jh.domain.Votacao;


public interface EmailService {

	void sendOrderConfirmationEmail(Votacao obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Vereador cliente, String newPass);
}
