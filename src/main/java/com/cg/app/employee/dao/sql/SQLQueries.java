package com.cg.app.employee.dao.sql;

import java.util.ResourceBundle;

public final class SQLQueries {
	private static SQLQueries sqlQueries =new SQLQueries();
	private SQLQueries() {
		
	}
	public static SQLQueries getInstance() {
		return sqlQueries;
		
	}
	public String insertEmployee() {
		ResourceBundle bundle =ResourceBundle.getBundle("sql-queries");
		return bundle.getString("insert_Employee");
		
	}
}
