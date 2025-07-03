package base_de_datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import clase.Cliente;
import clase.Pedido;
import conexión.ConexiónMySQL;

public class ClienteBD {
	public void insertarCliente(Cliente c) {
        String sql = "CALL sp_InsertarCliente(?, ?, ?)";

        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }
	public Cliente buscarCliente(String id) {
	    String sql = "CALL sp_BuscarCliente(?)";
	    try (Connection cn = ConexiónMySQL.getConexion();
	         PreparedStatement ps = cn.prepareStatement(sql)) {

	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return new Cliente(rs.getString("id_Cli"), rs.getString("nombre"), rs.getString("apellido"));
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al buscar cliente: " + e.getMessage());
	    }
	    return null;
	}
	public String listarClientes() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("ID\tNombre\tApellido\tProducto\tCantidad\n");

	    String sql = "CALL sp_ListarCliente()";

	    try (Connection cn = ConexiónMySQL.getConexion();
	         PreparedStatement ps = cn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            sb.append(rs.getString("id_Cli")).append("\t")
	              .append(rs.getString("nombre")).append("\t")
	              .append(rs.getString("apellido")).append("\t")
	              .append(rs.getString("productoDeseado") != null ? rs.getString("productoDeseado") : "-").append("\t")
	              .append(rs.getInt("cantidad")).append("\n");
	        }

	    } catch (SQLException e) {
	        sb.append("Error: ").append(e.getMessage());
	    }

	    return sb.toString();
	}
}
