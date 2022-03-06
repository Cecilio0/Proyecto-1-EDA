package taller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taller.Administrador.ENoExiste;
import taller.Administrador.EVectorNulo;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MantenimientoGeneral extends JFrame {

	private JPanel contentPane;
	private JTextField txtMecanico;
	private JTextField txtPlaca;
	private JTextField txtCedula;
	private JButton btnMant;
	private JLabel lblCedula;
	private JLabel lblPlaca;
	private JLabel lblMecanico;
	private Administrador admin = new Administrador();

	public MantenimientoGeneral() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setResizable(false);
		inicializar();
		setTitle("Mantenimiento General");
		
		
	}
	
	public void inicializar() {
		
		btnMant = new JButton("Hacer Mantenimiento");
		btnMant.setBounds(116, 186, 159, 21);
		btnMant.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btnMantActionPerformed(e);
			}
		});
		contentPane.add(btnMant);
		
		txtMecanico = new JTextField();
		txtMecanico.setBounds(179, 144, 96, 19);
		contentPane.add(txtMecanico);
		txtMecanico.setColumns(10);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(179, 115, 96, 19);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(179, 86, 96, 19);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		lblCedula = new JLabel("Cedula: ");
		lblCedula.setBounds(91, 89, 62, 13);
		contentPane.add(lblCedula);
		
		lblPlaca = new JLabel("Placa: ");
		lblPlaca.setBounds(91, 118, 45, 13);
		contentPane.add(lblPlaca);
		
		JLabel lblMecanico = new JLabel("Id Mecanico: ");
		lblMecanico.setBounds(91, 147, 78, 13);
		contentPane.add(lblMecanico);
	}
	
	private void btnMantActionPerformed(java.awt.event.ActionEvent e) {
		if (!txtCedula.getText().isEmpty() && !txtMecanico.getText().isEmpty() && !txtPlaca.getText().isEmpty()) {
			try {
				String [] aux = admin.mantenimientoGeneral(txtCedula.getText(), txtPlaca.getText(), txtMecanico.getText());
				String info = "";
				for (int i = 0; i < aux.length; i++) {
					if (aux[i] != null) {
						info += aux[i] + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, info);
				this.dispose();
			} catch (ENoExiste e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (EVectorNulo e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
		}
		
	}
	
	
}
