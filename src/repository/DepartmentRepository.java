package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import repository.utils.DBUtils;
import repository.utils.SqlQuerys;
public class DepartmentRepository {

	// aqui podemos poner únicamente todo el código necesario para insertar, eliminar, obtener, o actualizar departamentos en la base de datos 
	// voy a poner que devuelva boolean para saber si se ha creado o no
	public boolean insertDepartment(Department department) {
		
		boolean isCreated = false;
		
		// La conexion con BBDD
		Connection connection = null;
		// Vamos a lanzar una sentencia SQL contra la BBDD
		PreparedStatement  preparedStatement  = null;
		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);
			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			// Montamos la SQL 
			String sql = SqlQuerys.INSERT_DEPARTMENT;

			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, department.getDeptNo());
			preparedStatement.setString(2, department.getDnombre());
			preparedStatement.setString(3, department.getLoc());
					
			// para ver la consulta antes de que se ejecute
			System.out.println(preparedStatement);
			
			// La ejecutamos...
			preparedStatement.executeUpdate();
			isCreated = true;
		} catch (SQLException sqle) {  
			System.out.println("Error con la BBDD - " + sqle.getMessage());
			sqle.printStackTrace();
		} catch(Exception e){ 
			System.out.println("Error genérico - " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Cerramos al reves de como las abrimos
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

		return isCreated;
	}
	
	
	public List<Department> getAllDepartments() {
		List <Department> response = new ArrayList<Department>();
		// SQL que queremos lanzar
		String sql = SqlQuerys.SELECT_ALL_DEPARTMENTS;
		// La conexion con BBDD
		Connection connection = null;
		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);
			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while(resultSet.next()) {
				Integer deptNo = resultSet.getInt("dept_no");
				String dnombre = resultSet.getString("dnombre");
				String loc = resultSet.getString("loc");
				Department department = new Department(deptNo, dnombre, loc);
				response.add(department);
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
				if (statement != null) { 
					statement.close();
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
