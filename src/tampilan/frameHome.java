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
public class frameHome extends javax.swing.JFrame {
  
  /**
   * Creates new form frameHome
   */
  kode.Koneksi koneksi = new kode.Koneksi();
  Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  
  Statement st;
  ResultSet rs;
  
  public String id_user;
  public String tanggal = format.format(date);
  public String nilaiDompet;
  public String pemasukanHariIni;
  public String pengeluaranHariIni;
  public String uangBersihHariIni;
  public String rata2PemasukanPerHari;
  public String rata2PengeluaranPerHari;
          
  public frameHome(String id_user) {
    initComponents();
    this.id_user = id_user;
    this.ambilData_nilaiDompet(id_user);
    this.ambilData_pemasukanHariIni(id_user, this.tanggal);
    this.ambilData_pengeluaranHariIni(id_user, this.tanggal);
    this.ambilData_uangBersihHariIni(this.pemasukanHariIni, this.pengeluaranHariIni);
    this.ambilData_rata2Pemasukan(id_user);
    this.ambilData_rata2Pengeluaran(id_user);
    
    label_nilaiDompet.setText(this.nilaiDompet);
    label_pemasukanHariIni.setText(this.pemasukanHariIni);
    label_pengeluaranHariIni.setText(this.pengeluaranHariIni);
    label_rata2PemasukanPerHari.setText(this.rata2PemasukanPerHari);
    label_rata2PengeluaranPerHari.setText(this.rata2PengeluaranPerHari);
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
  
  public void ambilData_pemasukanHariIni(String id_user, String tanggal){
    String query = "SELECT SUM(nilai_pemasukan) AS total_pemasukan FROM pemasukan WHERE id_user = '"+id_user+"' AND tanggal_pemasukan = '"+tanggal+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next() && rs.getString("total_pemasukan") != null){
        this.pemasukanHariIni = rs.getString("total_pemasukan");
      } else {
        this.pemasukanHariIni = "0";
      }
        
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_pengeluaranHariIni(String id_user, String tanggal){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran FROM pengeluaran WHERE id_user = '"+id_user+"' AND tanggal_pengeluaran = '"+tanggal+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()  && rs.getString("total_pengeluaran") != null){
        this.pengeluaranHariIni = rs.getString("total_pengeluaran");
        if (this.pengeluaranHariIni == null) {
          this.pengeluaranHariIni = "0";
        }
      } else {
        this.pengeluaranHariIni = "0";
      }
      this.ambilData_uangBersihHariIni(this.pemasukanHariIni, this.pengeluaranHariIni);
      label_uangBersihHariIni.setText(this.uangBersihHariIni);       
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_uangBersihHariIni(String pemasukanHariIni, String pengeluaranHariIni){
    
    int pemasukan = Integer.parseInt(pemasukanHariIni);
    int pengeluaran = Integer.parseInt(pengeluaranHariIni);
    int uangBersihHariIni = pemasukan - pengeluaran;
    this.uangBersihHariIni = Integer.toString(uangBersihHariIni);
  }

  public void ambilData_rata2Pemasukan(String id_user){
    String query = "SELECT SUM(nilai_pemasukan) AS total_pemasukan, COUNT(DISTINCT tanggal_pemasukan) AS jumlah_hari, SUM(nilai_pemasukan) / COUNT(DISTINCT tanggal_pemasukan) AS rata2PemasukanPerHari FROM pemasukan WHERE id_user = '"+id_user+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()  && rs.getString("rata2PemasukanPerHari") != null){
        double rata2PemasukanPerHari = rs.getDouble("rata2PemasukanPerHari");
        this.rata2PemasukanPerHari = String.valueOf(Math.round(rata2PemasukanPerHari));
        if (this.rata2PemasukanPerHari == null) {
          this.rata2PemasukanPerHari = "0";
        }
      } else {
        this. rata2PemasukanPerHari = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_rata2Pengeluaran(String id_user){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran, COUNT(DISTINCT tanggal_pengeluaran) AS jumlah_hari,  SUM(nilai_pengeluaran) / COUNT(DISTINCT tanggal_pengeluaran) AS rata2PengeluaranPerHari FROM pengeluaran WHERE id_user = '"+id_user+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()  && rs.getString("rata2PengeluaranPerHari") != null){
        double rata2PengeluaranPerHari = rs.getDouble("rata2PengeluaranPerHari");
        this.rata2PengeluaranPerHari = String.valueOf(Math.round(rata2PengeluaranPerHari));
        if (this.rata2PengeluaranPerHari == null) {
          this.rata2PengeluaranPerHari = "0";
        }
      } else {
        this. rata2PengeluaranPerHari = "0";
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
    label_pemasukanHariIni = new javax.swing.JLabel();
    label_pengeluaranHariIni = new javax.swing.JLabel();
    label_rata2PemasukanPerHari = new javax.swing.JLabel();
    label_uangBersihHariIni = new javax.swing.JLabel();
    label_rata2PengeluaranPerHari = new javax.swing.JLabel();
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
    label_nilaiDompet.setFont(new java.awt.Font("Oswald", 0, 36)); // NOI18N
    label_nilaiDompet.setForeground(new java.awt.Color(252, 252, 252));
    getContentPane().add(label_nilaiDompet, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 202, 190, 40));

    label_pemasukanHariIni.setBackground(new java.awt.Color(0,0,0,0));
    label_pemasukanHariIni.setFont(new java.awt.Font("Oswald", 0, 36)); // NOI18N
    label_pemasukanHariIni.setForeground(new java.awt.Color(252, 252, 252));
    getContentPane().add(label_pemasukanHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 202, 190, 40));

    label_pengeluaranHariIni.setBackground(new java.awt.Color(0,0,0,0));
    label_pengeluaranHariIni.setFont(new java.awt.Font("Oswald", 0, 36)); // NOI18N
    label_pengeluaranHariIni.setForeground(new java.awt.Color(252, 252, 252));
    getContentPane().add(label_pengeluaranHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(947, 202, 190, 40));

    label_rata2PemasukanPerHari.setBackground(new java.awt.Color(0,0,0,0));
    label_rata2PemasukanPerHari.setFont(new java.awt.Font("Oswald", 0, 36)); // NOI18N
    label_rata2PemasukanPerHari.setForeground(new java.awt.Color(80, 80, 80));
    label_rata2PemasukanPerHari.setToolTipText("");
    getContentPane().add(label_rata2PemasukanPerHari, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 475, 340, 40));

