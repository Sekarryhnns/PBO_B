
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Tagihan extends Data {
    static Connection con;
    String url = "jdbc:mysql://localhost:3306/rumahsakit";
    Scanner input = new Scanner(System.in);
    
    //date
    public void timedate(){
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy || HH:mm:ss");   
        String formattedDate = waktu.format(myFormatObj);
        System.out.println("Waktu : " + formattedDate);
    }

     //tampil data pasien
     //database
     @Override
     public void tampil() throws SQLException{
        System.out.println("\n=================================");
        System.out.println("\nTAMPILAN INFO PASIEN RS SEJAHTERA");
        System.out.println("\n=================================");
        String sql ="SELECT * FROM tagihanpasien";
        con = DriverManager.getConnection(url,"root","");
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);

        while(result.next()){
            System.out.print("\nNama Pasien\t : ");
            System.out.print(result.getString("nama"));
			System.out.print("\nNomor Rekam Medis: ");
            System.out.print(result.getInt("no_rm"));
            System.out.print("\nJenis Kelamin\t : ");
            System.out.print(result.getString("jenis_kelamin"));
            System.out.print("\nAlamat\t\t : ");
            System.out.print(result.getString("alamat"));
            System.out.print("\nUmur Pasien\t : ");
            System.out.print(result.getInt("umur"));
            System.out.print("\nJenis Pasien\t : ");
            System.out.print(result.getString("jenis_pasien"));
            System.out.print("\nJenis Pemeriksaan: ");
            System.out.print(result.getString("jenis_pemeriksaan"));
            System.out.print("\nBiaya\t\t : ");
            System.out.print(result.getInt("biaya"));
            System.out.print("\nTagihan\t\t : ");
            System.out.print(result.getDouble("tagihan"));
            System.out.print("\nPembayaran\t: ");
            System.out.print(result.getInt("pembayaran"));
            System.out.print("\nKembalian\t : ");
            System.out.print(result.getDouble("kembalian"));
            System.out.print("\n");
		}
     }
     //ubah data pasien
     //database
     @Override
    public void ubah()throws SQLException{
        System.out.println("==================");
        System.out.println("UPDATE DATA PASIEN");
        System.out.println("==================");
        try {
            tampil();
            System.out.print("\nMasukkan Nomor Rekam Medis Pasien Yang Akan Diubah : ");
            Integer noRekamMedis = Integer.parseInt(input.nextLine());
            
            String sql = "SELECT * FROM tagihanpasien WHERE no_rm = " +noRekamMedis;
            con = DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Nama baru ["+result.getString("nama")+"]\t: ");
                String nama = input.nextLine();
                   
                sql = "UPDATE tagihanpasien SET nama='"+nama+"' WHERE no_rm='"+noRekamMedis+"'";
                //System.out.println(sql);

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data Pasien ("+noRekamMedis+")");
                }
            } 
            statement.close();        
        } 
		catch (SQLException e) {
        	System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
	
    }
    //hapus data pasien
    //database
    @Override
    public void hapus()throws SQLException{
         System.out.println("=================");
         System.out.println("HAPUS DATA PASIEN");
         System.out.println("=================");
		try{
	        tampil();
            System.out.print("\nInput No Rekam Medis : ");
            String keyword = input.nextLine();
	        
	        String sql = "DELETE FROM tagihanpasien WHERE no_rm LIKE '%"+keyword+"%'";
	        con = DriverManager.getConnection(url,"root","");
	        Statement statement = con.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Data Pasien Sudah Dihapus");
	        } 
	   }
		catch(SQLException e){
	        System.out.println("Penghapusan Data Gagal");
	    }
        catch(Exception e){
            System.out.println("Input data yang benar!");
        }
    }
    //cari data pasien
    //database
    @Override
    public void cari()throws SQLException{
        System.out.println("================");
        System.out.println("CARI DATA PASIEN");
		System.out.println("================");
		System.out.print("Masukkan Nama Pasien yang ingin dilihat : ");    
		String keyword = input.nextLine();
		
		String sql = "SELECT * FROM tagihanpasien WHERE nama LIKE '%"+keyword+"%'";
		con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
            System.out.print("\nNama Pasien\t : ");
            System.out.print(result.getString("nama"));
			System.out.print("\nNomor Rekam Medis: ");
            System.out.print(result.getInt("no_rm"));
            System.out.print("\nJenis Kelamin\t : ");
            System.out.print(result.getString("jenis_kelamin"));
            System.out.print("\nAlamat\t\t : ");
            System.out.print(result.getString("alamat"));
            System.out.print("\nUmur Pasien\t : ");
            System.out.print(result.getInt("umur"));
            System.out.print("\nJenis Pasien\t : ");
            System.out.print(result.getString("jenis_pasien"));
            System.out.print("\nJenis Pemeriksaan: ");
            System.out.print(result.getString("jenis_pemeriksaan"));
            System.out.print("\nBiaya\t\t : ");
            System.out.print(result.getString("biaya"));
            System.out.print("\nTagihan\t\t : ");
            System.out.print(result.getDouble("tagihan"));
            System.out.print("\nBayar\t\t : ");
            System.out.print(result.getInt("pembayaran"));
            System.out.print("\nKembalian\t : ");
            System.out.print(result.getDouble("kembalian"));
            System.out.print("\n");
        } 
    }     
    
}

    
