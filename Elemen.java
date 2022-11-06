public class Elemen {
    public String nama;
    public int jamSibuk;

    public Elemen(String nama) {
        //DOWNCASTING
        this.nama = nama;
    }
}

class Dosen extends Elemen {
    //extends merupakan salah satu bentuk awal dari pembentukan POLYMORPHISME
    private int jumlahHariKerja;
    public int getJumlahHariKerja() {
        return jumlahHariKerja;
    }

    public void setJumlahHariKerja(int jumlahHariKerja) {
        this.jumlahHariKerja = jumlahHariKerja;
    }

    public Dosen(String nama) {
        super(nama);
    }

    public Dosen(String nama, int jumlahHariKerja) {
        super(nama);
        jamSibuk = jumlahHariKerja * 8;
    }

    public int getJamSibuk() {
        return jumlahHariKerja;
    }

    public void View() {
        System.out.println(nama + " adalah seorang dosen dengan jam sibuk " + jamSibuk);
    }
}

class Mahasiswa extends Elemen {
    private int sks;
    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public Mahasiswa(String nama, int sks) {
        super(nama);
        jamSibuk = sks * 3;
    }

    public int getJamSibuk() {
        return jamSibuk;
    }

    public void View() {
        System.out.println(nama + " adalah seorang mahasiswa dengan jam sibuk " + jamSibuk);
    }
}

class Asdos extends Mahasiswa {
    private int jamNgasdos;
    public int getJamNgasdos() {
        return jamNgasdos;
    }

    public void setJamNgasdos(int jamNgasdos) {
        this.jamNgasdos = jamNgasdos;
    }

    public Asdos(String nama, int sks, int jamNgasdos) {
        super(nama, sks);
        this.jamNgasdos = jamNgasdos;

    }

    public int getJamSibuk() {
        return jamNgasdos + super.getJamSibuk();
    }

    public void View() {
        //DOWNCASTING
        System.out.println(nama + " adalah seorang asdos dengan jam sibuk " + jamSibuk);
    }
}
