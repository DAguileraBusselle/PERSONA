package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import db.PersonaPersistencia;
import view.VAniadir;
import view.VModificar;
import view.VPersona;

/**
 * @author Marta-D4
 *	@version 0.1
 *	@since 09/30/2021
 */

public class PersonaListener implements ActionListener{

	private VPersona vp;
	private VAniadir va;
	private VModificar vm;
	private PersonaPersistencia model;
	
	/**
	 * ID_SELECT: Variable que se inicializa como -1 y se encarga de almacenar 
	 * el id del registro pertinente de la base de datos 
	 */
	
	public static int ID_SELECT = -1;
	
	/**
	 * Constructor de la clase PersonaListener
	 * @param vp: de la clase VPersona
	 * @param va: de la clase VAniadir
	 * @param vm: de la clase VModificar
	 */
	
	public PersonaListener(VPersona vp, VAniadir va, VModificar vm) {
		this.vp = vp;
		this.va = va;
		this.vm = vm;
		model = new PersonaPersistencia();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equals(VPersona.BTN_CONSULTAR)) {
				vp.cargarTabla(model.cargarTabla());				
			}else if (ev.getActionCommand().equals(VPersona.BTN_ELIMINAR)) {
				model.deletePersona(vp.getPersonaSeleccionado());	
				vp.cargarTabla(model.cargarTabla());
			}else if (ev.getActionCommand().equals(VPersona.BTN_ANIADIR)) {
				va.limpiarDatos();
				va.hacerVisible();
			}else if (ev.getActionCommand().equals(VAniadir.BTN_DATOS)) {
				if (va.getNombreInsert().isEmpty() || va.getApe1Insert().isEmpty() || va.getApe2Insert().isEmpty() || va.getDNIInsert().isEmpty()) {
					va.mostrarMsjInfo("DEBE INTRODUCIR TODOS LOS DATOS");
				} else if (!isDNIValido(va.getDNIInsert())) {
					va.mostrarMsjInfo("DEBE INTRODUCIR UN DNI VALIDO");
				} else if (model.consultarPersonaDNIModif(va.getDNIInsert()) != null && ID_SELECT != model.consultarPersonaDNIExiste(va.getDNIInsert())){ 
					vm.mostrarMsjError("El DNI ya existe en la base de datos");
				} else {
				model.insertarPersona(va.getNombreInsert().trim(), va.getApe1Insert().trim(), va.getApe2Insert().trim(), va.getDNIInsert().trim());
				va.dispose();
				va.limpiarDatos();
				vp.cargarTabla(model.cargarTabla());
				}
				
			}else if (ev.getActionCommand().equals(VPersona.BTN_MODIFICAR)) {
				
				if (vp.isFilaSelect()) {
					vm.cargarDatosRegistro(model.consultarPersonaDNI(vp.getPersonaSeleccionado()));
					vm.hacerVisible();
					
					System.out.println(ID_SELECT);
				} else {
					vm.mostrarMsjError("Debe seleccionar un registro");
				}
					
			}else if (ev.getActionCommand().equals(VModificar.BTN_MODIF)) {
					if (vm.getNombreModif().isEmpty() || vm.getApe1Modif().isEmpty() || vm.getApe2Modif().isEmpty() || vm.getDNIModif().isEmpty()) {
						vm.mostrarMsjError("Debe introducir todos los datos");
						
					} else if (!isDNIValido(vm.getDNIModif())) {
						vm.mostrarMsjError("Debe introducir un DNI valido");
					} else if (model.consultarPersonaDNIModif(vm.getDNIModif()) != null && ID_SELECT != model.consultarPersonaDNIExiste(vm.getDNIModif())){ 
						vm.mostrarMsjError("El DNI ya existe en la base de datos");
					} else {
					
					int res = model.updatePersona(vm.getNombreModif(), vm.getApe1Modif(), vm.getApe2Modif(), vm.getDNIModif(), ID_SELECT);
					
					if (res == -1) {
						vm.mostrarMsjError("No se ha podido realizar la modificacion");
					} else {
						vm.mostrarMsjInfo("Se han guardado los cambios correctamente");
						vm.limpiarDatos();
						vm.dispose();
						vp.cargarTabla(model.cargarTabla());
					}
					
				}
			} else if (ev.getActionCommand().equals(VModificar.BTN_CANCELAR)) {
				int res = JOptionPane.showConfirmDialog(vm, "?Est?s seguro que quieres volver a la ventana de consulta?", "Confirmaci?n de salida", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					vm.dispose();
				}
			} else if (ev.getActionCommand().equals(VAniadir.BTN_CANCEL)) {
				int res = JOptionPane.showConfirmDialog(va, "?Est?s seguro que quieres volver a la ventana de consulta?", "Confirmaci?n de salida", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					va.dispose();
				}
			} else if (ev.getActionCommand().equals(VAniadir.BTN_LIMPIAR)) {
				va.limpiarDatos();
			}
				
		}
		
	}
	

	/**
	 * Metodo que retorna un booleano indicando si el dni introducido es v?lido
	 * @param dni: seleccionado para demostrar si es v?lido
	 * @return el dni es v?lido o no
	 */
	
	public boolean isDNIValido(String dni) {
		boolean isDNIValido = true; 
		
		
		if (dni.length() != 9) {
			isDNIValido = false;	
		} else {
			
			char char9 = dni.charAt(8);	
			String letra9 = String.valueOf(char9);
			
			if (!Character.isLetter(char9)) {
				isDNIValido = false;
			} else {
				if (!letra9.equals(letra9.toUpperCase())) {
					isDNIValido = false;
				}
			}
			
			
 			for (int i = 7; i >= 0; i--) {
				if (Character.isLetter(dni.charAt(i))) {
					isDNIValido = false;
				}
			}
			
			
		}
		
		
		return isDNIValido;
	}
	
}
