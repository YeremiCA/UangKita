/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tampilan;
import javax.swing.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author MenyongMenying
 */

public class framePengeluaranHariIni extends javax.swing.JFrame {

  /**
   * Creates new form
   * framePengeluaranHariIni
   */

  kode.Koneksi koneksi = new kode.Koneksi();
  Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  
  Statement st;
  ResultSet rs;
  
  public String id_user;
  public String nilaiDompet;
  public String pengeluaranHariIni;
  public String nilaiKategoriPengeluaran;
  public String tanggal = format.format(date);
  public boolean hasil_1;
  public boolean hasil_2;
  
  public framePengeluaranHariIni(String id_user) {
    initComponents();
    
    this.id_user = id_user;
    this.ambilData_nilaiDompet(id_user);
    
    label_nilaiDompet.setText(this.nilaiDompet);
  }

  public void ambilData_nilaiDompet(String id_user){
    String query = "SELECT * FROM dompet WHERE id_user = '"+id_user+"' ORDER BY id_dompet DESC LIMIT 1";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next() && rs.getString("nilai_dompet") != null){
        this.nilaiDompet = rs.getString("nilai_dompet");
      } else {
        this.nilaiDompet = "0";
      }
        
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }

  public void f_button_submit(String id_user, String deskripsiPengeluaran, String nilaiPengeluaran){
    String kategoriPengeluaran = (String) input_kategoriPengeluaranHariIni.getSelectedItem();

    switch (kategoriPengeluaran) {
        case "Sekolah":
            this.nilaiKategoriPengeluaran = "1";
            break;
        case "Makanan":
            this.nilaiKategoriPengeluaran = "2";
            break;
        case "Hobi":
            this.nilaiKategoriPengeluaran = "3";
            break;
        case "Lain-Lain":
            this.nilaiKategoriPengeluaran = "4";
            break;
    }
    if(kategoriPengeluaran.equals("")|| deskripsiPengeluaran.equals("") || nilaiPengeluaran.equals("") || kategoriPengeluaran == null || deskripsiPengeluaran == null || nilaiPengeluaran == null){
      JOptionPane.showMessageDialog(null, "Isi form pengisian dengan lengkap");
    } else {
        int i_nilaiPengeluaran = Integer.parseInt(nilaiPengeluaran);
        
        if(i_nilaiPengeluaran == 0){
          JOptionPane.showMessageDialog(null, "Nilai pengeluaran tidak boleh 0");
        } else{
          this.inputPengeluaran(id_user, this.nilaiKategoriPengeluaran, deskripsiPengeluaran, nilaiPengeluaran, this.tanggal);
          this.inputDompet(id_user, nilaiPengeluaran, this.nilaiDompet, this.tanggal);
        if(this.hasil_1 == true && this.hasil_2 == true){
          JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data");
          this.ambilData_nilaiDompet(id_user);
          label_nilaiDompet.setText(this.nilaiDompet);
          input_nilaiPengeluaranHariIni.setText("");
        }
      
      }
    } 
  }
  
    public void inputPengeluaran(String id_user, String kategoriPengeluaran, String deskripsiPengeluaran, String nilaiPengeluaran, String Tanggal){
      String query = "INSERT INTO pengeluaran(id_user, kategori_pengeluaran, deskripsi_pengeluaran, nilai_pengeluaran, tanggal_pengeluaran) VALUES ('"+id_user+"', '"+kategoriPengeluaran+"','"+deskripsiPengeluaran+"','"+nilaiPengeluaran+"','"+Tanggal+"')";
    try{
      st = koneksi.koneksi().createStatement();
      int hasil = st.executeUpdate(query);
      
      if(hasil > 0){
        this.hasil_1 = true;
      } else{
        this.hasil_1 = false;
//        JOptionPane.showMessageDialog(null, "Gagal Menambahkan Data");
      }      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    } 
  }
  
  public void inputDompet(String id_user, String nilaiPengeluaran, String nilaiDompetLama, String Tanggal){
    int i_nilaiPengeluaran = Integer.parseInt(nilaiPengeluaran);
    int i_nilaiDompetLama = Integer.parseInt(nilaiDompetLama);
    int nilaiDompetBaru = i_nilaiDompetLama - i_nilaiPengeluaran;
    
    String query = "INSERT INTO dompet (id_user, nilai_dompet, tanggal) VALUES('"+id_user+"', '"+nilaiDompetBaru+"', '"+Tanggal+"')";
    
    try{
      st = koneksi.koneksi().createStatement();
      int hasil = st.executeUpdate(query);
      
      if(hasil > 0){
        this.hasil_2 = true;
      } else{
        this.hasil_2 = false;
//        JOptionPane.showMessageDialog(null, "Gagal Menambahkan Data");
      }      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
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

    nav_home = new javax.swing.JButton();
    nav_pemasukanHariIni = new javax.swing.JButton();
    nav_pengeluaranHariIni = new javax.swing.JButton();
    nav_dataPemasukan = new javax.swing.JButton();
    nav_dataPengeluaran = new javax.swing.JButton();
    nav_profil = new javax.swing.JButton();
    nav_logout = new javax.swing.JButton();
    label_nilaiDompet = new javax.swing.JLabel();
    input_kategoriPengeluaranHariIni = new javax.swing.JComboBox<>();
    input_deskripsiPengeluaranHariIni = new javax.swing.JTextField();
    input_nilaiPengeluaranHariIni = new javax.swing.JTextField();
    button_submit = new javax.swing.JButton();
    background = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    nav_home.setBackground(new java.awt.Color(0,0,0,0));
    nav_home.setBorder(null);
    nav_home.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_homeActionPerformed(evt);
      }
    });
    getContentPane().add(nav_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 50));

    nav_pemasukanHariIni.setBackground(new java.awt.Color(0,0,0,0));
    nav_pemasukanHariIni.setBorder(null);
    nav_pemasukanHariIni.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_pemasukanHariIniActionPerformed(evt);
      }
    });
    getContentPane().add(nav_pemasukanHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 50));

    nav_pengeluaranHariIni.setBackground(new java.awt.Color(0,0,0,0));
    nav_pengeluaranHariIni.setBorder(null);
    nav_pengeluaranHariIni.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_pengeluaranHariIniActionPerformed(evt);
      }
    });
    getContentPane().add(nav_pengeluaranHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 240, 50));

    nav_dataPemasukan.setBackground(new java.awt.Color(0,0,0,0));
    nav_dataPemasukan.setBorder(null);
    nav_dataPemasukan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_dataPemasukanActionPerformed(evt);
      }
    });
    getContentPane().add(nav_dataPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 240, 50));

    nav_dataPengeluaran.setBackground(new java.awt.Color(0,0,0,0));
    nav_dataPengeluaran.setBorder(null);
    nav_dataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_dataPengeluaranActionPerformed(evt);
      }
    });
    getContentPane().add(nav_dataPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, 50));

    nav_profil.setBackground(new java.awt.Color(0,0,0,0));
    nav_profil.setBorder(null);
    nav_profil.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_profilActionPerformed(evt);
      }
    });
    getContentPane().add(nav_profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 240, 50));

    nav_logout.setBackground(new java.awt.Color(0,0,0,0));
    nav_logout.setBorder(null);
    nav_logout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nav_logoutActionPerformed(evt);
      }
    });
    getContentPane().add(nav_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 240, 50));

    label_nilaiDompet.setBackground(new java.awt.Color(0,0,0,0));
    label_nilaiDompet.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_nilaiDompet.setForeground(new java.awt.Color(80, 80, 80));
    label_nilaiDompet.setToolTipText("");
    getContentPane().add(label_nilaiDompet, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 192, 170, 24));

    input_kategoriPengeluaranHariIni.setBackground(new java.awt.Color(0,0,0,0));
    input_kategoriPengeluaranHariIni.setForeground(new java.awt.Color(80, 80, 80));
    input_kategoriPengeluaranHariIni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sekolah", "Makanan", "Hobi", "Lain-Lain" }));
    getContentPane().add(input_kategoriPengeluaranHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 228, 180, 26));

    input_deskripsiPengeluaranHariIni.setBackground(new java.awt.Color(0,0,0,0)
    );
    input_deskripsiPengeluaranHariIni.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    input_deskripsiPengeluaranHariIni.setForeground(new java.awt.Color(80, 80, 80));
    input_deskripsiPengeluaranHariIni.setToolTipText("");
    input_deskripsiPengeluaranHariIni.setBorder(null);
    input_deskripsiPengeluaranHariIni.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        input_deskripsiPengeluaranHariIniActionPerformed(evt);
      }
    });
    getContentPane().add(input_deskripsiPengeluaranHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 267, 170, 24));

    input_nilaiPengeluaranHariIni.setBackground(new java.awt.Color(0,0,0,0)
    );
    input_nilaiPengeluaranHariIni.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    input_nilaiPengeluaranHariIni.setForeground(new java.awt.Color(80, 80, 80));
    input_nilaiPengeluaranHariIni.setToolTipText("");
    input_nilaiPengeluaranHariIni.setBorder(null);
    input_nilaiPengeluaranHariIni.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        input_nilaiPengeluaranHariIniActionPerformed(evt);
      }
    });
    getContentPane().add(input_nilaiPengeluaranHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 304, 170, 24));

    button_submit.setBackground(new java.awt.Color(0,0,0,0));
    button_submit.setToolTipText("");
    button_submit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_submitActionPerformed(evt);
      }
    });
    getContentPane().add(button_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 339, 180, 26));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pengeluaran hari ini.png"))); // NOI18N
    getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void input_deskripsiPengeluaranHariIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_deskripsiPengeluaranHariIniActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_input_deskripsiPengeluaranHariIniActionPerformed

  private void input_nilaiPengeluaranHariIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nilaiPengeluaranHariIniActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_input_nilaiPengeluaranHariIniActionPerformed

  private void nav_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_homeActionPerformed
    // TODO add your handling code here:
    frameHome frameHome = new frameHome(this.id_user);
    frameHome.setVisible(true);
    
    dispose();
  }//GEN-LAST:event_nav_homeActionPerformed

  private void nav_pemasukanHariIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_pemasukanHariIniActionPerformed
    // TODO add your handling code here:
    framePemasukanHariIni framePemasukanHariIni = new framePemasukanHariIni(this.id_user);
    framePemasukanHariIni.setVisible(true);
    dispose();
  }//GEN-LAST:event_nav_pemasukanHariIniActionPerformed

  private void nav_pengeluaranHariIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_pengeluaranHariIniActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_nav_pengeluaranHariIniActionPerformed

  private void nav_dataPemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_dataPemasukanActionPerformed
    // TODO add your handling code here:
    frameDataPemasukan frameDataPemasukan = new frameDataPemasukan(this.id_user);
    frameDataPemasukan.setVisible(true);
    
    dispose();
  }//GEN-LAST:event_nav_dataPemasukanActionPerformed

  private void nav_dataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_dataPengeluaranActionPerformed
    // TODO add your handling code here:
    frameDataPengeluaran frameDataPengeluaran = new frameDataPengeluaran(this.id_user);
    frameDataPengeluaran.setVisible(true);
    
    dispose();
  }//GEN-LAST:event_nav_dataPengeluaranActionPerformed

  private void nav_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_profilActionPerformed
    // TODO add your handling code here:
    frameProfil frameProfil = new frameProfil(this.id_user);
    frameProfil.setVisible(true);

    dispose();
  }//GEN-LAST:event_nav_profilActionPerformed

  private void nav_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_logoutActionPerformed
    // TODO add your handling code here:
    dispose();
  }//GEN-LAST:event_nav_logoutActionPerformed

  private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_submitActionPerformed
    // TODO add your handling code here:
    this.f_button_submit(id_user, input_deskripsiPengeluaranHariIni.getText(), input_nilaiPengeluaranHariIni.getText());
  }//GEN-LAST:event_button_submitActionPerformed

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
      java.util.logging.Logger.getLogger(framePengeluaranHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(framePengeluaranHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(framePengeluaranHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(framePengeluaranHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
   
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JButton button_submit;
  private javax.swing.JTextField input_deskripsiPengeluaranHariIni;
  private javax.swing.JComboBox<String> input_kategoriPengeluaranHariIni;
  private javax.swing.JTextField input_nilaiPengeluaranHariIni;
  private javax.swing.JLabel label_nilaiDompet;
  private javax.swing.JButton nav_dataPemasukan;
  private javax.swing.JButton nav_dataPengeluaran;
  private javax.swing.JButton nav_home;
  private javax.swing.JButton nav_logout;
  private javax.swing.JButton nav_pemasukanHariIni;
  private javax.swing.JButton nav_pengeluaranHariIni;
  private javax.swing.JButton nav_profil;
  // End of variables declaration//GEN-END:variables
}
