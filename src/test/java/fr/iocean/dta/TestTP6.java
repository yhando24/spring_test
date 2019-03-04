package fr.iocean.dta;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.iocean.dta.main.App;
import fr.iocean.dta.model.Employe;
import fr.iocean.dta.service.MailService;

public class TestTP6 {

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

	@Test
	public void test() {

		MailService mailServiceA = (MailService) context.getBean("mailService");

		MailService mailServiceB = (MailService) context.getBean("mailService");

		mailServiceA.setMessage("Ceci est votre message A");
		mailServiceB.setMessage("Ceci est votre message B");

		mailServiceA.sendMail(new Employe(1L, "Youcef", "Handoura", "18993781213", new BigDecimal(1500.12),
				LocalDate.of(2018, 8, 25)));

		mailServiceB.sendMail(new Employe(5L, "Yoann", "jesaisplus", "18993781214", new BigDecimal(1200.11),
				LocalDate.of(2018, 7, 25)));

	}
}
