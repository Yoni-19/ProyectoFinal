package base_de_datos;
import java.sql.*;
import conexión.ConexiónMySQL;

public class UsuarioBD {
	public boolean verificarUsuario(String nombre, String contraseña) {
        String sql = "CALL sp_VerificarUsuario(?, ?)";

        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // Si encuentra, es válido
        } catch (SQLException e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
        }
        return false;
    }

	public boolean registrarUsuario(String nombre, String contrasena) {
        String sql = "CALL sp_InsertarUsuario(?, ?)";

        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, contrasena);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
}
