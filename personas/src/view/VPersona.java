package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.PersonaListener;
import model.Persona;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

/**Esta es la ventana principal de cual se accedera a todas las ventanas y desde donde se acceden   
 * 
 * @author Rivas12
 * @version 0.1
 * @since 26.09.2021
 */

public class VPersona extends JFrame {

	private static final long serialVersionUID = 1L;
	static final int ANCHO = 800;
	static final int ALTO = 600;
	
	/**
	 * declara la tabla donde se a?adir? los datos de la base de datos 
	 */
	private JTable tblPersonas;
	
	/**
	 * declara el boton que se usar? para consultar la base de datos
	 */
	private JButton btnConsulta;
	
	/**
	 * declara el boton que se usar? para a?adir un objeto persona de la base de datos
	 */
	private JButton btnAniadir;
	
	/**
	 * declara el boton que se usar? para eliminar un objeto persona de la base de datos
	 */
	private JButton btnEliminar;
	
	/**
	 * declara el boton que se usar? para modificar un objeto persona de la base de datos
	 */
	private JButton btnModificar;
	
	/**
	 * declara el tblModel que es donde se va a crear la estructura de la tabla
	 */
	private DefaultTableModel tblModel;
	
	/**
	 * declara el un una barra deslizable tano vertical como horizontalmente
	 */
	private JScrollPane scrpContenedor;
	
	private static final String CLM_NOMBRE = "NOMBRE";
	private static final String CLM_APELLIDOS = "APELLIDOS";
	private static final String CLM_DNI = "DNI";
	
	/**Este boton carga los datos de la base de datos en la tabla
	 * 
	 */
	public static String BTN_CONSULTAR = "CONSULTAR";
	
	/**
	 * Este boton usa el metodo deletePersona de la persistencia para eliminar un objeto persona 
	 */
	public static final String BTN_ELIMINAR = "ELIMINAR";
	
	/**
	 * Este boton carga la ventana VAniadir
	 */
	public static final String BTN_ANIADIR = "A?ADIR";
	
	/**
	 * Este boton carga la ventana VModificar  
	 */
	public static final String BTN_MODIFICAR = "MODIFICAR";
	
	
	
	/** 
	 * En este metodo se encuentran todos los metodos que utilizar? la clase VPersona
	 */
	public VPersona() {
		init();
	}

	/**
	 *  Este metodo crea los componentes de la interfaz principal
	 */
	private void init() {
		getContentPane().setLayout(null);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 0, 0);
		getContentPane().add(scrpContenedor);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(ANCHO, ALTO);

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 167, 724, 282);
		getContentPane().add(scrollPane);
		
		tblPersonas = new JTable();
		scrollPane.setViewportView(tblPersonas);
		
		configurarTabla();
		
		btnConsulta = new JButton(BTN_CONSULTAR);
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsulta.setBounds(31, 112, 156, 37);
		getContentPane().add(btnConsulta);
		
		btnAniadir = new JButton(BTN_ANIADIR);
		btnAniadir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAniadir.setBounds(31, 486, 156, 37);
		getContentPane().add(btnAniadir);
		
		btnEliminar = new JButton(BTN_ELIMINAR);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(316, 486, 156, 37);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton(BTN_MODIFICAR);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificar.setBounds(602, 486, 156, 37);
		getContentPane().add(btnModificar);
		
		JLabel lblConsultar = new JLabel("Haga click en \"CONSULTAR\" para ver los registros");
		lblConsultar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblConsultar.setBounds(29, 46, 527, 37);
		getContentPane().add(lblConsultar);
	}
	
	/**
	 * Este metodo crea la tabla a la que mas tarde se le a?adira los datos de la base de datos
	 * Dentro de este metodo se utilza el metodo booleano isCellEditable para que no sea editable
	 * al ejecutar el programa 
	 * 
	 */

	private void configurarTabla() {
		tblModel = new DefaultTableModel() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				
					return false;
			
			}
		};
		
		tblModel.addColumn(CLM_NOMBRE);
		tblModel.addColumn(CLM_APELLIDOS);
		tblModel.addColumn(CLM_DNI);
		
		tblPersonas.setModel(tblModel);
		
		tblPersonas.getColumn(CLM_NOMBRE).setPreferredWidth(45);
		tblPersonas.getColumn(CLM_APELLIDOS).setPreferredWidth(200);
		tblPersonas.getColumn(CLM_DNI).setPreferredWidth(60);		
	}
	
	/**
	 * Este metodo introduce en la tabla los datos de cada objeto persona del arrayList que se recibe como parametro 
	 *
	 * @param listaPersonas Es el arrayList que nos retorna la clase PersonaPersistencia, en el 
	 * 		                que se encuentran los datos de cada objeto persona
	 * 
	 */
	
	public void cargarTabla(ArrayList<Persona> listaPersonas) {
		
		tblModel.setRowCount(0);
		
		Object[] fila = new Object[4];
		
		for (Persona persona : listaPersonas) {
			fila[0] = persona.getNombre();
			fila[1] = persona.getApellidos();
			fila[2] = persona.getDni();
			
			tblModel.addRow(fila);
		}
		
	}
	
	/**
	 * Este metodo retorna el dni de la fila seleccionada, si no hay una fila seleccionada te devolver? un mensaje de error en el que 
	 * dice "Debe seleccionar un registro", si se ha seleccionado una fila te retornar? el dni de dicha fila
	 *
	 * @return retorna el String dni de la fila que se selecciona en la tabla
	 */
	
	public String getPersonaSeleccionado() {
		String dni = "";
		
		if (tblPersonas.getSelectedRow() == -1) {
			mostrarMsjError("Debe seleccionar un registro");
			
		} else {
			dni = (String) tblModel.getValueAt(tblPersonas.getSelectedRow(), 2);
		}
		
		return dni;
	}
	
	/**
	 * Este metodo sirve para mostrar un mensaje de error a trav?s de otra ventana que se introduce como parametro
	 *
	 * @param string
	 */

	private void mostrarMsjError(String string) {
		JOptionPane.showMessageDialog(this, string, "ERROR", JOptionPane.ERROR_MESSAGE);		
	}
	
	/**Este metodo sirve para asignar a los botones las funciones que se les ha dado en el listener
	 * 
	 * @param listener es la clase donde se asignan las funciones de los botones
	 */

	public void setListener(PersonaListener listener) {
		btnConsulta.addActionListener(listener);
		btnEliminar.addActionListener(listener);
		btnAniadir.addActionListener(listener);
		btnModificar.addActionListener(listener);
	}
	
	/** Este metodo srive para cargar el panel que se introduce como parametro
	 *
	 * @param panel la ventana que queremos cargar
	 */
	
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}

	/** Este metodo sirve para hacer visible un objeto
	 * 
	 */
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Este metodo sirve para obtener el indice de la fila que seleccionemos
	 *
	 * @return Retorna la fila seleccionada
	 */
	
	public boolean isFilaSelect() {
		boolean filaSelect = false;
		
		if (tblPersonas.getSelectedRow() != -1) {
			filaSelect = true;
		}
		
		return filaSelect;
	}
}
