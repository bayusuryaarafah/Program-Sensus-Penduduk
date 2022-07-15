
import java.util.Scanner;

public class DatasensuspendudukSJ {

    private int bnyk_penduduk = 0;
    private String[] nama_penduduk = new String[100];
    public String[] jenis_pekerjaan = new String[100];
    private String[] alamat_penduduk = new String[100];
    private int[] gaji = new int[10000000];
    private String[][] pajak_penduduk = new String[1000][7];

    public int get_bnyk_penduduk() {
        return this.bnyk_penduduk;
    }

    public void add_data_pajak(String nama, int gaji, int pajak_lingkungan, int pajak_kendaraan, int pajak_pbb,
            int total, int bayar) {
        this.pajak_penduduk[this.bnyk_penduduk][0] = nama;
        this.pajak_penduduk[this.bnyk_penduduk][1] = String.valueOf(gaji);
        this.pajak_penduduk[this.bnyk_penduduk][2] = String.valueOf(pajak_lingkungan);
        this.pajak_penduduk[this.bnyk_penduduk][3] = String.valueOf(pajak_kendaraan);
        this.pajak_penduduk[this.bnyk_penduduk][4] = String.valueOf(pajak_pbb);
        this.pajak_penduduk[this.bnyk_penduduk][5] = String.valueOf(total);
        this.pajak_penduduk[this.bnyk_penduduk][6] = String.valueOf(bayar);
        this.bnyk_penduduk++;
    }

    public void add_nilai(String nama, int gaji, String pekerjaan, String alamat) {
        this.nama_penduduk[this.bnyk_penduduk] = nama;
        this.gaji[this.bnyk_penduduk] = gaji;
        this.jenis_pekerjaan[this.bnyk_penduduk] = pekerjaan;
        this.alamat_penduduk[this.bnyk_penduduk] = alamat;
        this.bnyk_penduduk++;
    }

    public String[][] get_pajak() {
        return this.pajak_penduduk;
    }

    public String[] get_nama() {
        String[] temp_nama = new String[this.bnyk_penduduk];

        for (int i = 0; i < this.bnyk_penduduk; i++) {

            temp_nama[i] = this.nama_penduduk[i];
        }

        return temp_nama;
    }

    public int[] get_gaji() {
        int[] temp_gaji = new int[this.bnyk_penduduk];
        for (int i = 0; i < this.bnyk_penduduk; i++) {

            temp_gaji[i] = this.gaji[i];
        }

        return temp_gaji;
    }

    public String[] get_pekerjaan() {
        String[] temp_pekerjaan = new String[this.bnyk_penduduk];

        for (int i = 0; i < this.bnyk_penduduk; i++) {

            temp_pekerjaan[i] = this.jenis_pekerjaan[i];
        }
        return temp_pekerjaan;
    }

    public String[] get_alamat() {
        String[] temp_alamat = new String[this.bnyk_penduduk];

        for (int i = 0; i < this.bnyk_penduduk; i++) {

            temp_alamat[i] = this.alamat_penduduk[i];
        }
        return temp_alamat;
    }

    public int hitung_pajak(int gaji) {
        int pajak = 0;
        if (gaji < 50000000) {
            pajak = Math.abs((5 / 100) * gaji);
        } else if (gaji >= 50000000 && gaji < 250000000) {
            pajak = Math.abs((15 / 100) * gaji);
        } else if (gaji >= 250000000 && gaji < 500000000) {
            pajak = Math.abs((15 / 100) * gaji);
        } else if (gaji > 500000000) {
            pajak = Math.abs((15 / 100) * gaji);
        } else {
            pajak = 0;
        }
        return pajak;
    }

