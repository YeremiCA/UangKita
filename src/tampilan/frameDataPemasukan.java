package tampilan;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class frameDataPemasukan extends javax.swing.JFrame {
  kode.Koneksi koneksi = new kode.Koneksi();
  Statement st;
  ResultSet rs;
  
  public String id_user;
  public String totalPemasukan;
  
  public frameDataPemasukan(String id_user) {
    initComponents();
    this.id_user = id_user;
    this.ambilData_totalPemasukan(id_user);
    this.ambilData_dataPemasukan(id_user);
    label_totalPemasukan.setText(this.totalPemasukan);
  }
  
  public void ambilData_totalPemasukan(String id_user){
    String query = "SELECT SUM(nilai_pemasukan) AS total_pemasukan FROM pemasukan WHERE id_user = '"+id_user+"'";
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
      
      if(rs.next()) {
        String totalPemasukan = rs.getString("total_pemasukan");
        if(totalPemasukan != null && !totalPemasukan.isEmpty()) {
          this.totalPemasukan = totalPemasukan;
        } else {
          this.totalPemasukan = "0";
        }
      } else {
          this.totalPemasukan = "0";
      }
      
    } catch(SQLException e){
      System.out.println(e.getMessage());
    }
  }
  
  public void ambilData_dataPemasukan(String id_user){
    String query = "SELECT * FROM pemasukan WHERE id_user = '"+id_user+"'";
    try{
      st = koneksi.koneksi().createStatement();
      rs = st.executeQuery(query);
    
      // Buat model tabel
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("ID Pemasukan");
      model.addColumn("Nilai Pemasukan");
      model.addColumn("Tanggal");

      while(rs.next()){
          String idPemasukan = rs.getString("id_pemasukan");
          String nilaiPemasukan = rs.getString("nilai_pemasukan");
          String tanggalPemasukan = rs.getString("tanggal_pemasukan");
          model.addRow(new Object[]{idPemasukan, nilaiPemasukan, tanggalPemasukan});
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
    label_totalPemasukan = new javax.swing.JLabel();
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

    label_totalPemasukan.setBackground(new java.awt.Color(0,0,0,0));
    label_totalPemasukan.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    label_totalPemasukan.setForeground(new java.awt.Color(80, 80, 80));
    getContentPane().add(label_totalPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 192, 190, 24));

    tabel.setBackground(new java.awt.Color(252, 252, 252));
    tabel.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
    tabel.setForeground(new java.awt.Color(100, 100, 100));
    tabel.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null},
        {null, null, null},
        {null, null, null},
        {null, null, null}
      },
      new String [] {
        "ID Pemasukan", "Nilai Pemasukan", "Tanggal"
      }
    ));
    tabel.setRowHeight(25);
    tabel.setSelectionBackground(new java.awt.Color(248, 248, 248));
    tabel.setSelectionForeground(new java.awt.Color(100, 100, 100));
    tabel.getTableHeader().setResizingAllowed(false);
    tabel.getTableHeader().setReorderingAllowed(false);
    tabel_container.setViewportView(tabel);

    getContentPane().add(tabel_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 840, 370));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/data pemasukan.png"))); // NOI18N
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
  public static void main(String args[]) {
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JLabel label_totalPemasukan;
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
