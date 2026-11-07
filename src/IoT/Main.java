package IoT;

public class Main {

	public static void main(String[] args) {
		SensorKelembapan sensor = new SensorKelembapan("SNS-01", "Sensor Tanah Pot 1");
		Pengendali kontrol = new PompaAir("PMP-01", "Pompa Air Pot 1");

		PompaAir pompa = (PompaAir) kontrol;
		Pemantau pantau = (Pemantau) kontrol;

        System.out.println("===[ Smart Irrigation ]===");
        System.out.println("Batas kering: kurang dari " + SensorKelembapan.BATAS_KERING + "%");
        System.out.println();

        int[] skenario = {25, 60, 40}; // atur skenario kelembapan ... %
        for (int i = 0; i < skenario.length; i++) {
            System.out.println("Skenario " + (i + 1) + ": kelembapan " + skenario[i] + "%");

            kontrol.matikan(); // kondisi awal tiap skenario
            sensor.proses(skenario[i]); // sensor memeriksa nilai
            pompa.proses(sensor.getKelembapan()); // pompa menyala/mati mengikuti hasil sensor

            System.out.println("  Kelembapan: " + sensor.getKelembapan() + "%");
            System.out.println("  Kondisi tanah: " + sensor.getKondisiTanah());
            System.out.println("  Status pompa: " + pantau.getStatus());
            System.out.println("  " + sensor.info());
            System.out.println("  " + pompa.info());
            System.out.println();
        }
	}
}
