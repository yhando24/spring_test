package fr.iocean.dta.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.exception.ErrorUpdateException;
import fr.iocean.dta.model.Employe;

@Repository
@Transactional
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {

	@Override
	public void saveEmployee(Employe employe) {
		java.sql.Date date = Date.valueOf(employe.getDateEmbauche());
		this.jdbcTemplate.update("insert into employee(firstname, hiredate, lastname, salary, ssn) values(?,?,?,?,?)",
				employe.getPrenom(), date, employe.getNom(), employe.getSalaire(), employe.getNumeroSS());

	}

	@Override
	public List<Employe> findAllEmployes() {
		List<Employe> e = this.jdbcTemplate.query("select firstname, lastname, hiredate, id, ssn, salary from employee",
				new EmployeMapper());
		return e;
	}

	@Override
	public Employe findBySsn(String ssn) throws EmployeeNotFoundException {
		return this.jdbcTemplate.queryForObject("select * from employee where ssn = ?", new Object[] { ssn },
				new EmployeMapper());

	}

	@Override
	public void updateEmployee(Employe employe) {
		java.sql.Date date = Date.valueOf(employe.getDateEmbauche());
		this.jdbcTemplate.update(
				"update employee set firstname = ?, lastname = ?, hiredate = ?,  salary = ?, ssn = ? where id = ?",
				employe.getPrenom(), employe.getNom(), date, employe.getSalaire(), employe.getNumeroSS(),
				employe.getIdentifiant());

	}

	private static final class EmployeMapper implements RowMapper<Employe> {

		@Override
		public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employe employe = new Employe();
			employe.setPrenom(rs.getString("firstname"));
			employe.setNom(rs.getString("lastname"));
			employe.setDateEmbauche(rs.getDate("hiredate").toLocalDate());
			employe.setIdentifiant(rs.getLong("id"));
			employe.setNumeroSS(rs.getString("ssn"));
			employe.setSalaire(rs.getBigDecimal("salary"));
			return employe;

		}
	}

	@Override
	public void deleteEmploye(int id) {
		this.jdbcTemplate.update("delete from employee where id = ?", Long.valueOf(id));

	}

	@Override
	public void updateAll(List<Employe> employes) throws ErrorUpdateException {

		for (Employe employe : employes) {
			int executer = 0;
				java.sql.Date date = Date.valueOf(employe.getDateEmbauche());
				System.out.println("update de :" + employe.getIdentifiant());

				executer +=	this.jdbcTemplate.update(
						"update employee set firstname = ?, lastname = ?, hiredate = ?,  salary = ?, ssn = ? where id = ?",
						"Prenom", "nom", date, employe.getSalaire(), employe.getNumeroSS(), employe.getIdentifiant());
				if(executer != 1) {
					throw  new ErrorUpdateException("Erreur update");
				}
		
		}
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		
	}
}