    public static void main(String[] args) {
        System.out.println("Nama : Bayu Surya Arafah");
        System.out.println("NPM  : 4520210082");
        System.out.println("Studi Kasus : Data Sensus Kependudukan Sunter Jaya");
        System.out.println("Update : 3 Januari 2022");

        String[][] nama_penduduk = new String[2][3];
        Scanner masuk = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int menu = 0, Wilayah = 0;
        int bnyk_penduduk = 0;
        int gaji;
        String pekerjaan;
        String alamat;
        int[] lihat_gaji = new int[10000000];
        String[] lihat_pekerjaan = new String[100];
        String[] lihat_alamat = new String[100];
        String nama, judul = "";
        String[] lihat_nama = new String[100];
        boolean terus = true;

        DatasensuspendudukSJ RT07 = new DatasensuspendudukSJ();
        DatasensuspendudukSJ RT08 = new DatasensuspendudukSJ();
        DatasensuspendudukSJ RT09 = new DatasensuspendudukSJ();

        Pajak pajak = new Pajak();

        while (terus) {
            System.out.println("\nMasukkan Pilihan: ");
            System.out.println("1. Inputan Data Array 1D");
            System.out.println("2. Inputan Data Array 2D");
            System.out.println("3. Inputan Data Array Multidimensi");
            System.out.println("4. Input Pajak");
            System.out.println("5. Lihat Data Array 1D");
            System.out.println("6. Keluar");
            System.out.print("Masukkan: ");
            menu = Integer.parseInt(input.nextLine());
            if (menu != 3 && menu != 4) {

                System.out.println("\nMasukkan Wilayah RT: ");
                System.out.println("1. Wilayah RT07");
                System.out.println("2. Wilayah RT08");
                System.out.println("3. Wilayah RT09");
                System.out.print("Masukkan: ");
                Wilayah = Integer.parseInt(input.nextLine());
            }
            switch (menu) {
                case 1:

                    System.out.print("\nInput Nama Penduduk: ");
                    nama = input.nextLine();
                    System.out.print("Masukkan Gaji Penduduk: ");
                    gaji = Integer.parseInt(input.nextLine());
                    System.out.print("Masukkan Jenis Pekerjaan: ");
                    pekerjaan = input.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    alamat = input.nextLine();

                    if (Wilayah == 1) {
                        RT07.add_nilai(nama, gaji, pekerjaan, alamat);
                    } else if (Wilayah == 2) {
                        RT08.add_nilai(nama, gaji, pekerjaan, alamat);
                    } else if (Wilayah == 3) {
                        RT09.add_nilai(nama, gaji, pekerjaan, alamat);
                    } else {
                        System.out.println("Pilihan Tidak Diketahui!");
                    }

                    break;
                case 2:

                    System.out.print("Jumlah Penduduk : ");
                    int n = masuk.nextInt();

                    String data_sensus[][] = new String[n][3];

                    for (int i = 0; i < n; i++) {
                        System.out.println("");
                        System.out.println("Data Penduduk ke " + (i + 1));

                        for (int j = 0; j < 3; j++) {
                            if (j == 0) {
                                System.out.print("Gaji     : ");
                            } else if (j == 1) {
                                System.out.print("Nama    : ");
                            } else {
                                System.out.print("Pekerjaan : ");
                            }

                            System.out.print("");
                            data_sensus[i][j] = masuk.next();
                        }
                    }

                    System.out.println("Data Penduduk Yang Dimasukan");
                    System.out.println("-----------------------------");
                    System.out.println("Gaji \t\t  Nama \t\t  Pekerjaan \t");

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print(data_sensus[i][j] + "\t\t");
                        }
                        System.out.println();
                    }
                    break;

                case 3:

                    for (int barisan = 0; barisan < nama_penduduk.length; barisan++) {
                        for (int kolomnom = 0; kolomnom < nama_penduduk[barisan].length; kolomnom++) {
                            System.out.print("Input nama penduduk (" + barisan + "," + kolomnom + ") : ");
                            nama_penduduk[barisan][kolomnom] = scan.nextLine();
                        }
                    }
                    System.out.println("-------------------------");
                    for (int barisan = 0; barisan < nama_penduduk.length; barisan++) {
                        for (int kolomnom = 0; kolomnom < nama_penduduk[barisan].length; kolomnom++) {
                            System.out.print("| " + nama_penduduk[barisan][kolomnom] + " |*");
                        }
                        System.out.println("");
                    }
                    System.out.println("-------------------------");
                    break;
                case 4:
                    System.out.println("\n1. Input Data Pajak: ");
                    System.out.println("2. Lihat Data Pajak");
                    System.out.print("Pilih: ");
                    int pilih = Integer.parseInt(input.nextLine());
                    if (pilih == 1) {
                        pajak.input_pajak();
                    } else if (pilih == 2) {
                        pajak.tampil();
                    } else {
                        System.out.println("Pilihan Tidak Diketahui!");
                    }
                    break;
                case 5:
                    if (Wilayah == 1) {
                        lihat_nama = RT07.get_nama();
                        lihat_gaji = RT07.get_gaji();
                        lihat_pekerjaan = RT07.get_pekerjaan();
                        lihat_alamat = RT07.get_alamat();
                        bnyk_penduduk = RT07.get_bnyk_penduduk();
                        judul = "Wilayah RT07";
                    } else if (Wilayah == 2) {
                        lihat_nama = RT08.get_nama();
                        lihat_gaji = RT08.get_gaji();
                        lihat_pekerjaan = RT08.get_pekerjaan();
                        lihat_alamat = RT08.get_alamat();
                        bnyk_penduduk = RT08.get_bnyk_penduduk();
                        judul = "Wilayah RT08";
                    } else if (Wilayah == 3) {
                        lihat_nama = RT09.get_nama();
                        lihat_gaji = RT09.get_gaji();
                        lihat_pekerjaan = RT09.get_pekerjaan();
                        lihat_alamat = RT09.get_alamat();
                        bnyk_penduduk = RT09.get_bnyk_penduduk();
                        judul = "Wilayah RT09";
                    } else {
                        System.out.println("Pilihan Tidak Diketahui!");
                    }

                    System.out.println("\nData Penduduk " + judul);
                    System.out.println("-------------------------------");

                    for (int i = 0; i < bnyk_penduduk; i++) {
                        System.out.println("Nama Penduduk: " + lihat_nama[i]);
                        System.out.println("Gaji Penduduk: " + lihat_gaji[i]);
                        System.out.println("Pekerjaan Penduduk: " + lihat_pekerjaan[i]);
                        System.out.println("Alamat Penduduk: " + lihat_alamat[i]);
                        System.out.println("-------------------------------");
                    }

                    break;
                case 6:
                    terus = false;
                    break;
                default:
                    System.out.println("Pilihan Tidak Diketahui!");
            }

        }
    }
}

