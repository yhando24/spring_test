package fr.iocean.dta;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.main.App;
import fr.iocean.dta.model.Employe;
import fr.iocean.dta.repository.EmployeeMockRepository;
import fr.iocean.dta.repository.EmployeeRepository;
import fr.iocean.dta.service.CompanyService;
import fr.iocean.dta.service.EmployeMockService;
import fr.iocean.dta.service.EmployeService;
import fr.iocean.dta.service.MailService;

/**
 * Unit test for simple App.
 */
public class AppTest  {

	AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testBeanEmployeMockRepository() {
		
		EmployeeRepository test = (EmployeeRepository) context.getBean("employeeMockRepository");
		System.out.println(test.findAllEmployes());
		assertTrue(true);
	}

	@Test
	public void testEmployeMockServicefindLastHired() {

		EmployeService ems = (EmployeService) context.getBean("employeMockService");
		System.out.println("LAST : " + ems.findLastHired());
		assertTrue(true);
	}

	@Test
	public void findEmployee() {

		CompanyService cs = (CompanyService) context.getBean("companyService");
		System.out.println("TOUS : " + cs.findEmployes());
		assertNotNull(cs.findEmployes());
	}
	
	@Test
	public void findEmployeewithNumeroSS() {
	
		EmployeeRepository test = (EmployeeRepository) context.getBean("employeeMockRepository");
		try {
			test.findBySsn("qsdqdqddq");
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
