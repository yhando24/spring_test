package fr.iocean.dta.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.model.Employe;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	private EmployeService employeMockService;
	
	public List <Employe> findEmployes(){
		return employeMockService.findAllEmployees();
	}
	
}
