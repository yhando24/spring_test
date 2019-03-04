package fr.iocean.dta.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.model.Employe;

@Service
@Transactional
public class EmployeeStubService implements EmployeService {

	@Override
	public void saveEmployee(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employe> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employe findLastHired() {
		// TODO Auto-generated method stub
		return null;
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
