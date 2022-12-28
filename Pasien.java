import java.sql.*;
//interface berisi method
public interface Pasien {
     public void  tampil()throws SQLException;
	 public void  tambah()throws SQLException;
	 public void  ubah()throws SQLException;
	 public void  hapus()throws SQLException;
	 public void  cari()throws SQLException;
}

