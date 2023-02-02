package view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		// vamos a crear el controlador aqui para usarlo desde las vistas.
		// no es la mejor forma de desarrollo pero si una de las mas sencillas de utilizar
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane = getContentPane();
		showDepartmentListView();
	}

	public void showDepartmentListView() {
		contentPane.removeAll();
		// le pasamos el controlador. depende como lo hagamos podriamos pasarle mas cosas
		// o incluso no pasarle el controlador. Pero en este caso el desarrollo es mas sencillo
		DepartmentListView departmentList = new DepartmentListView(controller);
        contentPane.add(departmentList);
        validate();
        setVisible(true);
	}
	
	public void showDepartmentCreateView() {
		contentPane.removeAll();
		// le pasamos el controlador. depende como lo hagamos podriamos pasarle mas cosas
		// o incluso no pasarle el controlador. Pero en este caso el desarrollo es mas sencillo
		DepartmentCreateView departmentList = new DepartmentCreateView(controller);
        contentPane.add(departmentList);
        validate();
        setVisible(true);
	}
	
	
	// esta función nos dejará acceder al controlador desde los paneles inferiores
	// si no podríamos pasarlo por parámetro al constructor de cada panel... que en este ejemplo está asi
	public Controller getController() {
		return controller;
	}

//	
//	public void cambiarPanelAlSegundoPanel(String nombreUsuario) {
//		getContentPane().removeAll();
//		getContentPane().invalidate();
//		SegundoPanel segundoPanel = new SegundoPanel(nombreUsuario);
//		getContentPane().add(segundoPanel);
//		getContentPane().revalidate();
//	}
}
