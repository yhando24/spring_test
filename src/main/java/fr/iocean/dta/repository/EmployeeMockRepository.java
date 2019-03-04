package fr.iocean.dta.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.model.Employe;

@Repository
public class EmployeeMockRepository implements EmployeeRepository {

	private List<Employe> employes = new ArrayList<>();

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@PostConstruct
	public void init() {
		employes.add(new Employe(1L, "Youcef", "Handoura", "18993781213", new BigDecimal(1500.12),
				LocalDate.of(2018, 8, 25)));
		employes.add(new Employe(5L, "Yoann", "jesaisplus", "18993781214", new BigDecimal(1200.11),
				LocalDate.of(2018, 7, 25)));
	}

	public EmployeeMockRepository() {

	}

	public void saveEmployee(Employe employe) {
		// TODO Auto-generated method stub

	}

	public List<Employe> findAllEmployes() {
		// TODO Auto-generated method stub
		return this.employes;
	}

	public Employe findBySsn(String ssn) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
	return	employes.stream().filter(s -> s.getNumeroSS().equals(ssn)).findFirst()
			.orElseThrow(() -> new EmployeeNotFoundException(" Aucun Employe avec ce numero de SS"));
	}

	public void updateEmployee(Employe employe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmploye(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAll(List<Employe> employes) {
		// TODO Auto-generated method stub
		
	}

}
