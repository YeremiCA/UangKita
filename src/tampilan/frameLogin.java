/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tampilan;
import javax.swing.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author MenyongMenying
 */
public class frameLogin extends javax.swing.JFrame {

  /**
   * Creates new form frameLogin
   */
  public frameLogin() {
    initComponents();
  }
  
  public void f_button_submit(String username, String password){
    kode.Koneksi koneksi = new kode.Koneksi();
    Statement st;
    ResultSet rs;
    String query;
    
    query = "SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"'";
    
    if(username.equals("") || password.equals("")){
      JOptionPane.showMessageDialog(null, "Username dan password wajib diisi");
    } else{
        try {
        st = koneksi.koneksi().createStatement();
        rs = st.executeQuery(query);
        
        if(rs.next()){
          frameHome frameHome = new frameHome(rs.getString("id_user"));
          
          JOptionPane.showMessageDialog(null, "Berhasil Login");
          frameHome.setVisible(true);

          dispose();
        } else {
          JOptionPane.showMessageDialog(null, "Gagal Login");
        }

      } catch (SQLException e){
        System.out.println(e.getMessage());
      }
    }
    
  }
  
  public void f_button_buatAkun(){
    frameBuatAkun_1 frameBuatAkun_1 = new frameBuatAkun_1();
    frameBuatAkun_1.setVisible(true);
    
    dispose();
  }
  
  /**
   * This method is called from within
   * the constructor to initialize the
   * form. WARNING: Do NOT modify this
   * code. The content of this method is
   * always regenerated by the Form
   * Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jComboBox1 = new javax.swing.JComboBox<>();
    input_username = new javax.swing.JTextField();
    input_password = new javax.swing.JPasswordField();
    button_submit = new javax.swing.JButton();
    button_buatAkun = new javax.swing.JButton();
    background = new javax.swing.JLabel();

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    input_username.setBackground(new java.awt.Color(0,0,0,0));
    input_username.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
    input_username.setForeground(new java.awt.Color(100, 100, 100));
    input_username.setBorder(null);
    getContentPane().add(input_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 160, 290, 30));

    input_password.setBackground(new java.awt.Color(0,0,0,0));
    input_password.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
    input_password.setForeground(new java.awt.Color(80, 80, 80));
    input_password.setBorder(null);
    getContentPane().add(input_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 240, 290, 30));

    button_submit.setBackground(new java.awt.Color(0,0,0,0));
    button_submit.setBorder(null);
    button_submit.setBorderPainted(false);
    button_submit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_submitActionPerformed(evt);
      }
    });
    getContentPane().add(button_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 340, 80, 32));

    button_buatAkun.setBackground(new java.awt.Color(0,0,0,0));
    button_buatAkun.setBorder(null);
    button_buatAkun.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_buatAkunActionPerformed(evt);
      }
    });
    getContentPane().add(button_buatAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 180, 16));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Login.png"))); // NOI18N
    getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_submitActionPerformed
    // TODO add your handling code here:
    this.f_button_submit(input_username.getText(), input_password.getText());
  }//GEN-LAST:event_button_submitActionPerformed

  private void button_buatAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buatAkunActionPerformed
    // TODO add your handling code here:
    this.f_button_buatAkun();
  }//GEN-LAST:event_button_buatAkunActionPerformed

  /**
   * @param args the command line
   * arguments
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
      java.util.logging.Logger.getLogger(frameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(frameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(frameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(frameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new frameLogin().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JButton button_buatAkun;
  private javax.swing.JButton button_submit;
  private javax.swing.JPasswordField input_password;
  private javax.swing.JTextField input_username;
  private javax.swing.JComboBox<String> jComboBox1;
  // End of variables declaration//GEN-END:variables
}
