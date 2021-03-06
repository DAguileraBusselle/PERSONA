package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Persona;

/**
 * Clase encargada de almacenar los métodos con las distintas query
 * que vamos a usar para realizar distintas acciones con la
 * base de datos.
 *
 * @version 4.17.0, 30/09/21
 * @author Jorgea9
 *
 */

public class PersonaPersistencia {

	private AccesoDB adb;
	
	/**
	 * Inicializacion de la conexion a la base de datos para el resto de la clase de persistencia
	 */
	
	public PersonaPersistencia() {
		adb = new AccesoDB();
	}
	
	/**
	 * Método encargado de mostrar la información de la persona
	 * cuyo DNI sea el pasado por parámetro.
	 * 
	 * @param dniSearch numero de dni obtenido de la base de datos
	 * @return listaPersonas lista con la información de todas las personas de la base de datos.
	 */
	
	public ArrayList<Persona> consultarPersonaDNI(String dniSearch) {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		
		String query = "SELECT ID, NOMBRE, APELLIDO1, APELLIDO2, DNI FROM PERSONAS "
				+ "WHERE DNI = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			
			///
			pstmt.setString(1, dniSearch);
			///
			
			rslt = pstmt.executeQuery();
			
			int id;
			String nom;
			String ap1;
			String ap2;
			String dni;
			
			while (rslt.next()) {
				
				id = rslt.getInt(1);
				nom = rslt.getString(2);
				ap1 = rslt.getString(3);
				ap2 = rslt.getString(4);
				dni = rslt.getString(5);
 				
				
				listaPersonas.add(new Persona(id, nom, ap1, ap2, dni));
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaPersonas;
		
	}
	
	/**
	 * Método que muestra el nombre de la persona 
	 * cuyo DNI es el que se pasa por parámetro.
	 *
	 * @param dniSearch numero de dni pasado por parámetro
	 * @return nombre es el nombre de la persona
	 */
	
	public String consultarPersonaDNIModif(String dniSearch) {
		String nombre = null;
		String query = "SELECT NOMBRE FROM PERSONAS "
				+ "WHERE DNI = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			
			///
			pstmt.setString(1, dniSearch);
			///
			
			rslt = pstmt.executeQuery();
			
			
			while (rslt.next()) {
				
				nombre = rslt.getString(1);				
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nombre;
		
	}
	
	/**
	 * Método encargado de mostrar el ID de la persona 
	 * cuyo DNI es el pasado por parámetro
	 * 
	 * @param dniSearch numero de DNI pasado por parametro
	 * @return id es el id de la persona
	 */
	
	public int consultarPersonaDNIExiste(String dniSearch) {
		int id = 0;
		String query = "SELECT ID FROM PERSONAS "
				+ "WHERE DNI = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			
			///
			pstmt.setString(1, dniSearch);
			///
			
			rslt = pstmt.executeQuery();
			
			
			while (rslt.next()) {
				
				id = rslt.getInt(1);				
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
		
	}
	
	/**
	 * Metodo que se encarga de sacar la información de las personas
	 * para posteriormente mostrarlas en la tabla.
	 * 
	 * @return listaPersonas es la lista con la información 
	 * de todas las personas en la base de datos
	 */
	
	public ArrayList<Persona> cargarTabla() {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		String query = "SELECT NOMBRE, APELLIDO1, APELLIDO2, DNI FROM PERSONAS";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		try {
			con = adb.getConexion();
			
			stmt = con.createStatement();
			
			rslt = stmt.executeQuery(query);
			
			String nom;
			String ap1;
			String ap2;
			String dni;
			
			while (rslt.next()) {
				nom = rslt.getString(1);
				ap1 = rslt.getString(2);
				ap2 = rslt.getString(3);
				dni = rslt.getString(4);
				
				listaPersonas.add(new Persona(-1, nom, ap1, ap2, dni));
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Problemas con el driver");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaPersonas;
		
	}
	
	/**
	 * Método encargado de borrar la persona cuyo dni se pasa por parámetro
	 *
	 * @param dni es el numero de dni pasado por parámetro
	 * @return res es el numero entero resultado de la operación de borrado
	 */
	
	public int deletePersona(String dni) {
		String query = "DELETE FROM PERSONAS WHERE DNI = ?";
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, dni);
			
			res = pstmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			res = -1;
			e.printStackTrace();
			
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	/**
	 * Método encargado de insertar una persona con los datos pasados por parámetro
	 * 
	 * @param nombre es el nombre de la persona 
	 * @param apellido1 es el primer apellido de la persona 
	 * @param apellido2 es el segundo apellido de la persona
	 * @param dni es el numero de DNI de la persona 
	 * @return res es el resultado entero obtenido de la operación de inserción
	 */
	
	public int insertarPersona(String nombre, String apellido1, String apellido2, String dni) {
		
		String query = "INSERT INTO PERSONAS (NOMBRE, APELLIDO1, APELLIDO2, DNI)"
				+ "VALUES (?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido1);
			pstmt.setString(3, apellido2);
			pstmt.setString(4, dni);
			
			res = pstmt.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			res = -1;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
		
		
	}

	/**
	 * Método encargado de actualizar/modificar información de las 
	 * personas en la base de datos
	 * 
	 * @param nombreModif es el nuevo nombre ya modificado
	 * @param ape1Modif es el nuevo primer apellido ya modificado
	 * @param ape2Modif es el nuevo segundo apellido ya modificado
	 * @param dniModif es el nuevo número de DNI ya modificado
	 * @param iD_SELECT es el id de la persona de la cual queremos modificar la información
	 * @return res es el resultado entero de la operación de modificación 
	 */
	
	public int updatePersona(String nombreModif, String ape1Modif, String ape2Modif, String dniModif, int iD_SELECT) {
		int res = 0;
		
		String query = "UPDATE PERSONAS SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ?, DNI = ? "
				+ "WHERE ID = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, nombreModif);
			pstmt.setString(2, ape1Modif);
			pstmt.setString(3, ape2Modif);
			pstmt.setString(4, dniModif);
			pstmt.setInt(5, iD_SELECT);
			
			res = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			res = -1;
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	
	
}