class Pajak extends DatasensuspendudukSJ {

    Thread thread;

    private String nama;
    private int gaji, pajak_lingkungan, pajak_kendaraan, pajak_pbb;
    private int total_pajak, bayar;

    String[][] data;
    int banyak_penduduk;

    Scanner input = new Scanner(System.in);
    boolean terus = true;

    public Pajak() {

    }

    public void input_pajak() {
        boolean tunggu = true;
        while (tunggu) {
            System.out.print("\nInput Nama Penduduk: ");
            nama = input.nextLine();
            System.out.print("Masukkan Gaji Penduduk: ");
            gaji = Integer.parseInt(input.nextLine());
            System.out.print("Masukkan Pajak Lingkungan: ");
            pajak_lingkungan = Integer.parseInt(input.nextLine());
            System.out.print("Masukkan Pajak Kendaraan: ");
            pajak_kendaraan = Integer.parseInt(input.nextLine());
            System.out.print("Masukkan PBB Pajak: ");
            pajak_pbb = Integer.parseInt(input.nextLine());
            System.out.println("-------------------------------");
            System.out.println("Total Pajak: " + (pajak_lingkungan + pajak_kendaraan + pajak_pbb));
            System.out.println("-------------------------------");
            // Kalkulasi
            kalkulasi_pajak();
            // Bayar
            bayar();
            super.add_data_pajak(nama, gaji, pajak_lingkungan, pajak_kendaraan, pajak_pbb, total_pajak, bayar);

            String opsi;
            System.out.println("Input Data Lagi ? (y/n)");
            System.out.print("Masukan Pilihan: ");
            opsi = input.nextLine();
            if (opsi.equalsIgnoreCase("n")) {
                tunggu = false;
            }
        }
    }

    public void kalkulasi_pajak() {
        // Thread
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    total_pajak = pajak_lingkungan + pajak_kendaraan + pajak_pbb;

                    sleep(1000);
                } catch (InterruptedException ex) {
                    // Error Exception Handling
                    System.out.println("Error: " + ex);
                }
            }
        };
        thread.start();
    }

    public void tampil() {
        data = super.get_pajak();
        banyak_penduduk = super.get_bnyk_penduduk();
        // Thread
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < banyak_penduduk; i++) {
                        System.out.println("Nama Penduduk: " + data[i][0]);
                        System.out.println("Gaji Penduduk: " + data[i][1]);
                        System.out.println("Pajak Lingkungan: " + data[i][2]);
                        System.out.println("Pajak Kendaraan: " + data[i][3]);
                        System.out.println("Pajak PBB: " + data[i][4]);
                        System.out.println("-------------------------------");
                        System.out.println("Total Pajak: " + data[i][5]);
                        System.out.println("Bayar: " + data[i][6]);
                        System.out.println("-------------------------------");
                        System.out.println("");
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    // Error Exception Handling
                    System.out.println("Error: " + ex);
                }
            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void bayar() {
        terus = true;
        while (terus) {

            System.out.print("Masukkan Jumlah Pembayaran: ");
            bayar = Integer.parseInt(input.nextLine());
            if (bayar < total_pajak) {
                System.out.println("-------------------------------");
                System.out.println("Biaya Pembayaran Kurang !");
            } else {
                System.out.println("Kembalian: " + (bayar - total_pajak));
                System.out.println("-------------------------------");
                terus = false;
            }
        }
    }
}
