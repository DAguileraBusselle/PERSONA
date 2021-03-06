package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.PersonaListener;
import model.Persona;

/**
 * Esta clase sirve para crear la ventana que se utilizar? para modificar los datos de un objeto 
 * persona de la base de datos
 * 
 * @author Rivas12
 * @version 0.1
 * @since 26.09.2021
 *
 */

public class VModificar extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declara una constante para el btnModificar
	 */
	public static String BTN_MODIF = "Guardar modificaciones";
	
	/**
	 * Declara una constante para el btnCancelar
	 */
	public static String BTN_CANCELAR = "Cancelar";
	
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
	 * Este boton modifica  los datos de un objeto persona en la base de datos
	 */
	private JButton btnModif;
	
	/**
	 * Este boton cierra la ventana VModificar
	 */
	private JButton btnCancelar;
	
	
	/**
	 *En este metodo se encuentran todos los metodos que utilizar? la clase VModificar
	 */
	public VModificar() {
		init();
	}

	/**
	 *  Este metodo crea los componentes de la interfaz de VModificar
	 */
	private void init() {
		getContentPane().setLayout(null);
		
		setSize(VPersona.ANCHO-100, VPersona.ALTO-270);
	
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VPersona.ANCHO-30, VPersona.ALTO-70);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(38, 114, 107, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(38, 80, 86, 26);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("Primer Apellido");
		lblApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido1.setBounds(205, 86, 107, 14);
		getContentPane().add(lblApellido1);
		
		txtApellido1 = new JTextField();
		txtApellido1.setBounds(202, 114, 121, 20);
		getContentPane().add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.setBounds(376, 114, 115, 20);
		getContentPane().add(txtApellido2);
		txtApellido2.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido2.setBounds(379, 86, 112, 14);
		getContentPane().add(lblApellido2);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(547, 114, 115, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(547, 86, 46, 14);
		getContentPane().add(lblDNI);
		
		btnModif = new JButton(BTN_MODIF);
		btnModif.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModif.setBounds(230, 188, 194, 23);
		getContentPane().add(btnModif);
		
		btnCancelar = new JButton(BTN_CANCELAR);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(542, 188, 107, 23);
		getContentPane().add(btnCancelar);
	}
	
	/**
	 * Este metodo sirve para hacer visible un objeto
	 * 
	 */
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	
	/**
	 * Este metodo recoge el String nombre del JTextField txtNombre

	 * @return nombre
	 */
	
	public String getNombreModif() {
		String nombre = txtNombre.getText().trim();
		return nombre;
	}
	
	/**
	 * Este metodo recoge el String apellido1 del JTextField txtApellido1
	 * 
	 * @return apellido1
	 */
	
	public String getApe1Modif() {
		String ape1 = txtApellido1.getText().trim();
		return ape1;
	}
	
	/**
	 * Este metodo recoge el String apellido2 del JTextField txtApellido1
	 * 
	 * @return apellido2
	 */
	
	public String getApe2Modif() {
		String ape2 = txtApellido2.getText().trim();
		return ape2;
	}
	
	/**
	 * Este metodo recoge el String dni del JTextField txtDNI
	 * 
	 * @return dni
	 */
	
	public String getDNIModif() {
		String dni = txtDNI.getText().trim();
		return dni;
	}
	
	/**
	 * Este metodo sirve para mostrar un mensaje de error a trav?s de otra ventana que se 
	 * introduce como parametro
	 *
	 * @param msj mensaje que quieres mostrar
	 */
	
	public void mostrarMsjError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Este metodo sirve para mostrar un mensaje de informaci?n a trav?s de otra ventana que se 
	 * introduce como parametro
	 * 
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
		btnModif.addActionListener(listener);
		btnCancelar.addActionListener(listener);
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
 
	/**
	 * Este metodo sirve para hacer que un objeto deje de ser visible
	 * 
	 */
	
	public void hacerInvisible() {
		setVisible(false);
	}
	
	/**
	 * Este metodo recoge los datos de cada objeto persona del ArrayList
	 * 
	 * @param listaPersonas ArrayList donde estan todos los objetos persona
	 */
	public void cargarDatosRegistro(ArrayList<Persona> listaPersonas) {
		
		
		for (Persona persona : listaPersonas) {
		
			
			txtNombre.setText(persona.getNombre());
			txtApellido1.setText(persona.getApellido1());
			txtApellido2.setText(persona.getApellido2());
			txtDNI.setText(persona.getDni());
		
			PersonaListener.ID_SELECT = persona.getID();
			
		}	
		
		
	}
}