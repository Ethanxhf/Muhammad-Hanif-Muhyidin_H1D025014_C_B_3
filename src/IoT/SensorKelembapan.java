package IoT;

public class SensorKelembapan extends PerangkatIoT {
    public static final int BATAS_KERING = 40; 
    public static final int KELEMBAPAN_MIN = 0;
    public static final int KELEMBAPAN_MAKS = 100;

    private int kelembapan;
    private String kondisiTanah;

    public SensorKelembapan(String id, String nama, int kelembapanAwal) {
        super(id, nama);
        setKelembapan(kelembapanAwal);
        this.kondisiTanah = tentukanKondisi();
    }

    public SensorKelembapan(String id, String nama) {
        this(id, nama, KELEMBAPAN_MIN);
    }

    public SensorKelembapan(String id) {
        super(id);
        this.kelembapan = KELEMBAPAN_MIN;
        this.kondisiTanah = tentukanKondisi();
    }

    public int getKelembapan() {
        return kelembapan;
    }

    public void setKelembapan(int kelembapan) {
        if (kelembapan < KELEMBAPAN_MIN || kelembapan > KELEMBAPAN_MAKS) {
            throw new IllegalArgumentException(
                "Kelembapan harus 0-100, diterima: " + kelembapan);
        }
        this.kelembapan = kelembapan;
    }

    public String getKondisiTanah() {
        return kondisiTanah;
    }

    public void setKondisiTanah(String kondisiTanah) {
        this.kondisiTanah = kondisiTanah;
    }

    public boolean isKering() {
        return kelembapan < BATAS_KERING;
    }

    private String tentukanKondisi() {
        if (isKering()) {
            return "Kering";
        } else {
            return "Cukup lembap";
        }
    }

    @Override
    public void proses(int kelembapan) {
        setKelembapan(kelembapan);
        if (this.kelembapan < BATAS_KERING) {
            this.kondisiTanah = "Kering";
        } else {
            this.kondisiTanah = "Cukup lembap";
        }
    }

    @Override
    public String info() {
        return super.info() + " | Kelembapan: " + kelembapan + "% | Kondisi: " + kondisiTanah;
    }
}