    label_uangBersihHariIni.setBackground(new java.awt.Color(0,0,0,0));
    label_uangBersihHariIni.setFont(new java.awt.Font("Oswald", 0, 36)); // NOI18N
    label_uangBersihHariIni.setForeground(new java.awt.Color(80, 80, 80));
    label_uangBersihHariIni.setToolTipText("");
    getContentPane().add(label_uangBersihHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 360, 390, 40));

    label_rata2PengeluaranPerHari.setBackground(new java.awt.Color(0,0,0,0));
    label_rata2PengeluaranPerHari.setFont(new java.awt.Font("Oswald", 0, 36)); // NOI18N
    label_rata2PengeluaranPerHari.setForeground(new java.awt.Color(80, 80, 80));
    label_rata2PengeluaranPerHari.setToolTipText("");
    getContentPane().add(label_rata2PengeluaranPerHari, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 475, 340, 40));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home.png"))); // NOI18N
    getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void nav_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_homeActionPerformed
    // TODO add your handling code here:

  }//GEN-LAST:event_nav_homeActionPerformed

  private void nav_pemasukanHariIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_pemasukanHariIniActionPerformed
    // TODO add your handling code here:
    framePemasukanHariIni framePemasukanHariIni = new framePemasukanHariIni(this.id_user);
    framePemasukanHariIni.setVisible(true);
    dispose();
  }//GEN-LAST:event_nav_pemasukanHariIniActionPerformed

  private void nav_pengeluaranHariIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_pengeluaranHariIniActionPerformed
    // TODO add your handling code here:
    framePengeluaranHariIni framePengeluaranHariIni = new framePengeluaranHariIni(this.id_user);
    framePengeluaranHariIni.setVisible(true);
    
    dispose();
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
      java.util.logging.Logger.getLogger(frameHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(frameHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(frameHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(frameHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JLabel label_nilaiDompet;
  private javax.swing.JLabel label_pemasukanHariIni;
  private javax.swing.JLabel label_pengeluaranHariIni;
  private javax.swing.JLabel label_rata2PemasukanPerHari;
  private javax.swing.JLabel label_rata2PengeluaranPerHari;
  private javax.swing.JLabel label_uangBersihHariIni;
  private javax.swing.JButton nav_dataPemasukan;
  private javax.swing.JButton nav_dataPengeluaran;
  private javax.swing.JButton nav_home;
  private javax.swing.JButton nav_logout;
  private javax.swing.JButton nav_pemasukanHariIni;
  private javax.swing.JButton nav_pengeluaranHariIni;
  private javax.swing.JButton nav_profil;
  // End of variables declaration//GEN-END:variables
}
