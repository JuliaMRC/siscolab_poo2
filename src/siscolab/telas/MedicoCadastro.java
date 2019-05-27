/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.telas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import siscolab.modelos.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import static siscolab.modelos.Masks.Mascara;
import siscolab.modelos.ValidacaoNumeros.SoNumeros;
/**
 *
 * @author 20171BSI0278
 */
public class MedicoCadastro extends javax.swing.JFrame {

    private ArrayList<Usuario> container;
    /**
     * Creates new form MedicoCadastro
     */
    public MedicoCadastro() {
        container = new ArrayList();
        initComponents();
        
    }
    
    public MedicoCadastro(ArrayList container) {
        this.container = container;
        initComponents();
        
        cpfC.setDocument(new SoNumeros());
        rgC.setDocument(new SoNumeros());
        dataNascimentoC.setDocument(new SoNumeros());
        crmC.setDocument(new SoNumeros());
        
        
        cpfC = new JFormattedTextField(Mascara("###.###.###-##", cpfC));
        rgC = new JFormattedTextField(Mascara("#.###.###", rgC));
        dataNascimentoC = new JFormattedTextField(Mascara("##/##/####", dataNascimentoC));
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void formatarCampoCPF(){
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
            mask.install(cpfC);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void formatarCampoRG(){
        try {
            MaskFormatter mask = new MaskFormatter("#.###.###");
            mask.setPlaceholderCharacter('_');
            mask.install(rgC);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void formatarCampoDT(){
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
            mask.install(dataNascimentoC);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        titulo = new javax.swing.JLabel();
        cpfT = new javax.swing.JLabel();
        rgT = new javax.swing.JLabel();
        nomeT = new javax.swing.JLabel();
        nomeC = new javax.swing.JTextField();
        sobrenomeT = new javax.swing.JLabel();
        sobrenomeC = new javax.swing.JTextField();
        dataNascimentoT = new javax.swing.JLabel();
        emailT = new javax.swing.JLabel();
        emailC = new javax.swing.JTextField();
        senhaT = new javax.swing.JLabel();
        senhaC = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        especialidadeT = new javax.swing.JLabel();
        especialidadeC = new javax.swing.JTextField();
        senhaT1 = new javax.swing.JLabel();
        municipioC = new javax.swing.JTextField();
        crmT = new javax.swing.JLabel();
        crmC = new javax.swing.JTextField();
        cpfC = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        rgC = new javax.swing.JFormattedTextField();
        dataNascimentoC = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(115, 153, 0));
        titulo.setText("SISCOLAB - Área do médico");

        cpfT.setText("CPF:");

        rgT.setText("RG:");

        nomeT.setText("Nome:");

        nomeC.setToolTipText("");
        nomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCActionPerformed(evt);
            }
        });

        sobrenomeT.setText("Sobrenome:");

        sobrenomeC.setToolTipText("");
        sobrenomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobrenomeCActionPerformed(evt);
            }
        });

        dataNascimentoT.setText("Dt. de Nascimento:");

        emailT.setText("Email:");

        emailC.setText("Insira o seu email");
        emailC.setToolTipText("");
        emailC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailCActionPerformed(evt);
            }
        });

        senhaT.setText("Senha:");

        senhaC.setText("Insira a sua senha");
        senhaC.setToolTipText("");
        senhaC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        senhaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaCActionPerformed(evt);
            }
        });

        ok.setFont(new java.awt.Font("Leelawadee UI", 0, 10)); // NOI18N
        ok.setText("OK");
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
        });
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        especialidadeT.setText("Especialidade:");

        especialidadeC.setText("Insira a sua especialidade");
        especialidadeC.setToolTipText("");
        especialidadeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                especialidadeCActionPerformed(evt);
            }
        });

        senhaT1.setText("Municipio: ");

        municipioC.setToolTipText("");
        municipioC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        municipioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                municipioCActionPerformed(evt);
            }
        });

        crmT.setText("CRM:");

        crmC.setText("Insira o CRM");
        crmC.setToolTipText("");
        crmC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crmCActionPerformed(evt);
            }
        });

        jLabel1.setText("- ES");

        jLabel2.setText("- ES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpfT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(227, 227, 227)
                                .addComponent(rgC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(crmT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataNascimentoT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNascimentoC)
                        .addGap(18, 18, 18)
                        .addComponent(senhaT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(municipioC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailC, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(senhaT)
                        .addGap(18, 18, 18)
                        .addComponent(senhaC, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(crmC, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cpfC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sobrenomeT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sobrenomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rgT)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(especialidadeT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(especialidadeC, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crmT)
                    .addComponent(crmC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rgT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cpfC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cpfT)
                        .addComponent(rgC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sobrenomeT)
                    .addComponent(sobrenomeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeT))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascimentoT)
                    .addComponent(dataNascimentoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaT1)
                    .addComponent(municipioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(especialidadeT)
                    .addComponent(especialidadeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailT)
                    .addComponent(emailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaT))
                .addGap(18, 18, 18)
                .addComponent(ok)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sobrenomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobrenomeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sobrenomeCActionPerformed

    private void nomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCActionPerformed

    private void emailCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailCActionPerformed

    private void senhaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaCActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okActionPerformed

    private void especialidadeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_especialidadeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_especialidadeCActionPerformed

    private void municipioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_municipioCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipioCActionPerformed

    private void crmCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crmCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crmCActionPerformed

    private void okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseClicked

        // Lembrar de mudar para pegar de um banco/array de cadastro de especialidades...
        Especialidade e = new Especialidade(this.especialidadeC.getText());
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        Date data = null;
        
        try {
            data = formato.parse(this.dataNascimentoC.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
        // String cpf, String rg, String nome, String sobrenome, Date dataNascimento, String email, String senha, String crm, Especialidade especialidade, String municipioAtuacao
        Medico m = new Medico(this.cpfC.getText(), this.rgC.getText(), this.nomeC.getText(), this.sobrenomeC.getText(), data , this.emailC.getText(), this.senhaC.getText(), this.crmC.getText(), e, this.municipioC.getText()); 
        this.container.add(m);
        JOptionPane.showMessageDialog(this, "Médico adicionado com sucesso!");
    }//GEN-LAST:event_okMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(MedicoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicoCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cpfC;
    private javax.swing.JLabel cpfT;
    private javax.swing.JTextField crmC;
    private javax.swing.JLabel crmT;
    private javax.swing.JFormattedTextField dataNascimentoC;
    private javax.swing.JLabel dataNascimentoT;
    private javax.swing.JTextField emailC;
    private javax.swing.JLabel emailT;
    private javax.swing.JTextField especialidadeC;
    private javax.swing.JLabel especialidadeT;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField municipioC;
    private javax.swing.JTextField nomeC;
    private javax.swing.JLabel nomeT;
    private javax.swing.JButton ok;
    private javax.swing.JFormattedTextField rgC;
    private javax.swing.JLabel rgT;
    private javax.swing.JTextField senhaC;
    private javax.swing.JLabel senhaT;
    private javax.swing.JLabel senhaT1;
    private javax.swing.JTextField sobrenomeC;
    private javax.swing.JLabel sobrenomeT;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
