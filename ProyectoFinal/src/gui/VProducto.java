package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglo.ArregloCliente;
import Arreglo.ArregloProducto;
import Arreglo.ArregloProveedor;
import Arreglo.ArregloUsuarios;
import base_de_datos.ClienteBD;
import base_de_datos.ProductoBD;
import base_de_datos.ProveedorBD;
import clase.Cliente;
import clase.Pedido;
import clase.Producto;
import clase.Proveedor;
import conexión.ConexiónMySQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VProducto extends JFrame implements ActionListener {
	public JTextArea txtS, txtS2, txtS3;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtCod;
	private JTextField txtPrecio;
	private JButton btnAgregar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistro frame = new VRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VProducto() {
		
		setTitle("Software Minimarket Santa Rosa");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1119, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(21, 238, 55, 14);
		contentPane.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(77, 235, 86, 20);
		contentPane.add(txtNom);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(77, 181, 86, 20);
		contentPane.add(txtCod);
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setBounds(21, 184, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio: ");
		lblNewLabel_2.setBounds(21, 285, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(77, 282, 86, 20);
		contentPane.add(txtPrecio);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(279, 168, 128, 23);
		contentPane.add(btnAgregar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(279, 315, 128, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 422, 321, 309);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(965, 11, 128, 23);
		contentPane.add(btnSalir);
		
		btnModificar = new JButton("Modificar precio");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(279, 238, 128, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(279, 276, 128, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel_4 = new JLabel("Menú principal");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(333, 11, 216, 43);
		contentPane.add(lblNewLabel_4);
		
		realizarEncargo = new JButton("Realizar Encargo");
		realizarEncargo.addActionListener(this);
		realizarEncargo.setBounds(688, 127, 128, 23);
		contentPane.add(realizarEncargo);
		
		JLabel lblNewLabel_5 = new JLabel("Ingrese datos del producto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 122, 258, 25);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Opciones");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(300, 126, 107, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Menú de clientes");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(520, 79, 177, 25);
		contentPane.add(lblNewLabel_5_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(533, 181, 524, 216);
		contentPane.add(scrollPane_1);
		
		txtS2 = new JTextArea();
		scrollPane_1.setViewportView(txtS2);
		
		registrar_Cliente = new JButton("Registrar Cliente");
		registrar_Cliente.addActionListener(this);
		registrar_Cliente.setBounds(530, 124, 127, 23);
		contentPane.add(registrar_Cliente);
		
		JLabel lblNewLabel_5_2 = new JLabel("Menú de proveedores");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_2.setBounds(520, 419, 275, 25);
		contentPane.add(lblNewLabel_5_2);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(520, 496, 524, 216);
		contentPane.add(scrollPane_1_1);
		
		txtS3 = new JTextArea();
		scrollPane_1_1.setViewportView(txtS3);
		
		btnRegistrar_Proveedor = new JButton("Registrar Proveedor");
		btnRegistrar_Proveedor.addActionListener(this);
		btnRegistrar_Proveedor.setBounds(533, 455, 137, 23);
		contentPane.add(btnRegistrar_Proveedor);
		
		btnEliminar_Proveedor = new JButton("Eliminar Proveedor");
		btnEliminar_Proveedor.addActionListener(this);
		btnEliminar_Proveedor.setBounds(691, 455, 155, 23);
		contentPane.add(btnEliminar_Proveedor);
		
		btnNewButton = new JButton("Añadir Stock");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(279, 202, 128, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5_3 = new JLabel("Lista de productos");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_3.setBounds(31, 386, 193, 25);
		contentPane.add(lblNewLabel_5_3);
		
		btnNewButton_1 = new JButton("Registro de ventas");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(49, 29, 164, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar cliente");
		btnNewButton_2.setBounds(849, 127, 137, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modificar Proveedor");
		btnNewButton_3.setBounds(870, 455, 142, 23);
		contentPane.add(btnNewButton_3);
		
		
	}
	
	ProductoBD productoBD = new ProductoBD();
	ProveedorBD proveedorBD = new ProveedorBD();
	ClienteBD clienteBD = new ClienteBD();
	
	private JButton btnSalir;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel_6;
	private JButton realizarEncargo;
	private JButton registrar_Cliente;
	private JButton btnRegistrar_Proveedor;
	private JButton btnEliminar_Proveedor;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar_Proveedor) {
			do_btnEliminar_Proveedor_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar_Proveedor) {
			do_btnRegistrar_Proveedor_actionPerformed(e);
		}
		if (e.getSource() == registrar_Cliente) {
			do_Registrar_Cliente_actionPerformed(e);
		}
		if (e.getSource() == realizarEncargo) {
			do_RealizarEncargo_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}		
	}
	
	public void cargarDatosIniciales() {	
		ProductoBD productoBD = new ProductoBD();
	    ProveedorBD proveedorBD = new ProveedorBD();
	    ClienteBD clienteBD = new ClienteBD();
	    
	    txtS.setText(productoBD.listarProductos());
	    txtS2.setText(""+proveedorBD.listarProveedores());
	    txtS3.setText(clienteBD.listarClientes());
	}
		
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		String cod = txtCod.getText().trim();
		String nom = txtNom.getText().trim();
		String precioTexto = txtPrecio.getText().trim();

		// Validación de campos vacíos
		if (cod.isEmpty() || nom.isEmpty() || precioTexto.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Completa todos los campos.");
		    return;
		}

		// Validar existencia previa del producto
		Producto existente = productoBD.buscarProducto(cod);
		if (existente != null) {
		    JOptionPane.showMessageDialog(null, "Ya existe un producto con ese código.");
		    return;
		}

		try {
		    double precio = Double.parseDouble(precioTexto);
		    if (precio <= 0) {
		        JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0.");
		        return;
		    }

		    // Creamos el producto con stock = 0
		    Producto nuevo = new Producto(cod, nom, precio, 0);
		    productoBD.insertarProducto(nuevo);

		    JOptionPane.showMessageDialog(null, "Producto registrado con stock inicial 0.");
		    txtS.setText(productoBD.listarProductos());
		    txtCod.setText("");
		    txtNom.setText("");
		    txtPrecio.setText("");

		} catch (NumberFormatException ex) {
		    JOptionPane.showMessageDialog(null, "Precio inválido.");
		}
		
	}
	public void limpiarCampos() { //Limpia las cajas de texto
		txtCod.setText("");
		txtNom.setText("");
		txtPrecio.setText("");
	}	
	protected void do_btnSalir_actionPerformed(ActionEvent e) { //Cierra el programa
		dispose();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		
		String cod = JOptionPane.showInputDialog(null, "Ingrese el código del producto a buscar:");
		if (cod == null || cod.trim().isEmpty()) return;

		Producto p = productoBD.buscarProducto(cod.trim());
		if (p == null) {
		    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
		} else {
		    String mensaje = "Código: " + p.getCodigo() + "\n" +
		                     "Nombre: " + p.getNombre() + "\n" +
		                     "Precio: " + p.getPrecio() + "\n" +
		                     "Stock: " + p.getStock();
		    JOptionPane.showMessageDialog(null, mensaje);
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		
		String cod = JOptionPane.showInputDialog(null, "Ingrese el código del producto:");
		if (cod == null || cod.trim().isEmpty()) return;

		Producto p = productoBD.buscarProducto(cod.trim());
		if (p == null) {
		    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
		    return;
		}

		String nuevoPrecioTexto = JOptionPane.showInputDialog(null, "Ingrese el nuevo precio:");
		if (nuevoPrecioTexto == null || nuevoPrecioTexto.trim().isEmpty()) return;

		try {
		    double nuevoPrecio = Double.parseDouble(nuevoPrecioTexto);
		    if (nuevoPrecio <= 0) {
		        JOptionPane.showMessageDialog(null, "El precio debe ser mayor que 0.");
		        return;
		    }

		    productoBD.modificarPrecio(cod.trim(), nuevoPrecio);
		    JOptionPane.showMessageDialog(null, "Precio actualizado correctamente.");
		    txtS.setText(productoBD.listarProductos()); // refrescar lista

		} catch (NumberFormatException ex) {
		    JOptionPane.showMessageDialog(null, "Precio inválido.");
		}
	}
	
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		String cod = JOptionPane.showInputDialog(null, "Ingrese el código del producto a eliminar:");
		if (cod == null || cod.trim().isEmpty()) return;

		Producto p = productoBD.buscarProducto(cod.trim());
		if (p == null) {
		    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
		    return;
		}

		int confirmacion = JOptionPane.showConfirmDialog(null,
		        "¿Está seguro de eliminar el producto " + p.getNombre() + "?", "Confirmar eliminación",
		        JOptionPane.YES_NO_OPTION);

		if (confirmacion == JOptionPane.YES_OPTION) {
		    productoBD.eliminarProducto(cod.trim());
		    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
		    txtS.setText(productoBD.listarProductos()); // refresca el JTextArea
		}
	}
	protected void do_RealizarEncargo_actionPerformed(ActionEvent e) {
		String idCliente = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente:");
	    if (idCliente == null || idCliente.trim().isEmpty()) return;

	    try (Connection cn = ConexiónMySQL.getConexion()) {
	        // 1. Buscar al cliente
	        String sqlCliente = "{CALL sp_BuscarCliente(?)}";
	        PreparedStatement psCliente = cn.prepareStatement(sqlCliente);
	        psCliente.setString(1, idCliente.trim());
	        ResultSet rsCliente = psCliente.executeQuery();

	        if (!rsCliente.next()) {
	            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
	            return;
	        }

	        String producto = rsCliente.getString("productoDeseado");
	        int cantidadDeseada = rsCliente.getInt("cantidad");

	        // 2. Buscar producto y stock usando procedimiento
	        String sqlBuscarProducto = "{CALL sp_BuscarProductoPorNombre(?)}";
	        PreparedStatement psProducto = cn.prepareStatement(sqlBuscarProducto);
	        psProducto.setString(1, producto);
	        ResultSet rsProducto = psProducto.executeQuery();

	        if (!rsProducto.next()) {
	            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
	            return;
	        }

	        String codProducto = rsProducto.getString("cod_Prod");
	        int stockActual = rsProducto.getInt("stock");

	        if (stockActual < cantidadDeseada) {
	            JOptionPane.showMessageDialog(null, "Stock insuficiente. Solo hay: " + stockActual);
	            return;
	        }

	        // 3. Descontar stock usando procedimiento
	        String sqlReducirStock = "{CALL sp_ReducirStockProducto(?, ?)}";
	        PreparedStatement psReducir = cn.prepareStatement(sqlReducirStock);
	        psReducir.setString(1, codProducto);
	        psReducir.setInt(2, cantidadDeseada);
	        psReducir.executeUpdate();

	        // 4. Eliminar cliente usando procedimiento
	        String sqlEliminarCliente = "{CALL sp_EliminarCliente(?)}";
	        PreparedStatement psEliminar = cn.prepareStatement(sqlEliminarCliente);
	        psEliminar.setString(1, idCliente.trim());
	        psEliminar.executeUpdate();

	        JOptionPane.showMessageDialog(null, "Encargo realizado. Stock actualizado y cliente eliminado.");

	        // 5. Actualizar interfaces
	        txtS.setText(productoBD.listarProductos());
	        txtS2.setText(clienteBD.listarClientes());

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	protected void do_Registrar_Cliente_actionPerformed(ActionEvent e) {
		String id = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente:");
	    if (id == null || id.trim().isEmpty()) return;

	    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
	    if (nombre == null || nombre.trim().isEmpty()) return;

	    String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del cliente:");
	    if (apellido == null || apellido.trim().isEmpty()) return;

	    String producto = JOptionPane.showInputDialog(null, "Ingrese el producto que desea:");
	    if (producto == null || producto.trim().isEmpty()) return;

	    String cantStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad:");
	    if (cantStr == null || cantStr.trim().isEmpty()) return;

	    int cantidad = 0;
	    try {
	        cantidad = Integer.parseInt(cantStr);
	        if (cantidad <= 0) throw new NumberFormatException();
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Cantidad inválida.");
	        return;
	    }

	    try (Connection cn = ConexiónMySQL.getConexion()) {
	        String sql = "{CALL sp_InsertarClientePedidoSimple(?, ?, ?, ?, ?)}";
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.setString(1, id.trim());
	        ps.setString(2, nombre.trim());
	        ps.setString(3, apellido.trim());
	        ps.setString(4, producto.trim());
	        ps.setInt(5, cantidad);

	        int filas = ps.executeUpdate();
	        if (filas > 0) {
	            JOptionPane.showMessageDialog(null, "Cliente registrado con su pedido.");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo registrar al cliente.");
	        }

	        // Mostrar clientes en txtS2 usando tu método
	        txtS2.setText(clienteBD.listarClientes());

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }	
	}
	protected void do_btnRegistrar_Proveedor_actionPerformed(ActionEvent e) {
		String id = JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor:");
	    if (id == null || id.trim().isEmpty()) return;

	    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del proveedor:");
	    if (nombre == null || nombre.trim().isEmpty()) return;

	    String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del proveedor:");
	    if (telefono == null || telefono.trim().isEmpty()) return;

	    String correo = JOptionPane.showInputDialog(null, "Ingrese el correo del proveedor:");
	    if (correo == null || correo.trim().isEmpty()) return;

	    try (Connection cn = ConexiónMySQL.getConexion()) {
	        String sql = "{CALL sp_InsertarProveedor(?, ?, ?, ?)}";
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.setString(1, id.trim());
	        ps.setString(2, nombre.trim());
	        ps.setString(3, telefono.trim());
	        ps.setString(4, correo.trim());

	        int filas = ps.executeUpdate();
	        if (filas > 0) {
	            JOptionPane.showMessageDialog(null, "Proveedor registrado correctamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo registrar el proveedor.");
	        }

	        // Actualizar la información en txtS3
	        txtS3.setText(proveedorBD.listarProveedores());

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	protected void do_btnEliminar_Proveedor_actionPerformed(ActionEvent e) {
		String id = JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor a eliminar:");
	    if (id == null || id.trim().isEmpty()) return;

	    boolean eliminado = proveedorBD.eliminarProveedor(id.trim());

	    if (eliminado) {
	        JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
	        // Mostrar el listado actualizado
	        txtS3.setText(proveedorBD.listarProveedores());
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontró el proveedor o no se pudo eliminar.");
	    }
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String idProveedor = JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor:");
		if (idProveedor == null || idProveedor.trim().isEmpty()) return;

		// Verifica si el proveedor existe
		Proveedor prov = proveedorBD.buscarPorId(idProveedor.trim());

		if (prov == null) {
		    JOptionPane.showMessageDialog(null, "Proveedor no encontrado. Debe registrarlo primero.");
		    return;
		}

		// Obtener el código del producto
		String codProd = JOptionPane.showInputDialog(null, "Ingrese el código del producto:");
		if (codProd == null || codProd.trim().isEmpty()) return;

		// Verifica si el producto existe
		ProductoBD productoBD = new ProductoBD();
		Producto p = productoBD.buscarProducto(codProd.trim());

		if (p == null) {
		    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
		    return;
		}

		// Solicita la cantidad de stock a agregar
		String cantidadTexto = JOptionPane.showInputDialog(null, "Ingrese la cantidad de stock a agregar:");
		if (cantidadTexto == null || cantidadTexto.trim().isEmpty()) return;

		try {
		    int cantidad = Integer.parseInt(cantidadTexto);
		    if (cantidad <= 0) {
		        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
		        return;
		    }

		    // Llamar al procedimiento que solo suma stock
		    productoBD.agregarStock(p.getCodigo(), cantidad);

		    JOptionPane.showMessageDialog(null, "Stock agregado correctamente.");
		    txtS.setText(productoBD.listarProductos()); // actualiza TextArea

		} catch (NumberFormatException ex) {
		    JOptionPane.showMessageDialog(null, "Cantidad inválida.");
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		VRegistroVentas Ventas = new VRegistroVentas();
        Ventas.setVisible(true);
	}
}

