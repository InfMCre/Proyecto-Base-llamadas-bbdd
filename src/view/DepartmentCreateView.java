package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class DepartmentCreateView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDepartmentNumber;
	private JTextField textFieldDepartmentName;
	private JTextField textFieldDepartmentLocation;
	
	// Controller controller;

	/**
	 * Create the panel.
	 */
	public DepartmentCreateView(Controller controller) {
		// si no nos dara excepcion Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
		// this.controller = controller;
		setLayout(null);
		
		textFieldDepartmentNumber = new JTextField();
		textFieldDepartmentNumber.setBounds(41, 103, 86, 20);
		add(textFieldDepartmentNumber);
		textFieldDepartmentNumber.setColumns(10);
		
		textFieldDepartmentName = new JTextField();
		textFieldDepartmentName.setBounds(150, 103, 86, 20);
		add(textFieldDepartmentName);
		textFieldDepartmentName.setColumns(10);
		
		textFieldDepartmentLocation = new JTextField();
		textFieldDepartmentLocation.setBounds(259, 103, 86, 20);
		add(textFieldDepartmentLocation);
		textFieldDepartmentLocation.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
		        App app = (App) SwingUtilities.getRoot(component);
		        // Controller controller = app.getController(); // si no hubiesemos pasado el controller al constructor de este panel
		        
		        // obtengo los datos del formulario
		        Integer departmentNumber = Integer.parseInt(textFieldDepartmentNumber.getText()); // TODO Tratar la excepcion por que puede petar
		        String departmentName = textFieldDepartmentName.getText();
		        String departmentLocation = textFieldDepartmentLocation.getText();
		        // llamo a la funcion de crear departamento PUBLICA pasandole dichos datos. sin usar el modelo Department..
		        boolean isCreated = controller.createDepartment(departmentNumber, departmentName, departmentLocation);
		        
		        if (isCreated) {
		        	app.showDepartmentListView();
		        } else {
		        	// TODO Mostrar error
		        	System.out.println("ERROR!");
		        }
			}
		});
		btnNewButton.setBounds(147, 197, 89, 23);
		add(btnNewButton);

	}
}
