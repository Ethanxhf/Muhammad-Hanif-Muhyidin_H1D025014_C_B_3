package IoT;

interface Pengendali {
    void nyalakan();
    void matikan();
}

interface Pemantau {
    boolean isMenyala();
    String getStatus();
}

public class PompaAir extends PerangkatIoT implements Pengendali, Pemantau {
    private boolean menyala;

    public PompaAir(String id, String nama, boolean menyalaAwal) {
        super(id, nama);
        this.menyala = menyalaAwal;
    }

    public PompaAir(String id, String nama) {
        this(id, nama, false);
    }

    public PompaAir(String id) {
        super(id);
        this.menyala = false;
    }

    public void setMenyala(boolean menyala) {
        this.menyala = menyala;
    }

    @Override
    public void nyalakan() {
        this.menyala = true;
    }

    @Override
    public void matikan() {
        this.menyala = false;
    }

    @Override
    public boolean isMenyala() {
        return menyala;
    }

    @Override
    public String getStatus() {
        if (menyala) {
            return "Menyala";
        } else {
            return "Mati";
        }
    }

    @Override
    public void proses(int kelembapan) {
        if (kelembapan < SensorKelembapan.BATAS_KERING) {
            nyalakan();
        } else {
            matikan();
        }
    }

    @Override
    public String info() {
        return super.info() + " | Status pompa: " + getStatus();
    }
}

