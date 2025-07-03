package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglo.ArregloUsuarios;
import base_de_datos.ClienteBD;
import base_de_datos.ProductoBD;
import base_de_datos.ProveedorBD;
import base_de_datos.UsuarioBD;
import clase.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VRegistro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton btnIniciarSesión;
	
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

	public VRegistro() {
		setTitle("Inicio de sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 37, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 90, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(147, 36, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(147, 89, 86, 20);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		btnIniciarSesión = new JButton("Iniciar sesión");
		btnIniciarSesión.addActionListener(this);
		btnIniciarSesión.setBounds(38, 158, 131, 23);
		contentPane.add(btnIniciarSesión);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setBounds(198, 158, 131, 23);
		contentPane.add(btnRegistrarse);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarse) {
			do_btnRegistrarse_actionPerformed(e);
		}
		if (e.getSource() == btnIniciarSesión) {
			do_btnIniciarSesión_actionPerformed(e);
		}
	}
	UsuarioBD usuarioBD = new UsuarioBD();
	
	private int intentosFallidos = 0;
	
	private JButton btnRegistrarse;
	
	protected void do_btnIniciarSesión_actionPerformed(ActionEvent e) {
		String usuario = txtUsuario.getText().toUpperCase().trim();
	    String clave = new String(txtContraseña.getText()).toUpperCase().trim();

	    if (usuario.isEmpty() || clave.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña.");
	        return;
	    }

	    boolean acceso = usuarioBD.verificarUsuario(usuario, clave);

	    if (acceso) {
	        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
	        VProducto ventana = new VProducto();
	        ventana.setVisible(true);
	     // Accedemos directamente a los TextArea de VProducto
	        ProductoBD productoBD = new ProductoBD();
	        ProveedorBD proveedorBD = new ProveedorBD();
	        ClienteBD clienteBD = new ClienteBD();

	        ventana.txtS.setText(productoBD.listarProductos());
	        ventana.txtS2.setText(clienteBD.listarClientes());
	        ventana.txtS3.setText(proveedorBD.listarProveedores());
	        this.dispose();  // cerrar la ventana de login
	    } else {
	        intentosFallidos++;
	        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Intento " + intentosFallidos + " de 3");

	        if (intentosFallidos >= 3) {
	            JOptionPane.showMessageDialog(null, "Demasiados intentos fallidos. El programa se cerrará.");
	            System.exit(0); // cerrar la aplicación
	        }
	    }
	}
	protected void do_btnRegistrarse_actionPerformed(ActionEvent e) {
		String u = txtUsuario.getText().trim();
	    String c = txtContraseña.getText().trim();

	    if (u.isEmpty() || c.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña.");
	        return;
	    }

	    if (usuarioBD.registrarUsuario(u, c)) {
	        JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
	        txtUsuario.setText("");
	        txtContraseña.setText("");
	    } else {
	        JOptionPane.showMessageDialog(this, "Error: usuario ya registrado o problema de conexión.");
	    }
	}
}
