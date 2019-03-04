package fr.iocean.dta.service;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.model.Employe;

@Service
@Transactional
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
		System.out.println("envoi du message :" + this.message + " à monsieur " + e.getNom() + " " + e.getPrenom());
	}

}
