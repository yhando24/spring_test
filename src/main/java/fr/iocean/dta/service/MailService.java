package fr.iocean.dta.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import fr.iocean.dta.model.Employe;

@Service
@Scope(value = "prototype")
public class MailService {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void sendMail(Employe e) {
		System.out.println("envoi du message :" + this.message + " à monsieur " + e.getNom() +" " + e.getPrenom());
	}
	
	
}
