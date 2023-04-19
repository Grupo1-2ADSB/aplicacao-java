/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaSwing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Leo
 */
public class Login extends javax.swing.JFrame {

    service.ConexaoBancoService conexao = new service.ConexaoBancoService();

    JdbcTemplate con = conexao.getConnection();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    private void dispose(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//Degradê
    class jPanelGradient extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int w = getWidth(), h = getHeight();
            Color color1 = Color.decode("#3e838c");
            Color color2 = Color.decode("#22a59f");
            GradientPaint gp = new GradientPaint(100, 525, color2, w, h, color1);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);

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
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanelParent = new javax.swing.JPanel();
        jPanelImage = new javax.swing.JPanel();
        lblIconLogin = new javax.swing.JLabel();
        jPanelForm = new jPanelGradient();
        iptPass = new javax.swing.JPasswordField();
        linePass = new javax.swing.JSeparator();
        lblIconPass = new javax.swing.JLabel();
        lblIconUser = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lineUser = new javax.swing.JSeparator();
        iptUser = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("jLabel2");
        jLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanelImage.setBackground(new java.awt.Color(0,0,0,1));

        lblIconLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teste.png")));

        javax.swing.GroupLayout jPanelImageLayout = new javax.swing.GroupLayout(jPanelImage);
        jPanelImage.setLayout(jPanelImageLayout);
        jPanelImageLayout.setHorizontalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIconLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanelImageLayout.setVerticalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIconLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        iptPass.setBackground(new java.awt.Color(0,0,0,1));
        iptPass.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        iptPass.setForeground(new java.awt.Color(255, 255, 255));
        iptPass.setToolTipText("");
        iptPass.setBorder(null);
        iptPass.setCaretColor(new java.awt.Color(255, 255, 255));
        iptPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptPassActionPerformed(evt);
            }
        });

        linePass.setBackground(new java.awt.Color(255, 255, 255));
        linePass.setForeground(new java.awt.Color(255, 255, 255));

        lblIconPass.setBackground(new java.awt.Color(255, 255, 255));
        lblIconPass.setForeground(new java.awt.Color(255, 255, 255));
        lblIconPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/lock.png")));

        lblIconUser.setBackground(new java.awt.Color(255, 255, 255));
        lblIconUser.setForeground(new java.awt.Color(255, 255, 255));
        lblIconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png")));
        lblIconUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("X");
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        lineUser.setBackground(new java.awt.Color(255, 255, 255));
        lineUser.setForeground(new java.awt.Color(255, 255, 255));

        iptUser.setBackground(new java.awt.Color(0,0,0,1));
        iptUser.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        iptUser.setForeground(new java.awt.Color(255, 255, 255));
        iptUser.setBorder(null);
        iptUser.setCaretColor(new java.awt.Color(255, 255, 255));
        iptUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptUserActionPerformed(evt);
            }
        });

        lblLogin.setBackground(new java.awt.Color(255, 255, 255));
        lblLogin.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("LOGIN");

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Usuário");

        lblPass.setBackground(new java.awt.Color(255, 255, 255));
        lblPass.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 255, 255));
        lblPass.setText("Senha");

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setForeground(Color.decode("#1ea49d"));
        btnEntrar.setText("Entrar");
        btnEntrar.setToolTipText("");
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setFocusPainted(false);
        btnEntrar.setFocusable(false);
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(iptUser, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(iptPass)
                                .addComponent(linePass)
                                .addComponent(lineUser))
                            .addComponent(lblPass)
                            .addComponent(lblUser))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(143, 143, 143)
                        .addComponent(lblExit)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExit)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblLogin)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(lblUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iptUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iptPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linePass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );

        javax.swing.GroupLayout jPanelParentLayout = new javax.swing.GroupLayout(jPanelParent);
        jPanelParent.setLayout(jPanelParentLayout);
        jPanelParentLayout.setHorizontalGroup(
            jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParentLayout.createSequentialGroup()
                .addComponent(jPanelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelParentLayout.setVerticalGroup(
            jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelParent);
        jPanelParent.setBounds(0, 0, 720, 440);

        setSize(new java.awt.Dimension(718, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void iptUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iptUserActionPerformed

    private void iptPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iptPassActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        String usuario = String.valueOf(iptUser.getText());
        String senha = String.valueOf(iptPass.getText());

        Monitoramento monitoramento = new Monitoramento();

//        System.out.println(usuario);
//        System.out.println(senha);

        List<LoginTeste> listaUsuario = new ArrayList();

        listaUsuario = con.query("SELECT * FROM tbUsuario WHERE nomeUsuario = ? AND senhaUsuario = ?",
                new BeanPropertyRowMapper(LoginTeste.class), usuario, senha);

        if (listaUsuario.isEmpty()) {
//            System.out.println("nao foi");
            JOptionPane.showMessageDialog(jPanelParent, "Usuário não encontrado", "ERRO", JOptionPane.OK_OPTION);
        } else {
//            System.out.println(" foi");
            JOptionPane.showMessageDialog(jPanelParent, String.format(("Bem-vindo de volta, %s!"), usuario), "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            Login.this.dispose();
            monitoramento.setVisible(true);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        // TODO add your handling code here:
        btnEntrar.setBackground(Color.decode("#1ea49d"));
        btnEntrar.setForeground(Color.decode("#ffffff"));
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        // TODO add your handling code here:
        btnEntrar.setBackground(Color.decode("#ffffff"));
        btnEntrar.setForeground(Color.decode("#1ea49d"));
    }//GEN-LAST:event_btnEntrarMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JPasswordField iptPass;
    private javax.swing.JTextField iptUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelImage;
    private javax.swing.JPanel jPanelParent;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblIconLogin;
    private javax.swing.JLabel lblIconPass;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JSeparator linePass;
    private javax.swing.JSeparator lineUser;
    // End of variables declaration//GEN-END:variables
}
