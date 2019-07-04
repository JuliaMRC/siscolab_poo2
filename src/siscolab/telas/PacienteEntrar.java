/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.telas;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static siscolab.modelos.Validacao.validaEmail;

/**
 *
 * @author user
 */
public class PacienteEntrar extends javax.swing.JFrame {

    public JTextField getEmailC() {
        return emailC;
    }

    public void setEmailC(JTextField emailC) {
        this.emailC = emailC;
    }

    public JTextField getSenhaC() {
        return senhaC;
    }

    public void setSenhaC(JTextField senhaC) {
        this.senhaC = senhaC;
    }

    /**
     * Creates new form PacienteEntrar
     */
    public PacienteEntrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public String getEmailC_s() {
        return emailC.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        emailT = new javax.swing.JLabel();
        emailC = new javax.swing.JTextField();
        senhaT = new javax.swing.JLabel();
        senhaC = new javax.swing.JTextField();
        entrarB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(115, 153, 0));
        titulo.setText("SISCOLAB - Área do paciente");

        emailT.setText("E-mail");

        emailC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailCActionPerformed(evt);
            }
        });

        senhaT.setText("Senha");

        senhaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaCActionPerformed(evt);
            }
        });

        entrarB.setText("Entrar");
        entrarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senhaC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entrarB, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailT)
                                    .addComponent(senhaT))))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(58, 58, 58)
                .addComponent(emailT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entrarB)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailCActionPerformed

    private void senhaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaCActionPerformed

    private void entrarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarBActionPerformed
        boolean aux = true; //while existe exception
        boolean aux1 = true;
        
        try {
            validaEmail(getEmailC_s());
        }catch (Exception ex){    
            JOptionPane.showMessageDialog(null, "E-mail inválido!", "Error", JOptionPane.ERROR_MESSAGE);
            aux1 = false;
        }
        
        //if(aux && aux1){
            
       // }
    }//GEN-LAST:event_entrarBActionPerformed

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
            java.util.logging.Logger.getLogger(PacienteEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacienteEntrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailC;
    private javax.swing.JLabel emailT;
    private javax.swing.JButton entrarB;
    private javax.swing.JTextField senhaC;
    private javax.swing.JLabel senhaT;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
