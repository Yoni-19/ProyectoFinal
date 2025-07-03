package conexión;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexiónMySQL {
	public static Connection getConexion() {
		Connection cnx = null;
		try {
			//Adjuntar driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver correcto");
			//Inicializa la conexion
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/MINIMARKET","root","mysql");
			System.out.println("Conexion correcta");
		} catch (Exception e) {
			System.out.println("Error"+e);
		}
		return cnx;
	}
	public static void main(String[] args) {
       getConexion();
	}

}
