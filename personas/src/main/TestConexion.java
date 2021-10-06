package main;

import java.sql.SQLException;

import db.AccesoDB;


/***
 * Esta es la clase Testconexion que se encarga de probar la conexion y lanzar excepciones en caso de 
 * no poder establecerla y explicar la razon
 * 
 * @author DAguileraBusselle
 * @since 09/30/2021
 * 
 * @version 0.1
 *
 */

public class TestConexion {

	/***
	 * @param args
	 *  
	 * Este es el metodo main que como ya se ha mencionado se encargada de comprobar el estado de la
	 * conexion con la base de datos, separado del Inicio de la aplicacion.
	 *  
	 */
	
	public static void main(String[] args) {
		AccesoDB adb = new AccesoDB();
		
		try {
			adb.getConexion();
		} catch (ClassNotFoundException e) {
			System.out.println("El driver no es correcto");
		} catch (SQLException e) {
			System.out.println("La url no es correcta");
		}

	}

}