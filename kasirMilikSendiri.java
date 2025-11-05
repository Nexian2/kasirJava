import java.util.Scanner;
public class kasirMilikSendiri {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        String[] daftarBarang = {
            "Indomie Goreng", "Aqua 600ml", "Teh Botol Sosro", "Chitato", "Pocari Sweat", "Oreo",
            "Sabun Mandi Lifebuoy", "Shampoo Pantene", "Pasta Gigi Pepsodent", "Detergen Rinso", "Tissue Paseo",
            "Sapu", "Pel", "Ember"
        };
        int[] hargaBarang = {
            3500, 4000, 5500, 8000, 7500, 9000,
            12000, 25000, 10500, 15000, 8500,
            25000, 30000, 18000
        };

        boolean tambahBarang = true;
        double totalHarga = 0;

        // ASCII Welcome
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║        SELAMAT DATANG DI INDOMARET        ║");
        System.out.println("╚════════════════════════════════════════════╝");

        while (tambahBarang) {
            System.out.println("\n┌───────────────────────────────┐");
            System.out.println("│          DAFTAR BARANG         │");
            System.out.println("├───────────────────────────────┤");
            for (int i = 0; i < daftarBarang.length; i++) {
                System.out.printf("│ %2d. %-20s Rp %,7d │%n", i + 1, daftarBarang[i], hargaBarang[i]);
            }
            System.out.println("└───────────────────────────────┘");

            System.out.print("Pilih nomor barang yang ingin dibeli: ");
            int pilihan = input.nextInt();
            if (pilihan < 1 || pilihan > daftarBarang.length) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            System.out.print("Masukkan jumlah: ");
            int jumlah = input.nextInt();

            totalHarga += hargaBarang[pilihan - 1] * jumlah;

            System.out.print("Apakah ada barang lagi? (y/n): ");
            char tahap = input.next().charAt(0);
            if (tahap == 'n') {
                tambahBarang = false;
            } else if (tahap != 'y') {
                System.out.println("Input harus 'y' atau 'n', dihitung sebagai 'n'.");
                tambahBarang = false;
            }
        }

        // Diskon 10% jika total > 100.000
        double diskon = 0;
        if (totalHarga > 100000) {
            diskon = 0.1 * totalHarga;
        }
        double bayarTotal = totalHarga - diskon;

        // ASCII Tagihan
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║             TAGIHAN                ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.printf("Total Harga     : Rp %,10.0f%n", totalHarga);
        System.out.printf("Diskon          : Rp %,10.0f%n", diskon);
        System.out.printf("Total Bayar     : Rp %,10.0f%n", bayarTotal);

        System.out.print("Masukkan jumlah uang yang dibayarkan: Rp ");
        double bayar = input.nextDouble();
        if (bayar < bayarTotal) {
            System.out.println("Uang kurang! Transaksi gagal.");
        } else {
            double kembalian = bayar - bayarTotal;
            System.out.printf("Transaksi berhasil! Kembalian: Rp %,10.0f%n", kembalian);
        }

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     TERIMA KASIH SUDAH BERBELANJA ║");
        System.out.println("╚════════════════════════════════════╝");

        input.close();
    }
}
