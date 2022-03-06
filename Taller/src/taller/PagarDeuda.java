package taller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taller.Administrador.ENoExiste;
import taller.Administrador.EVectorNulo;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PagarDeuda extends JFrame{

	private JPanel contentPane;
	private JTextField txtCedula;
	private JButton btnPagoDeuda;
	Administrador admin;

	public PagarDeuda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inicializar();
		
		setResizable(false);
		setTitle("Pagar Deuda");
		
		
	}
	
	public void inicializar() {
		admin = new Administrador();
		btnPagoDeuda = new JButton("Pagar Deuda");
		btnPagoDeuda.setBounds(177, 140, 96, 21);
		btnPagoDeuda.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btnPagoDeudaActionPerformed(e);
			}
		});
		contentPane.add(btnPagoDeuda);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(177, 111, 96, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula: ");
		lblCedula.setBounds(128, 115, 45, 13);
		contentPane.add(lblCedula);
	}

	private void btnPagoDeudaActionPerformed(java.awt.event.ActionEvent e) {
		String info = "";
		try {
			String [] aux = admin.pagoDeuda(txtCedula.getText());
			for (int i = 0; i < aux.length; i++) {
				info += aux[i] + "\n";
			}
			JOptionPane.showMessageDialog(null, info);
		} catch (ENoExiste e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (EVectorNulo e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} finally {
			setVisible(false);
		}
	}
}
