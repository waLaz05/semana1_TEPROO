package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

// Clase de conexion a la Base de Datos my SQL
public class ConexionMySQL {
	public static Connection getConexion() {
		Connection cnx = null;
		try {
			// cargamos driver JDBC de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establecemos la conexcion de esta forma:
			cnx = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/BD_2026", "root", "mysql");
		} catch (Exception e) {
			System.out.println("Error de conexion: " + e.getMessage());
		}
		return cnx;
	}
}
