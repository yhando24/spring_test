package fr.iocean.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.exception.ErrorUpdateException;
import fr.iocean.dta.model.Employe;
import fr.iocean.dta.repository.EmployeeJpaRepository;
import fr.iocean.dta.repository.EmployeeRepository;

@Service
@Transactional(rollbackFor = EmployeeNotFoundException.class)
public class EmployeeJpaService implements EmployeService {

	@Autowired
	private EmployeeRepository employeeJpaRepository;

	@Override
	public void saveEmployee(Employe employe) {
		employeeJpaRepository.saveEmployee(employe);
		
	}

	@Override
	public List<Employe> findAllEmployees() {
	
		return employeeJpaRepository.findAllEmployes();
	}

	@Override	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public Employe findBySsn(String ssn) {

			try {
				return employeeJpaRepository.findBySsn(ssn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;


	}

	@Override
	public void updateEmployee(Employe employe) {
		employeeJpaRepository.updateEmployee(employe);
		
	}

	@Override
	public Employe findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmploye(int id) {
		employeeJpaRepository.deleteEmploye(id);
		
	}

	@Override
	public void updateAll(List<Employe> employes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllEmployees() {
		employeeJpaRepository.deleteAllEmployees();
		
	}
}
