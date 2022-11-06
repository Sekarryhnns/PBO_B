public class Demo {
    public static void main(String[] args) {
        Asdos fairuzikun = new Asdos("fairuzikun",23,4);
        Dosen raja = new Dosen("Raja OP Damanik",5);
        Asdos angel = new Asdos("Angel-chan",19,7);
        Mahasiswa firman = new Mahasiswa("Firman",20);
        Mahasiswa nid = new Mahasiswa("Nid to pass this sem", 23);
        Dosen nivotko = new Dosen("Nivotko",3);

        fairuzikun.View();
        raja.View();
        angel.View();
        firman.View();
        nid.View();
        nivotko.View();

        int totalJamSibuk = fairuzikun.jamSibuk + raja.jamSibuk + 
        angel.jamSibuk + firman.jamSibuk + nid.jamSibuk + nivotko.jamSibuk;

        System.out.println("Total jam sibuk elemen Fasilkom adalah "+totalJamSibuk);
    }
}
