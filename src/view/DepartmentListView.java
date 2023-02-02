package view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Department;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class DepartmentListView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;
	
	private final String HEADER_COLUMN_NUMERO_DEPARTAMENTO = "Nº";
	private final String HEADER_COLUMN_NOMBRE_DEPARTAMENTO = "Nombre";
	private final String HEADER_COLUMN_LOCALIZACION_DEPARTAMENTO = "Localización";

	/**
	 * Create the panel.
	 */
	public DepartmentListView(Controller controller) {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 361, 216);
		add(scrollPane);
		
		DefaultTableModel defaultTableModel = getTableData(controller); // funcion para generar el modelo de datos
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);
		
		JButton buttonCreateNewDepartment = new JButton("Create New Department");
		buttonCreateNewDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
		        App app = (App) SwingUtilities.getRoot(component);
		        app.showDepartmentCreateView();
			}
		});
		
		buttonCreateNewDepartment.setBounds(118, 243, 179, 23);
		add(buttonCreateNewDepartment);
	}

	private DefaultTableModel getTableData(Controller controller) {
		// vamos a crear el modelo de datos para la tabla
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		// añadimos columnas
		defaultTableModel.addColumn(HEADER_COLUMN_NUMERO_DEPARTAMENTO);
		defaultTableModel.addColumn(HEADER_COLUMN_NOMBRE_DEPARTAMENTO);
		defaultTableModel.addColumn(HEADER_COLUMN_LOCALIZACION_DEPARTAMENTO);
		// obtenemos todos los departamentos
		List<Department> departmentList = controller.getAllDepartments();
		
		// podemos recorrer la lista de dos maneras: la que se está usando y la que aparece comentada al final del archivo
		// Clase de la que esta formada la lista (Department)
		// nombre de la variable a asignar
		// dos puntos
		// lista
		// si es List<Department> cada elemento de la lista sera Department
		for (Department department : departmentList) {
			// continuar con el mismo codigo
			// generamos las filas o rows de la tabla
			Object[] row = new Object[defaultTableModel.getColumnCount()]; 
			// defaultTableModel.getColumnCount() Sabemos que son 3 columnas, pero si usamos la variable de count de las columnas va a ser dinámico...
			// aunque nos faltaría poner o quitar datos en la columna si se modifica el tamaño de las columnas. de momento tenemos 3
			row[0] = department.getDeptNo();
			row[1] = department.getDnombre();
			row[2] = department.getLoc();
			defaultTableModel.addRow(row);
		}
		
		return defaultTableModel;
	}

	
	// 2
	// la tradicional usada hasta ahora
//	for (int i = 0; i < departmentList.size(); i++) {
//		Department department = departmentList.get(i);
//		// continuar con el mismo codigo
//	}
	

}
