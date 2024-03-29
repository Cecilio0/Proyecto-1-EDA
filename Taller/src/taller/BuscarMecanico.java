/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package taller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class BuscarMecanico extends javax.swing.JFrame {

    Mecanico[] mecanicos;
    Cliente[] clientes;
    DecimalFormat formato;

    /**
     * Creates new form BuscarMecanico
     */
    public BuscarMecanico() {
        initComponents();

        clientes = new Cliente[0];
        mecanicos = new Mecanico[0];

        cargarFicheros();
        setResizable(false);
    }

    public void cargarFicheros() {
        try {
            FileInputStream fis = new FileInputStream("Clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientes = (Cliente[]) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileInputStream fis = new FileInputStream("Mecanicos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mecanicos = (Mecanico[]) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardarFicheros() {
        try {
            FileOutputStream fos = new FileOutputStream("Clientes.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileOutputStream fos = new FileOutputStream("Mecanicos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mecanicos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mecanicoId = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("BUSCAR MEC�NICO");

        jLabel2.setText("ID Mec�nico:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(botonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mecanicoId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mecanicoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(botonBuscar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        Administrador a = new Administrador();
        String idMecanico = mecanicoId.getText().trim();
        
        formato = new DecimalFormat("#,###.00");
        jTextPane1.setText("");
        if (a.existeId(idMecanico)) {
            Mecanico m = null;
            try {
                m = a.buscarMecanico(idMecanico);
            } catch (Administrador.ENoExiste ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Administrador.EVectorNulo ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            String[] info = new String[2];
            String estado = "Activo";
            info[0] = ("----------INFORMACI�N PERSONAL----------\nNombre: " + m.getNombre() + "\n�mero de C�dula: " + m.getCedula() + "\nTel�fono: " + m.getTelefono() + "\nDirecci�n: " + m.getDireccion() + "\nCorreo: " + m.getCorreo() + "\nEstado: " + estado + "\n\n");
            info[1] = ("----------INFORMACI�N TRABAJOS----------\n");
            for (int i = 0; i < clientes.length; i++) {
                for (int j = 0; j < clientes[i].getVehiculos().length; j++) {
                    for (int k = 0; k < clientes[i].getVehiculos()[j].getHistorial().length; k++) {
                        if (clientes[i].getVehiculos()[j].getHistorial()[k].getMecanico().getId().equalsIgnoreCase(idMecanico)) {
                            info = Arrays.copyOf(info, info.length + 1);
                            info[info.length - 1] = ("\nPlaca: " + clientes[i].getVehiculos()[j].getPlaca() + "\nAcci�n: " + clientes[i].getVehiculos()[j].getHistorial()[k].getAccion() + "\nPrecio: " + formato.format(clientes[i].getVehiculos()[j].getHistorial()[k].getPrecio()) + "\nFecha: " + getFechaFormat(clientes[i].getVehiculos()[j].getHistorial()[k].getFechaIngreso())+"\n");
                        }
                    }
                }
            }

            for (int i = 0; i < info.length; i++) {
                jTextPane1.setText(jTextPane1.getText() + info[i]);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Mec�nico no encontrado: ID " + idMecanico);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    public String getFechaFormat(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField mecanicoId;
    // End of variables declaration//GEN-END:variables
}
