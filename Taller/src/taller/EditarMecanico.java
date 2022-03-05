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
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class EditarMecanico extends javax.swing.JFrame {

    Mecanico[] mecanicos;
    Cliente[] clientes;

    /**
     * Creates new form EditarMecanico
     */
    public EditarMecanico() {
        initComponents();

        clientes = new Cliente[0];
        mecanicos = new Mecanico[0];

        cargarFicheros();
        botonActualizar.setEnabled(false);
        botonDespedir.setEnabled(false);
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
        mecanicoCedula = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mecanicoNombre = new javax.swing.JTextField();
        mecanicoDireccion = new javax.swing.JTextField();
        mecanicoTelefono = new javax.swing.JTextField();
        mecanicoCorreo = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        botonDespedir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EDITAR MECÁNICO");

        jLabel2.setText("Número de Cédula:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel7.setText("Dirección:");

        jLabel8.setText("Número de Teléfono:");

        jLabel9.setText("Correo Electrónico:");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonDespedir.setText("Despedir");
        botonDespedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDespedirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mecanicoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(botonBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel4))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mecanicoTelefono)
                    .addComponent(mecanicoDireccion)
                    .addComponent(mecanicoNombre)
                    .addComponent(mecanicoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonActualizar)
                        .addGap(185, 185, 185)
                        .addComponent(botonDespedir)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mecanicoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mecanicoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mecanicoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mecanicoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mecanicoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonActualizar)
                    .addComponent(botonDespedir))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        String cedula = mecanicoCedula.getText().trim();
        Administrador a = new Administrador();
        if (a.existeCedulaMecanico(cedula)) {

            Mecanico m = a.buscarMecanico(cedula);

            mecanicoNombre.setText(m.getNombre());
            mecanicoDireccion.setText(m.getDireccion());
            mecanicoTelefono.setText(m.getTelefono());
            mecanicoCorreo.setText(m.getCorreo());

            mecanicoCedula.setEditable(false);
            botonActualizar.setEnabled(true);
            botonDespedir.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "Mecánico no encontrado: CC" + cedula);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
        String cedula = mecanicoCedula.getText().trim();
        String nombre = mecanicoNombre.getText().trim();
        String direccion = mecanicoDireccion.getText().trim();
        String telefono = mecanicoTelefono.getText().trim();
        String correo = mecanicoCorreo.getText().trim();

        int indice = -1;
        for (int i = 0; i < mecanicos.length; i++) {
            if (mecanicos[i].getCedula().equals(cedula)) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            mecanicos[indice].setNombre(nombre);
            mecanicos[indice].setDireccion(direccion);
            mecanicos[indice].setTelefono(telefono);
            mecanicos[indice].setCorreo(correo);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Indice no encontrado");
        }

        guardarFicheros();
        JOptionPane.showMessageDialog(null, "Guardado Exitoso");
        this.dispose();

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonDespedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDespedirActionPerformed
        // TODO add your handling code here:
        String cedula = mecanicoCedula.getText().trim();
        int indice = -1;
        for (int i = 0; i < mecanicos.length; i++) {
            if (mecanicos[i].getCedula().equals(cedula)) {
                indice = i;
                break;
            }
        }
        
        Date hoy = Calendar.getInstance().getTime();
        mecanicos[indice].setFechaSalida(hoy);
        
        guardarFicheros();

        JOptionPane.showMessageDialog(null, "Guardado Exitoso");
        this.dispose();
    }//GEN-LAST:event_botonDespedirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarMecanico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonDespedir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mecanicoCedula;
    private javax.swing.JTextField mecanicoCorreo;
    private javax.swing.JTextField mecanicoDireccion;
    private javax.swing.JTextField mecanicoNombre;
    private javax.swing.JTextField mecanicoTelefono;
    // End of variables declaration//GEN-END:variables
}
