package controller;

import java.util.List;

import model.Department;
import repository.DepartmentRepository;

public class Controller {

	// si cargásemos los datos únicamente de inicio, podríamos tener la lista a nivel de la clase
	// si no, deberiamos hacer la carga cada vez que necesitemos los datos
	// private List<Department> departmentsList;
	
	// importamos los repositorios
	private static DepartmentRepository departmentRepository = new DepartmentRepository();
	// private static EmployeeRepository employeeRepository = new EmployeeRepository();
	
	
	public Controller () {
		// el constructo del controlador. Se llamará una única vez desde la vista, 
		// al arrancarse el proyecto. Aquí podríamos cargar la lista de departamentos 
		// o bien cargarlos cada vez que los vayamos a visualizar.
		// dependería sobre todo de la posibilidad de que esos datos sean modificados mientras acceedemos a la aplicación
		
	}
	
	public static List<Department> getAllDepartments() {
		List<Department> departmentsList = departmentRepository.getAllDepartments();
		return departmentsList;
	}
	
	// voy a hacer que devuelva un boolean por si hay un error a hacer el insert. Ejemplo: Clave primaria duplicada
	public boolean createDepartment(Integer departmentNumber, String departmentName, String departmentLocation) {
		
		// creo el departamento
		Department department = new Department(departmentNumber, departmentName, departmentLocation);
		// lo guardo en la db
		boolean isCreated = departmentRepository.insertDepartment(department); // modifico la funcion
		return isCreated;
	}
	
}
