package fr.iocean.dta.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.dta.model.Employe;
import fr.iocean.dta.repository.EmployeeRepository;

@Service
public class EmployeMockService implements EmployeService {

	@Autowired
	private EmployeeRepository employeeMockRepository;

	public void saveEmployee(Employe employe) {
		// TODO Auto-generated method stub

	}

	public List<Employe> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeMockRepository.findAllEmployes();
	}

	public Employe findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employe employe) {
		// TODO Auto-generated method stub

	}

	public Employe findLastHired() {
		return employeeMockRepository.findAllEmployes().stream().max(Comparator.comparing(Employe::getDateEmbauche))
				.orElse(new Employe());
	}

}
