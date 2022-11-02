public class VirtualDemo {
    public static void main(String[] args) {
        Gaji s = new Gaji("wahyu","KUBAR",3,5000.00);

        
        //POLIMORPHISME
        Pegawai e = new Gaji("ini nama","samarinda",2,2500.00);


        //DOWNCASTING
        System.out.println("memanggil mailchheck berdasarkan referensi gaji--");
        s.mailcheck();


        //UPCASTING
        System.out.println("\nmemanggil mailcheck berdasarkan referensi pegawai--");
        e.mailcheck();
    }
}