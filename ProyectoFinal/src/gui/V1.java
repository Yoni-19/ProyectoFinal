package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Producto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtCod;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(37, 30, 55, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setBounds(37, 65, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio: ");
		lblNewLabel_2.setBounds(37, 101, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Stock:");
		lblNewLabel_3.setBounds(37, 135, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNom = new JTextField();
		txtNom.setBounds(93, 27, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtCod = new JTextField();
		txtCod.setBounds(93, 62, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(93, 98, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(93, 132, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(224, 61, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 165, 276, 102);
		contentPane.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String nom = txtNom.getText();
		String cod = txtCod.getText();
		double precio = Double.parseDouble(txtPrecio.getText());
		int stock = Integer.parseInt(txtStock.getText());
		Producto prod = new Producto(cod, nom, precio, stock);
		
	}
}
