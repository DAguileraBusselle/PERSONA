package main;

import java.awt.EventQueue;

import control.PersonaListener;
import view.VAniadir;
import view.VModificar;
import view.VPersona;

/***
 * Esta es la clase Inicio con el metodo main que se encarga de inicializar la aplicacion
 * Carga las ventanas en el listener e inicia los listener de las ventanas, a parte de hacer visible de inicio la ventana principal
 * 
 * @author DAguilerBusselle
 * @since 09/30/2021
 * 
 * @version 0.1
 */

public class Inicio {
	
	/***
	 * @param args El parametro para el funcionamento del main
	 * 
	 * Este es el metodo main, que como ya se menciono anteriormente inicia la aplicacion junto con enlazar los listeners correspondientes
	 *  
	 */
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VPersona vp = new VPersona();
				VAniadir va = new VAniadir();
				VModificar vm = new VModificar();
				
				PersonaListener listener = new PersonaListener(vp, va, vm);
				
				vp.setListener(listener);
				va.setListener(listener);
				vm.setListener(listener);
				
				vp.hacerVisible();				
			}
		});
	}
 
}
