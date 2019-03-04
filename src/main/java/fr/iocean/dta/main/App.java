package fr.iocean.dta.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

import fr.iocean.dta.exception.ErrorUpdateException;
import fr.iocean.dta.model.Employe;
import fr.iocean.dta.service.EmployeService;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = "fr.iocean.dta")
@EnableAspectJAutoProxy
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		logger.info("Example log from {}", App.class.getSimpleName());

		Employe e1 = new Employe();
		e1.setDateEmbauche(LocalDate.of(2018, 3, 20));
		e1.setNom("yoaan");
		e1.setNumeroSS("5");
		e1.setPrenom("mercadier");
		e1.setSalaire(new BigDecimal(5.99));

		EmployeService employeeJdbcService = (EmployeService) context.getBean("employeeJdbcService");
		employeeJdbcService.saveEmployee(e1);

		List<Employe> l = employeeJdbcService.findAllEmployees();
		l.get(0).setNom("PAOLO");
		employeeJdbcService.updateEmployee(l.get(0));
		System.out.println(l.toString());
		l.add(e1);
	
		employeeJdbcService.updateAll(l);
		
		
//		employeeJdbcService.deleteEmploye(3);

//		Employe e2 = employeeJdbcService.findBySsn("5");

//		System.out.println("YO :" + e2);
		context.close();
	}
}
