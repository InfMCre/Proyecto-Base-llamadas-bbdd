package repository.utils;

public class SqlQuerys {
	
	// departments
	public static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM depart";
	public static final String INSERT_DEPARTMENT = "INSERT INTO depart (dept_no, dnombre, loc) VALUES (?, ?, ?);";
	
	public static final String SELECT_EMPLOYEES_BY_DEPARTMENT_NUMBER = "select * from emple WHERE dept_no = ?";
	// employees
	
	
	// TODO
	// otras tablas
	
	
	// consultas complejas o con joins
}
