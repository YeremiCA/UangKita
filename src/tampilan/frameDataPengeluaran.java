package tampilan;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class frameDataPengeluaran extends javax.swing.JFrame {
  kode.Koneksi koneksi = new kode.Koneksi();
  
  Statement st;
  ResultSet rs;
  
  public String id_user;
  public String totalPengeluaran;
  public String totalPengeluaranKategori_1;
  public String totalPengeluaranKategori_2;
  public String totalPengeluaranKategori_3;
  public String totalPengeluaranKategori_4;
  
  public frameDataPengeluaran(String id_user) {
    initComponents();
    this.id_user = id_user;
    this.ambilData_totalPengeluaran(id_user);
    this.ambilData_totalPengeluaranKategori_1(id_user);
    this.ambilData_totalPengeluaranKategori_2(id_user);
    this.ambilData_totalPengeluaranKategori_3(id_user);
    this.ambilData_totalPengeluaranKategori_4(id_user);
    this.ambilData_dataPengeluaran(id_user);
    
    label_totalPengeluaran.setText(this.totalPengeluaran);
    label_totalPengeluaranKategori_1.setText(this.totalPengeluaranKategori_1);
    label_totalPengeluaranKategori_2.setText(this.totalPengeluaranKategori_2);
    label_totalPengeluaranKategori_3.setText(this.totalPengeluaranKategori_3);
    label_totalPengeluaranKategori_4.setText(this.totalPengeluaranKategori_4);  
  }
  
  public void ambilData_totalPengeluaran(String id_user){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran FROM pengeluaran WHERE id_user = '"+id_user+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()) {
        String totalPengeluaran = rs.getString("total_pengeluaran");
        if(totalPengeluaran != null && !totalPengeluaran.isEmpty()) {
          this.totalPengeluaran = totalPengeluaran;
        } else {
          this.totalPengeluaran = "0";
        }
      } else {
          this.totalPengeluaran = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_totalPengeluaranKategori_1(String id_user){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran FROM pengeluaran WHERE id_user = '"+id_user+"' AND kategori_pengeluaran = '"+1+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()) {
        String totalPengeluaran = rs.getString("total_pengeluaran");
        if(totalPengeluaran != null && !totalPengeluaran.isEmpty()) {
          this.totalPengeluaranKategori_1 = totalPengeluaran;
        } else {
          this.totalPengeluaranKategori_1 = "0";
        }
      } else {
          this.totalPengeluaranKategori_1 = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_totalPengeluaranKategori_2(String id_user){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran FROM pengeluaran WHERE id_user = '"+id_user+"' AND kategori_pengeluaran = '"+2+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()) {
        String totalPengeluaran = rs.getString("total_pengeluaran");
        if(totalPengeluaran != null && !totalPengeluaran.isEmpty()) {
          this.totalPengeluaranKategori_2 = totalPengeluaran;
        } else {
          this.totalPengeluaranKategori_2 = "0";
        }
      } else {
          this.totalPengeluaranKategori_2 = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_totalPengeluaranKategori_3(String id_user){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran FROM pengeluaran WHERE id_user = '"+id_user+"' AND kategori_pengeluaran = '"+3+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()) {
        String totalPengeluaran = rs.getString("total_pengeluaran");
        if(totalPengeluaran != null && !totalPengeluaran.isEmpty()) {
          this.totalPengeluaranKategori_3 = totalPengeluaran;
        } else {
          this.totalPengeluaranKategori_3 = "0";
        }
      } else {
          this.totalPengeluaranKategori_3 = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_totalPengeluaranKategori_4(String id_user){
    String query = "SELECT SUM(nilai_pengeluaran) AS total_pengeluaran FROM pengeluaran WHERE id_user = '"+id_user+"' AND kategori_pengeluaran = '"+4+"'";
    
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()) {
        String totalPengeluaran = rs.getString("total_pengeluaran");
        if(totalPengeluaran != null && !totalPengeluaran.isEmpty()) {
          this.totalPengeluaranKategori_4 = totalPengeluaran;
        } else {
          this.totalPengeluaranKategori_4 = "0";
        }
      } else {
          this.totalPengeluaranKategori_4 = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }

  public void ambilData_dataPengeluaran(String id_user){
    String query = "SELECT * FROM pengeluaran WHERE id_user = '"+id_user+"'";
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
    
      // Buat model tabel
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("ID Pengeluaran");
      model.addColumn("Jenis Keperluan");
      model.addColumn("Deskripsi");
      model.addColumn("Nilai Pengeluaran");
      model.addColumn("Tanggal");

      while(rs.next()){
          String idPengeluaran = rs.getString("id_pengeluaran");
          String jenisKeperluan = rs.getString("kategori_pengeluaran");
          String deskripsiPengeluaran = rs.getString("deskripsi_pengeluaran");
          String nilaiPengeluaran = rs.getString("nilai_pengeluaran");
          String tanggalPengeluaran = rs.getString("tanggal_pengeluaran");
          
            switch (jenisKeperluan) {
              case "Sekolah":
                  jenisKeperluan = "1";
                  break;
              case "Makanan":
                  jenisKeperluan = "2";
                  break;
              case "Hobi":
                  jenisKeperluan = "3";
                  break;
              case "Lain-Lain":
                  jenisKeperluan = "4";
                  break;
            }
          model.addRow(new Object[]{idPengeluaran, jenisKeperluan, deskripsiPengeluaran, nilaiPengeluaran, tanggalPengeluaran});
      }
       
      tabel.setModel(model);
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
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
    label_totalPengeluaran = new javax.swing.JLabel();
    label_totalPengeluaranKategori_1 = new javax.swing.JLabel();
    label_totalPengeluaranKategori_2 = new javax.swing.JLabel();
    label_totalPengeluaranKategori_3 = new javax.swing.JLabel();
    label_totalPengeluaranKategori_4 = new javax.swing.JLabel();
    tabel_container = new javax.swing.JScrollPane();
    tabel = new javax.swing.JTable();
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

    label_totalPengeluaran.setBackground(new java.awt.Color(0,0,0,0));
    label_totalPengeluaran.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_totalPengeluaran.setForeground(new java.awt.Color(80, 80, 80));
    getContentPane().add(label_totalPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 192, 190, 24));

    label_totalPengeluaranKategori_1.setBackground(new java.awt.Color(0,0,0,0));
    label_totalPengeluaranKategori_1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_totalPengeluaranKategori_1.setForeground(new java.awt.Color(80, 80, 80));
    getContentPane().add(label_totalPengeluaranKategori_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 188, 192, 24));

    label_totalPengeluaranKategori_2.setBackground(new java.awt.Color(0,0,0,0));
    label_totalPengeluaranKategori_2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_totalPengeluaranKategori_2.setForeground(new java.awt.Color(80, 80, 80));
    getContentPane().add(label_totalPengeluaranKategori_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 220, 192, 24));

    label_totalPengeluaranKategori_3.setBackground(new java.awt.Color(0,0,0,0));
    label_totalPengeluaranKategori_3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_totalPengeluaranKategori_3.setForeground(new java.awt.Color(80, 80, 80));
    getContentPane().add(label_totalPengeluaranKategori_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 254, 192, 24));

    label_totalPengeluaranKategori_4.setBackground(new java.awt.Color(0,0,0,0));
    label_totalPengeluaranKategori_4.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_totalPengeluaranKategori_4.setForeground(new java.awt.Color(80, 80, 80));
    getContentPane().add(label_totalPengeluaranKategori_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(902, 286, 192, 24));

    tabel.setBackground(new java.awt.Color(252, 252, 252));
    tabel.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    tabel.setForeground(new java.awt.Color(100, 100, 100));
    tabel.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "ID Pengeluaran", "Jenis Pengeluaran", "Deskripsi", "Nilai Pengeluaran", "Tanggal"
      }
    ));
    tabel.setRowHeight(25);
    tabel.setSelectionBackground(new java.awt.Color(248, 248, 248));
    tabel.setSelectionForeground(new java.awt.Color(100, 100, 100));
    tabel.getTableHeader().setResizingAllowed(false);
    tabel.getTableHeader().setReorderingAllowed(false);
    tabel_container.setViewportView(tabel);

    getContentPane().add(tabel_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 840, 280));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/data pengeluaran.png"))); // NOI18N
    getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  
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
  public static void main(String args[]) {

  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JLabel label_totalPengeluaran;
  private javax.swing.JLabel label_totalPengeluaranKategori_1;
  private javax.swing.JLabel label_totalPengeluaranKategori_2;
  private javax.swing.JLabel label_totalPengeluaranKategori_3;
  private javax.swing.JLabel label_totalPengeluaranKategori_4;
  private javax.swing.JButton nav_dataPemasukan;
  private javax.swing.JButton nav_dataPengeluaran;
  private javax.swing.JButton nav_home;
  private javax.swing.JButton nav_logout;
  private javax.swing.JButton nav_pemasukanHariIni;
  private javax.swing.JButton nav_pengeluaranHariIni;
  private javax.swing.JButton nav_profil;
  private javax.swing.JTable tabel;
  private javax.swing.JScrollPane tabel_container;
  // End of variables declaration//GEN-END:variables
}
