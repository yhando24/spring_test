package fr.iocean.dta.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.model.Employe;

@Repository
public class EmployeeJpaRepository extends AbstractJpaRepository<Employe> implements EmployeeRepository{

	@Override
	public void saveEmployee(Employe employe) {
		this.em.persist(employe);
	}

	@Override
	public List<Employe> findAllEmployes() {
	TypedQuery<Employe>	query = this.em.createQuery("select e from Employe e", Employe.class);
	return  query.getResultList();
	}

	@Override
	public Employe findBySsn(String ssn) throws EmployeeNotFoundException {
		TypedQuery<Employe>	query;
		try {
		query =	this.em.createQuery("select e from Employe e where e.numeroSS=?",Employe.class);
		query.setParameter(1, ssn);
		
	}catch (Exception e) {
		throw new EmployeeNotFoundException("nop");
		}
return query.getSingleResult();
	}

	@Override
	public void updateEmployee(Employe employe) {
		this.em.persist(employe);
		
	}

	@Override
	public void deleteEmploye(int id) {
		TypedQuery<Employe>	query =	this.em.createQuery("delete e from Employe e where e.id=:id",Employe.class);
		query.setParameter("id", id);
		
	}

	@Override
	public void updateAll(List<Employe> employes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllEmployees() {
		TypedQuery<Employe>	query =	this.em.createQuery("delete e from Employe e",Employe.class);
		
	}

}
