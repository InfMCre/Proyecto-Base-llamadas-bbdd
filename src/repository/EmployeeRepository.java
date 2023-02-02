package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Employee;
import repository.utils.DBUtils;
import repository.utils.SqlQuerys;

public class EmployeeRepository {

	// aqui podemos poner únicamente todo el código necesario para insertar, eliminar, obtener, o actualizar empleados en la base de datos 
	
	public List<Employee> getAllEmployeesByDeptNo(Integer departmentId) {
		List<Employee> response = new ArrayList<Employee>();
		
		String sql = SqlQuerys.SELECT_EMPLOYEES_BY_DEPARTMENT_NUMBER;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, departmentId);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				// Sacamos las columnas del RS
				Integer id = resultSet.getInt("emp_no");
				String apellido = resultSet.getString("apellido");
				String oficio = resultSet.getString("oficio");
				Integer dir = resultSet.getInt("dir");
				Date fechaAlt = resultSet.getDate("fecha_alt");
				Float salario = resultSet.getFloat("salario");
				Float comision = resultSet.getFloat("comision");
				Integer deptNo = resultSet.getInt("dept_no");
				
				Employee employee = new Employee(id, apellido, oficio, dir, fechaAlt, salario, comision, deptNo);
				response.add(employee);
			}
			
			
			
		} catch (SQLException sqle) {  
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch(Exception e){ 
			e.printStackTrace();
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch(Exception e){ 
				// No hace falta 
			};
			try {
				if (preparedStatement != null) { 
					preparedStatement.close();
				}
			} catch(Exception e){ 
				// No hace falta				
			};
			try {
				if (connection != null) { 
					connection.close();
				}
			} catch(Exception e){ 
				// No hace falta
			};					
		}
		
		return response;
	}
}
