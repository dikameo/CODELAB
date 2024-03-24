public class App {
    public static void main(String[] args) throws Exception {

    // Wahyu Andika
    // 202310370311075
    // 2B
        Tabung tabung = new Tabung("tabung");
        Kubus kubus = new Kubus("kubus");
        Balok balok = new Balok("balok");

        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}
