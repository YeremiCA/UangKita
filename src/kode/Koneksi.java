package kode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
  private Connection koneksi;
  private final String host = "jdbc:mysql://localhost/db_uangkita";
  private final String user = "root";
  private final String password = "";

  public void koneksi_1() {
    try {
      this.koneksi = DriverManager.getConnection(this.host, this.user, this.password);
    } catch (SQLException exception) {
      System.err.println("Koneksi gagal: " + exception.getMessage());
      System.err.println("Kode Kesalahan: " + exception.getErrorCode());
      System.err.println("SQLState: " + exception.getSQLState());
      exception.printStackTrace();
    }
  }

  public Connection koneksi() {
    if (this.koneksi == null) {
      koneksi_1();
    }
    return this.koneksi;
  }
}
