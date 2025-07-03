package base_de_datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import clase.Proveedor;
import conexión.ConexiónMySQL;

public class ProveedorBD {
	public void insertarProveedor(Proveedor p) {
        String sql = "CALL sp_InsertarProveedor(?, ?, ?, ?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());

            ps.executeUpdate();
            System.out.println("Proveedor insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
        }
    }

	public String listarProveedores() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("ID\tNombre\tTeléfono\tCorreo\n");

	    String sql = "CALL sp_ListarProveedores()";

	    try (Connection cn = ConexiónMySQL.getConexion();
	         PreparedStatement ps = cn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            sb.append(rs.getString("id_Prov")).append("\t")
	              .append(rs.getString("nombre")).append("\t")
	              .append(rs.getString("telefono")).append("\t")
	              .append(rs.getString("correo")).append("\n");
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al listar proveedores: " + e.getMessage());
	    }

	    return sb.toString();
	}

    public Proveedor buscarPorId(String id) {
        String sql = "CALL sp_BuscarProveedor(?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Proveedor(
                    rs.getString("id_Prov"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar proveedor: " + e.getMessage());
        }
        return null;
    }
    public boolean eliminarProveedor(String id) {
        String sql = "CALL sp_EliminarProveedor(?)";

        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
            return false;
        }
    }
    
}
