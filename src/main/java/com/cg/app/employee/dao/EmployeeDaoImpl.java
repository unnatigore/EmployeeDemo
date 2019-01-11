package com.cg.app.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.app.employee.dao.sql.SQLQueries;
import com.cg.app.employee.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate template;

	public void addNewEmployee(Employee employee) {
		template.update(SQLQueries.getInstance().insertEmployee(),
				new Object[] { employee.getEmpId(), employee.getEmpName(), employee.getSalary() });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.app.employee.dao.EmployeeDao#addNewEmployee(com.cg.app.employee.pojo.
	 * Employee)
	 */

}
