package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.PersonaListener;


/**
 * Esta clase sirve para crear la ventana que se utilizar? para a?adir un nuevo objeto 
 * persona a la base de datos
 *  
 * @author Rivas12
 * @version 0.1
 * @since 26.09.2021
 */

public class VAniadir extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declara una constante para el btnLimpiar
	 */
	public static String BTN_DATOS = "Introducir datos";
	
	/**
	 * Declara una constante para el btnDatos
	 */
	public static String BTN_LIMPIAR = "Limpiar datos";
	
	/**
	 * Declara una constante para el btnCancel
	 */
	public static String BTN_CANCEL = "Salir";
	
	/**
	 * Declara un JTextField donde se podr? escribir el nombre
	 */
	private JTextField txtNombre;
	
	/**
	 * Declara un JTextField donde se podr? escribir el primer apellido
	 */
	private JTextField txtApellido1;
	
	/**
	 * Declara un JTextField donde se podr? escribir el nombre segundo apellido
	 */
	private JTextField txtApellido2;
	
	/**
	 * Declara un JTextField donde se podr? escribir el dni
	 */
	private JTextField txtDNI;
	
	/**
	 * Este boton a?ade el objeto persona a la base de datos
	 */
	private JButton btnDatos;
	
	/**
	 * Este boton cierra la ventana VAniadir
	 */
	private JButton btnCancel;
	
	/**
	 * este boton vacia todos los JTextField
	 */
	private JButton btnLimpiar;
	
	/**
	 * En este metodo se encuentran todos los metodos que utilizar? la clase VAniadir
	 */
	public VAniadir() {
	
		init();
	
	}

	
	/**
	 * Este metodo crea los componentes de la interfaz de VAniadir
	 */
	public void init() {
		getContentPane().setLayout(null);
		
		setSize(VPersona.ANCHO-100, VPersona.ALTO-270);
	
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VPersona.ANCHO-30, VPersona.ALTO-70);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(35, 115, 107, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(35, 81, 86, 26);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("Primer Apellido");
		lblApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido1.setBounds(202, 87, 107, 14);
		getContentPane().add(lblApellido1);
		
		txtApellido1 = new JTextField();
		txtApellido1.setBounds(199, 115, 121, 20);
		getContentPane().add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.setBounds(373, 115, 115, 20);
		getContentPane().add(txtApellido2);
		txtApellido2.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido2.setBounds(376, 87, 112, 14);
		getContentPane().add(lblApellido2);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(544, 115, 115, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(544, 87, 46, 14);
		getContentPane().add(lblDNI);
		
		btnDatos = new JButton(BTN_DATOS);
		btnDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDatos.setBounds(279, 212, 132, 23);
		getContentPane().add(btnDatos);
		
		btnCancel = new JButton(BTN_CANCEL);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBounds(506, 212, 132, 23);
		getContentPane().add(btnCancel);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(45, 212, 132, 23);
		getContentPane().add(btnLimpiar);
	}
	
	
	/**
	 * Este metodo sirve para hacer visible un objeto
	 */
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Este metodo sirve para hacer que un objeto deje de ser visible
	 */
	
	public void hacerInvisible() {
		setVisible(false);
	}
	
	/**
	 * Este metodo recoge el String nombre del JTextField txtNombre
	 *
	 * @return nombre
	 */
	
	public String getNombreInsert( ) {
		String nombre = txtNombre.getText();
		
		return nombre;
		
	}
	
	/**
	 * Este metodo recoge el String apellido1 del JTextField txtApellido1
	 * 
	 * @return apellido1
	 */
	
	public String getApe1Insert( ) {
		String ape1 = txtApellido1.getText();
			
		return ape1;
		
	}
	
	/**
	 * Este metodo recoge el String apellido2 del JTextField txtApellido1
	 * 
	 * @return apellido2
	 */
	
	public String getApe2Insert( ) {
		String ape2 = txtApellido2.getText();
			
		return ape2;
		
	}
	
	/**
	 * Este metodo recoge el String dni del JTextField txtDNI
	 * 
	 * @return dni
	 */
	
	public String getDNIInsert( ) {
		String dni = txtDNI.getText();
			
		return dni;
		
	}
	
	/**
	 * Este metodo sirve para mostrar un mensaje de error a trav?s de otra ventana que se 
	 * introduce como parametro
	
	 * @param msj mensaje que quieres mostrar
	 */

	public void mostrarMsjError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Este metodo sirve para mostrar un mensaje de informaci?n a trav?s de otra ventana que se 
	 * introduce como parametro
	
	 * @param msj mensaje que quieres mostrar
	 */
	
	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Este metodo sirve para asignar a los botones las funciones que se les ha dado en el listener

	 * @param listener es la clase donde se asignan las funciones de los botones
	 */
	
	public void setListener(PersonaListener listener) {
		btnDatos.addActionListener(listener);
		btnCancel.addActionListener(listener);
		btnLimpiar.addActionListener(listener);
		
	}

	/**
	 * Este metodo sirve borrar todo lo que se haya escrito en los textField dandole valor null
	 */
	
	public void limpiarDatos() {
		txtNombre.setText(null);
		txtApellido1.setText(null);
		txtApellido2.setText(null);
		txtDNI.setText(null);
	}

	
}