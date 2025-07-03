package base_de_datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexión.ConexiónMySQL;
import clase.Producto;

public class ProductoBD {
	 // Insertar producto usando procedimiento almacenado
    public void insertarProducto(Producto p) {
        String sql = "CALL sp_InsertarProducto(?, ?, ?, ?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());

            ps.executeUpdate();
            System.out.println("Producto insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
    }

    // Modificar precio
    public void modificarPrecio(String codigo, double nuevoPrecio) {
        String sql = "CALL sp_ModificarPrecio(?, ?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.setDouble(2, nuevoPrecio);
            ps.executeUpdate();

            System.out.println("Precio actualizado");
        } catch (SQLException e) {
            System.out.println("Error al modificar precio: " + e.getMessage());
        }
    }

    // Eliminar producto
    public void eliminarProducto(String codigo) {
        String sql = "CALL sp_EliminarProducto(?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.executeUpdate();

            System.out.println("Producto eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    // Buscar producto por código (crea este SP si no lo tienes)
    public Producto buscarProducto(String cod) {
        String sql = "CALL sp_BuscarProductoPorCodigo(?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Producto(
                    rs.getString("cod_Prod"),
                    rs.getString("nom_Prod"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return null;
    }
    public Producto buscarProductoPorNombre(String nombre) {
        String sql = "CALL sp_BuscarProductoPorNombre(?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Producto(
                    rs.getString("cod_Prod"),
                    rs.getString("nom_Prod"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return null;
    }

    public void descontarStock(String cod, int cantidad) {
        String sql = "CALL sp_ReducirStockProducto(?, ?)";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, cantidad);
            ps.setString(2, cod);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al descontar stock: " + e.getMessage());
        }
    }
    // Listar productos
    public String listarProductos() {
    	StringBuilder sb = new StringBuilder("COD\tNOMBRE\tPRECIO\tSTOCK\n");

        String sql = "CALL sp_ListarProductos()";
        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sb.append(rs.getString("cod_Prod")).append("\t")
                  .append(rs.getString("nom_Prod")).append("\t")
                  .append(rs.getDouble("precio")).append("\t")
                  .append(rs.getInt("stock")).append("\n");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return sb.toString();
    }
   
    public void agregarStock(String codProducto, int cantidad) {
        String sql = "CALL sp_AgregarStockProducto(?, ?)";

        try (Connection cn = ConexiónMySQL.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, codProducto);
            ps.setInt(2, cantidad);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar stock: " + e.getMessage());
        }
    }
    
}
