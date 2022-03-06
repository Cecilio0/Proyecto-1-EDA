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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class EditarVehiculo extends javax.swing.JFrame {

    Mecanico[] mecanicos;
    Cliente[] clientes;

    /**
     * Creates new form EditarVehiculo
     */
    public EditarVehiculo() {
        initComponents();

        clientes = new Cliente[0];
        mecanicos = new Mecanico[0];

        cargarFicheros();

        botonGuardar.setEnabled(false);
        checkMoto.setEnabled(false);
        checkCarro.setEnabled(false);
        carroCheckLlantas.setEnabled(false);
        motoCheckLlantas.setEnabled(false);
        
        carroCheckLimpio.setEnabled(false);
        motoCheckLimpio.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        clientePlaca = new javax.swing.JTextField();
        motoPlaca = new javax.swing.JTextField();
        motoColor = new javax.swing.JTextField();
        motoKilometraje = new javax.swing.JTextField();
        motoTiempos = new javax.swing.JTextField();
        carroPlaca = new javax.swing.JTextField();
        carroColor = new javax.swing.JTextField();
        carroKilometraje = new javax.swing.JTextField();
        carroNumeroPuertas = new javax.swing.JTextField();
        carroTraccion = new javax.swing.JTextField();
        carroCheckLlantas = new javax.swing.JCheckBox();
        motoCheckLlantas = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        checkMoto = new javax.swing.JCheckBox();
        checkCarro = new javax.swing.JCheckBox();
        botonBuscar = new javax.swing.JButton();
        carroCheckLimpio = new javax.swing.JCheckBox();
        motoCheckLimpio = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EDITAR VEH�CULO");

        jLabel3.setText("Placa:");

        motoPlaca.setEditable(false);

        motoColor.setEditable(false);

        motoKilometraje.setEditable(false);

        motoTiempos.setEditable(false);

        carroPlaca.setEditable(false);

        carroColor.setEditable(false);

        carroKilometraje.setEditable(false);

        carroNumeroPuertas.setEditable(false);

        carroTraccion.setEditable(false);

        carroCheckLlantas.setText("�Llantas �ptimas?");
        carroCheckLlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carroCheckLlantasActionPerformed(evt);
            }
        });

        motoCheckLlantas.setText("�Llantas �ptimas?");

        jLabel17.setText("Tracci�n:");

        jLabel15.setText("Kilometraje:");

        jLabel13.setText("Placa:");

        jLabel14.setText("Color:");

        jLabel10.setText("Color:");

        jLabel11.setText("Kilometraje:");

        jLabel9.setText("Placa:");

        jLabel16.setText("N�mero de Puertas:");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel12.setText("Tiempos:");

        checkMoto.setText("Moto");
        checkMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMotoActionPerformed(evt);
            }
        });

        checkCarro.setText("Carro");
        checkCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCarroActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        carroCheckLimpio.setText("�Limpio?");

        motoCheckLimpio.setText("�Limpio?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkMoto)
                                    .addComponent(motoPlaca)
                                    .addComponent(motoColor)
                                    .addComponent(motoKilometraje)
                                    .addComponent(motoTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(motoCheckLlantas)
                                .addGap(18, 18, 18)
                                .addComponent(motoCheckLimpio)))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(carroColor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(checkCarro)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(carroPlaca)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carroTraccion)
                                    .addComponent(carroNumeroPuertas)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(carroKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(botonGuardar)))
                .addGap(0, 86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(clientePlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonBuscar)
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(carroCheckLlantas)
                        .addGap(18, 18, 18)
                        .addComponent(carroCheckLimpio)
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientePlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMoto)
                    .addComponent(checkCarro))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(motoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carroPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(motoColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carroColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(motoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carroKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(motoTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carroNumeroPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(carroTraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motoCheckLlantas)
                    .addComponent(motoCheckLimpio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carroCheckLlantas)
                    .addComponent(carroCheckLimpio))
                .addGap(18, 18, 18)
                .addComponent(botonGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carroCheckLlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carroCheckLlantasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carroCheckLlantasActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        Administrador a = new Administrador();
        String placa = clientePlaca.getText().trim();
        Vehiculo v = null;
        try {
            v = a.buscarVehiculo(placa);
        } catch (Administrador.ENoExiste ex) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado vehiculo con placa: " + placa);
        } catch (Administrador.EVectorNulo ex) {
            JOptionPane.showMessageDialog(null, "ERROR CRITICO. VECTOR NULO");
        }

        int i1 = -1, i2 = -1;
        for (int i = 0; i < clientes.length; i++) {
            for (int j = 0; j < clientes[i].getVehiculos().length; j++) {
                if (clientes[i].getVehiculos()[j].getPlaca().equals(placa)) {
                    i1 = i;
                    i2 = j;
                }
            }
        }

        String mtPlaca = motoPlaca.getText().trim();
        String mtColor = motoColor.getText().trim();
        String mtKilometraje = motoKilometraje.getText().trim();
        String mtTiempos = motoTiempos.getText().trim();
        boolean mtLlantas = motoCheckLlantas.isSelected();
        boolean mtLimpio = motoCheckLimpio.isSelected();
        mtPlaca = mtPlaca.toUpperCase();

        if (checkMoto.isSelected()) {
            if (motoPlaca.getText().isEmpty() || motoColor.getText().isEmpty() || motoKilometraje.getText().isEmpty() || motoTiempos.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos (MOTO)");
            } else {

                clientes[i1].getVehiculos()[i2].setColor(mtColor);
                clientes[i1].getVehiculos()[i2].setKilometraje(Integer.parseInt(mtKilometraje));
                clientes[i1].getVehiculos()[i2].setEstadoLlantas(mtLlantas);
                clientes[i1].getVehiculos()[i2].setLimpio(mtLimpio);

                guardarFicheros();
                JOptionPane.showMessageDialog(null, "Guardado Exitoso");
                this.dispose();
            }

        }

        String crPlaca = carroPlaca.getText().trim();
        String crColor = carroColor.getText().trim();
        String crKilometraje = carroKilometraje.getText().trim();
        String crNumPuertas = carroNumeroPuertas.getText().trim();
        String crTraccion = carroTraccion.getText().trim();
        boolean crLlantas = carroCheckLlantas.isSelected();
        boolean crLimpio = carroCheckLimpio.isSelected();
        crPlaca = crPlaca.toUpperCase();

        if (checkCarro.isSelected()) {
            if (carroPlaca.getText().isEmpty() || carroColor.getText().isEmpty() || carroKilometraje.getText().isEmpty() || carroNumeroPuertas.getText().isEmpty() || carroTraccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos (CARRO)");
            } else {

                clientes[i1].getVehiculos()[i2].setColor(crColor);
                clientes[i1].getVehiculos()[i2].setColor(crColor);
                clientes[i1].getVehiculos()[i2].setKilometraje(Integer.parseInt(crKilometraje));
                clientes[i1].getVehiculos()[i2].setEstadoLlantas(crLlantas);
                clientes[i1].getVehiculos()[i2].setLimpio(crLimpio);

                guardarFicheros();
                JOptionPane.showMessageDialog(null, "Guardado Exitoso");
                this.dispose();
            }
        }

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void checkMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMotoActionPerformed
        // TODO add your handling code here:
        if (checkCarro.isSelected()) {
            checkCarro.setSelected(false);
            checkMoto.setSelected(true);
        }
    }//GEN-LAST:event_checkMotoActionPerformed

    private void checkCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCarroActionPerformed
        // TODO add your handling code here:
        if (checkMoto.isSelected()) {
            checkMoto.setSelected(false);
            checkCarro.setSelected(true);
        }
    }//GEN-LAST:event_checkCarroActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        if (clientePlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        } else {
            Administrador a = new Administrador();
            String placa = clientePlaca.getText().trim();

            Vehiculo v = null;
            try {
                v = a.buscarVehiculo(placa);
            } catch (Administrador.ENoExiste ex) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado vehiculo con placa: " + placa);
            } catch (Administrador.EVectorNulo ex) {
                JOptionPane.showMessageDialog(null, "ERROR CRITICO. VECTOR NULO");
            }

            if (v != null && v instanceof Carro) {
                checkCarro.setSelected(true);
                carroPlaca.setText(v.getPlaca());
                carroColor.setText(v.getColor());
                carroKilometraje.setText(Integer.toString(v.getKilometraje()));
                carroNumeroPuertas.setText(Integer.toString(((Carro) v).getNumPuertas()));
                carroTraccion.setText(((Carro) v).getTraccion());

                JOptionPane.showMessageDialog(null, "Vehiculo encontrado: CARRO");
                carroColor.setEditable(true);
                carroKilometraje.setEditable(true);
                carroCheckLlantas.setEnabled(true);
                carroCheckLlantas.setSelected(v.isEstadoLlantas());
                
                carroCheckLimpio.setEnabled(true);
                carroCheckLimpio.setSelected(v.isLimpio());

                botonGuardar.setEnabled(true);
            }

            if (v != null && v instanceof Moto) {
                checkMoto.setSelected(true);
                motoPlaca.setText(v.getPlaca());
                motoColor.setText(v.getColor());
                motoKilometraje.setText(Integer.toString(v.getKilometraje()));
                motoTiempos.setText(Integer.toString(((Moto) v).getTiempos()));

                JOptionPane.showMessageDialog(null, "Vehiculo encontrado: MOTO");
                motoColor.setEditable(true);
                motoKilometraje.setEditable(true);
                motoCheckLlantas.setEnabled(true);
                motoCheckLlantas.setSelected(v.isEstadoLlantas());
                
                motoCheckLimpio.setEnabled(true);
                motoCheckLimpio.setSelected(v.isLimpio());

                botonGuardar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JCheckBox carroCheckLimpio;
    private javax.swing.JCheckBox carroCheckLlantas;
    private javax.swing.JTextField carroColor;
    private javax.swing.JTextField carroKilometraje;
    private javax.swing.JTextField carroNumeroPuertas;
    private javax.swing.JTextField carroPlaca;
    private javax.swing.JTextField carroTraccion;
    private javax.swing.JCheckBox checkCarro;
    private javax.swing.JCheckBox checkMoto;
    private javax.swing.JTextField clientePlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox motoCheckLimpio;
    private javax.swing.JCheckBox motoCheckLlantas;
    private javax.swing.JTextField motoColor;
    private javax.swing.JTextField motoKilometraje;
    private javax.swing.JTextField motoPlaca;
    private javax.swing.JTextField motoTiempos;
    // End of variables declaration//GEN-END:variables
}
