/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaestudiantil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class AgregarMateriaDialog extends javax.swing.JDialog {

    /**
     * Creates new form AgregarMateriaDialog
     */
    public AgregarMateriaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInicio = new javax.swing.JLabel();
        labelFin = new javax.swing.JLabel();
        labelMaestro = new javax.swing.JLabel();
        txtFin = new javax.swing.JTextField();
        labelAula = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        comboBoxSemestre = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        chkBoxLunes = new javax.swing.JCheckBox();
        txtCodigo = new javax.swing.JTextField();
        chkBoxMartes = new javax.swing.JCheckBox();
        txtInicio = new javax.swing.JTextField();
        chkBoxMiercoles = new javax.swing.JCheckBox();
        txtMaestro = new javax.swing.JTextField();
        chkBoxJueves = new javax.swing.JCheckBox();
        txtAula = new javax.swing.JTextField();
        chkBoxViernes = new javax.swing.JCheckBox();
        labelMateria = new javax.swing.JLabel();
        chkBoxSabado = new javax.swing.JCheckBox();
        labelCodigo = new javax.swing.JLabel();
        chkBoxDomingo = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar materia");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelInicio.setText("Inicio");

        labelFin.setText("Fin");

        labelMaestro.setText("Maestro");

        labelAula.setText("Aula");

        jLabel1.setText("Semestre");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        comboBoxSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        comboBoxSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSemestreActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        chkBoxLunes.setText("Lunes");
        chkBoxLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxLunesActionPerformed(evt);
            }
        });

        chkBoxMartes.setText("Martes");

        txtInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInicioActionPerformed(evt);
            }
        });

        chkBoxMiercoles.setText("Miércoles");

        chkBoxJueves.setText("Jueves");

        txtAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAulaActionPerformed(evt);
            }
        });

        chkBoxViernes.setText("Viernes");

        labelMateria.setText("Materia");

        chkBoxSabado.setText("Sábado");

        labelCodigo.setText("Código");

        chkBoxDomingo.setText("Domingo");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBoxMiercoles)
                            .addComponent(chkBoxLunes)
                            .addComponent(chkBoxJueves)
                            .addComponent(chkBoxMartes)
                            .addComponent(btnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBoxDomingo)
                            .addComponent(chkBoxSabado)
                            .addComponent(chkBoxViernes)
                            .addComponent(btnCancelar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(labelCodigo)
                                    .addComponent(labelMaestro)
                                    .addComponent(labelAula)
                                    .addComponent(labelFin))
                                .addGap(0, 9, Short.MAX_VALUE))
                            .addComponent(labelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFin, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMaestro, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAula, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(comboBoxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInicio)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFin)
                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaestro)
                    .addComponent(txtMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBoxLunes)
                    .addComponent(chkBoxViernes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBoxSabado)
                    .addComponent(chkBoxMartes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBoxDomingo)
                    .addComponent(chkBoxMiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkBoxJueves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Materia m = new Materia();
        ArrayList<String> dias = new ArrayList<>();

        m.setNombre(txtNombre.getText());
        m.setCodigo(txtCodigo.getText());
        m.setSemestre( Integer.valueOf( (String) comboBoxSemestre.getSelectedItem()));
        try {
            m.setHora_inicio(new SimpleDateFormat("HH:mm").parse(txtInicio.getText()));
            m.setHora_fin(new SimpleDateFormat("HH:mm").parse(txtFin.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Ingrese la hora en formato HH:mm");
        }
        m.setMaestro(txtMaestro.getText());
        //m.setDiasFormat("0000000");
        
        if (chkBoxLunes.isSelected())
            dias.add("Lunes");
        if (chkBoxMartes.isSelected())
            dias.add("Martes");
        if (chkBoxMiercoles.isSelected())
            dias.add("Miércoles");
        if (chkBoxJueves.isSelected())
            dias.add("Jueves");
        if (chkBoxViernes.isSelected())
            dias.add("Viernes");
        if (chkBoxSabado.isSelected())
            dias.add("Sábado");
        if (chkBoxDomingo.isSelected())
            dias.add("Domingo");
        
        m.setDias(dias);
        
        for (String d : m.getDias()) {
            System.out.println(d);
        }
        
        System.out.println(m.getDiasFormat());
        
        m.setAula(txtAula.getText());

        DB.write(m, "INSERT INTO agenda.materias (codigo, nombre, semestre, hora_inicio, hora_fin, maestro, dias, aula)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

        // TODO: Actualizar tabla al cerrar esta ventana
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void comboBoxSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSemestreActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void chkBoxLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxLunesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBoxLunesActionPerformed

    private void txtInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInicioActionPerformed

    private void txtAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAulaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AgregarMateriaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarMateriaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarMateriaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarMateriaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarMateriaDialog dialog = new AgregarMateriaDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox chkBoxDomingo;
    private javax.swing.JCheckBox chkBoxJueves;
    private javax.swing.JCheckBox chkBoxLunes;
    private javax.swing.JCheckBox chkBoxMartes;
    private javax.swing.JCheckBox chkBoxMiercoles;
    private javax.swing.JCheckBox chkBoxSabado;
    private javax.swing.JCheckBox chkBoxViernes;
    private javax.swing.JComboBox<String> comboBoxSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAula;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelFin;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelMaestro;
    private javax.swing.JLabel labelMateria;
    private javax.swing.JTextField txtAula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtMaestro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
