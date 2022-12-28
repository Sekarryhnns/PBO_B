import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.*;
import java.util.HashMap; 


//class induk dan implement dari interface pasien
public class Data implements Pasien {
    //deklarasi var
    static Connection con;
    String url = "jdbc:mysql://localhost:3306/rumahsakit";
    String nama;
    int noRekamMedis;
    String alamat;
    int nojenisKelamin;
    String jenisKelamin;
    int noJenisPemeriksaan;
    String jenispemeriksaan;
    int umur;
    int biaya;
    int noJenisPasien;
    String jenisPasien;
    double totalBiaya;
    int bayar;
    double kembalian;

    //constructor
    public Data(){
        
    }
	//objek input
	Scanner input = new Scanner(System.in);

    //override method dari interface
    //database
    @Override
    public void tampil()throws SQLException{

    }
    //database
    @Override
    public void tambah()throws SQLException{
        System.out.println("=================");
        System.out.println("INPUT DATA PASIEN");
        System.out.println("=================");
        try{
            //nama pasien
            System.out.println("Inputkan Nama : ");
            this.nama = input.nextLine();

            //no rm
            int fail = 0;
            //exception
            do{
                try{
                    System.out.println("Inputkan Nomor Rekam Medis : ");
                    this.noRekamMedis = input.nextInt();
                    input.nextLine();
                    if(this.noRekamMedis < 1){
                        System.out.println("Mohon Inputkan angka dengan baik dan benar");
                    }
                }
                catch (Exception e){
                    fail +=1;
                    if(fail > 2){
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
             } while (this.noRekamMedis < 1 ); // perulangan

             //alamat
             System.out.println("Inputkan Alamat : ");
            this.alamat = input.nextLine();

            //jenis kelamin
            //exception
            do{
                try{
                    //collection hashmap
                    HashMap<String, String> daftargender = new HashMap<String, String>();
                    daftargender.put("1", "PRIA");
                    daftargender.put("2", "WANITA");
                    System.out.println(daftargender); 
                    System.out.println("Inputkan Jenis Kelamin  : ");
                    this.nojenisKelamin = input.nextInt();
                    input.nextLine();
                    if(this.nojenisKelamin<1 || this.nojenisKelamin>2)
                    {
                    System.out.println("Inputan harus angka 1 atau 2");
                    }
                } catch (Exception e){
                    fail += 1;
                    if (fail > 2) {
                        System.out.println("Mohon perhatikan lagi inputan");
                        } else {
                        System.out.println("Mohon Inputkan inputan berupa angka!");
                        }
                        input.nextLine();
                        }
                        //perulangan while
                        } while (this.nojenisKelamin < 1 || this.nojenisKelamin > 2);
                        if(this.nojenisKelamin == 1){
                            this.jenisKelamin = "Pria";
                        }
                        else if(this.nojenisKelamin == 2){
                            this.jenisKelamin = "Wanita";
                        }

            //jenis periksa
           //collection hashmap
           HashMap<String, String> daftarperiksa = new HashMap<String, String>();
           daftarperiksa.put("1", "Tiroid");
           daftarperiksa.put("2", "Demam Berdarah");
           daftarperiksa.put("3", "Malaria");
           daftarperiksa.put("4", "Covid-19");
           daftarperiksa.put("5", "Kolestrol");
           System.out.println(daftarperiksa); 
            //exception
            do{
                try{
                    System.out.println("Inputkan Jenis Pemeriksaan : ");
                    this.noJenisPemeriksaan = input.nextInt();
                    input.nextLine();
                    if(this.noJenisPemeriksaan<1 || this.noJenisPemeriksaan>5)
                    {
                    System.out.println("Inputan harus angka 1-5");
                    }
                } catch (Exception e){
                    fail += 1;
                    if (fail > 2) {
                        System.out.println("Mohon perhatikan lagi inputan");
                        } else {
                        System.out.println("Mohon Inputkan inputan berupa angka!");
                        }
                        input.nextLine();
                        }
                        //perulangan while
                        } while (this.noJenisPemeriksaan < 1 || this.noJenisPemeriksaan > 5); //perulangan
                        if(this.noJenisPemeriksaan == 1){
                            this.jenispemeriksaan = "Tiroid";
                        }
                        else if(this.noJenisPemeriksaan == 2){
                            this.jenispemeriksaan = "Demam Berdarah";
                        }
                        else if(noJenisPemeriksaan == 3){
                            this.jenispemeriksaan = "Malaria";
                        }
                        else if(noJenisPemeriksaan == 4){
                            this.jenispemeriksaan = "Covid-19";
                        }
                        else if(noJenisPemeriksaan == 5){
                            this.jenispemeriksaan = "Kolestrol";
                        }

        //umur
        // exception
        do{
            try{
                System.out.println("Inputkan Umur : ");
                this.umur = input.nextInt();
                input.nextLine();
                if(this.umur < 0){
                    System.out.println("Mohon Inputkan angka dengan baik dan benar");
                }
            }
            catch (Exception e){
                fail +=1;
                if(fail > 2){
                    System.out.println("Mohon perhatikan lagi inputan");
                } else {
                    System.out.println("Mohon inputkan angka");
                }
                input.nextLine();
            }
         } while (this.umur < 1 ); //perulangan

         //jenis pasien
         //exception
         do{
            try{
                //collection hashmap
                HashMap<String, String> daftarjenispasien = new HashMap<String, String>();
                    daftarjenispasien.put("1", "BPJS");
                    daftarjenispasien.put("2", "UMUM");
                    daftarjenispasien.put("3", "VIP");
                    System.out.println(daftarjenispasien); 

                System.out.println("Inputkan Jenis Pasien : ");
                this.noJenisPasien = input.nextInt();
                input.nextLine();
                if(this.noJenisPasien<1 || this.noJenisPasien>3)
                {
                System.out.println("Inputan harus angka 1 -3 ");
                }
            } catch (Exception e){
                fail += 1;
                //percabangan
                if (fail > 2) {
                    System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                    System.out.println("Mohon Inputkan inputan berupa angka!");
                    }
                    input.nextLine();
                    }
                    } while (this.noJenisPasien < 1 || this.noJenisPasien > 3); //perulangan
                    //percabangan
                    if(this.noJenisPasien == 1){
                        this.jenisPasien = "BPJS";
                    }
                    else if(this.noJenisPasien == 2){
                        this.jenisPasien = "Umum";
                    }
                    else if(this.noJenisPasien == 3){
                        this.jenisPasien = "VIP";
                    }

            //biaya
            //percabangan switch
            switch(jenispemeriksaan){
                case "Tiroid" : 
                this.biaya = 220000;
                System.out.println("Biaya Pemeriksaan : " +this.biaya);
                break;
                case "Demam Berdarah" :
                this.biaya = 150000;
                System.out.println("Biaya Pemeriksaan : " +this.biaya);
                break;
                case "Malaria" :
                this.biaya = 150000;
                System.out.println("Biaya Pemeriksaan : " +this.biaya);
                break;
                case "Covid-19" :
                this.biaya = 250000;
                System.out.println("Biaya Pemeriksaan : " +this.biaya);
                break;
                case "Kolestrol" :
                this.biaya = 200000;
                System.out.println("Biaya Pemeriksaan : " +this.biaya);
                break;
            }

            //tagihan
            //percabangan if else dan proses matematika
            if(noJenisPasien ==1){ //bpjs
                this.totalBiaya = 0;
                System.out.println("Tagihan : " +this.totalBiaya);
            }
            else if(noJenisPasien == 2){ //umum
                this.totalBiaya = this.biaya;
                System.out.println("Tagihan : " +this.totalBiaya);
            }
            else if (noJenisPasien == 3) {
                this.totalBiaya = 0.75 * this.biaya; // diskon 25 persen (VIP) proses matematika
                System.out.println("Tagihan : " +this.totalBiaya+ "(DISKON 25%)");
            }

            //pembayaran
            //exception
            do{
                try{
                    System.out.println("Inputkan Nominal Pembayaran : ");
                    bayar = input.nextInt();
                    input.nextLine();
                    if(bayar < totalBiaya){
                        System.out.println("Mohon Inputkan angka dengan baik dan benar");
                    }
                }
                catch (Exception e){
                    fail +=1;
                    if(fail > 2){
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
             } while (bayar < totalBiaya ); // perulangan

             //kembalian
             //proses matematika
                this.kembalian = this.bayar - totalBiaya;
                System.out.println("Kembalian = " +this.kembalian);
           
            
            
             //database
        String sql = "INSERT INTO tagihanpasien (nama, no_rm, jenis_kelamin, alamat, umur, jenis_pasien, jenis_pemeriksaan, biaya, tagihan, pembayaran, kembalian) VALUES ('"+nama+"','"+noRekamMedis+"','"+jenisKelamin+"','"+alamat+"','"+umur+"','"+jenisPasien+"','"+jenispemeriksaan+"','"+biaya+"','"+totalBiaya+"','"+bayar+"','"+kembalian+"')";
       con = DriverManager.getConnection(url,"root","");
       Statement statement = con.createStatement();
       statement.execute(sql);
       System.out.println("DATA BERHASIL DIINPUT!");
   }
   catch (SQLException e) {
       System.err.println("DATA GAGAL DIINPUT");
   }
   catch (InputMismatchException e) {
       System.err.println("Inputan harus berupa angka");
            
        }
    }
    //database
    @Override
    public void ubah()throws SQLException{
        
    }
    //database
    @Override
    public void hapus()throws SQLException{
        
    }
    //database
    @Override
    public void cari()throws SQLException{
        
    }

}