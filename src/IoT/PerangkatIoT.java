package IoT;

public abstract class PerangkatIoT {
	private final String id;
    private String nama;

    public PerangkatIoT(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public PerangkatIoT(String id) {
        this(id, "Perangkat Tanpa Nama");
    }

    public abstract void proses(int kelembapan);

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String info() {
        return "[" + id + "] " + nama;
    }
}
