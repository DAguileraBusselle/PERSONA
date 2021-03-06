package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

/**
 * Clase que se encarga de realizar la conexi?n con la base de datos
 * para que podamos acceder a sus datos
 *
 * @version 4.17.0, 30/09/21
 * @author Jorgea9
 */

public class AccesoDB {

	private String driver;
	private String url;
	
	/**
	 * Metodo encargado de obtener la url y el driver de la base de datos
	 * 
	 */
	
	public AccesoDB() {
		
		FileInputStream fis = null;
		Properties prop = new Properties();
		
		try {
			fis = new FileInputStream("config.properties");
			
			prop.load(fis);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
	}
	
	/**
	 * M?todo encargado de realizar la conexi?n con la base de datos
	 * 
	 * @return con es el resultado de la conexi?n con la base de datos
	 * 
	 * @throws ClassNotFoundException excepcion en caso de que hay alg?n problema
	 * con la conexi?n a la base de datos
	 * 
	 * @throws SQLException excepcion en caso de que hay alg?n problema
	 * con la conexi?n a la base de datos
	 */
	
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		
		Connection con = DriverManager.getConnection(url, config.toProperties());
		System.out.println("Conexi?n establecida con la BBDD");
		
		return con;

	}
	
	
}