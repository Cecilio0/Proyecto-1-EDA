/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package taller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pabli
 */
public class EliminarMecanico extends javax.swing.JFrame {
    Mecanico[] mecanicos;
    Cliente[] clientes;
    /**
     * Creates new form EliminarMecanico
     */
    public EliminarMecanico() {
        initComponents();
        clientes = new Cliente[0];
        mecanicos = new Mecanico[0];
        cargarFicheros();
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
        botonGuardarEliminacionM = new javax.swing.JButton();
        idEliminar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Eliminar Mecanico");

        jLabel2.setText("Digite una ID:");

        botonGuardarEliminacionM.setText("Guardar Cambios");
        botonGuardarEliminacionM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarEliminacionMActionPerformed(evt);
            }
        });

        idEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardarEliminacionM)
                    .addComponent(idEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(botonGuardarEliminacionM)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarEliminacionMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarEliminacionMActionPerformed
        // TODO add your handling code here:
        if(idEliminar.getText().isEmpty()){ 
             JOptionPane.showMessageDialog(null, "Por favor complete el campo");
        } else { 
            String id = idEliminar.getText().trim();
            Administrador a = new Administrador();
            if(a.existeId(id)){
                try {
                    a.eliminarMecanico(id);
                } catch (Administrador.ENoExiste ex) {
                    Logger.getLogger(EliminarMecanico.class.getName()).log(Level.SEVERE, null, ex);
                }
                 JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
                 this.dispose();
            }else{
                    JOptionPane.showMessageDialog(null, "No existe un cliente con la cedula: " + idEliminar + " para eliminar");
            }
        }
    }//GEN-LAST:event_botonGuardarEliminacionMActionPerformed

    private void idEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarMecanico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardarEliminacionM;
    private javax.swing.JTextField idEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
