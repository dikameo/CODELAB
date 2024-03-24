public class BangunRuang {


    // Wahyu Andika
    // 202310370311075
    // 2B
    private String name;

    public BangunRuang(String name){
        this.name = name;
    }

    public void inputNilai(){
        System.out.println("Input nilai " + this.name);
    }

    public void luasPermukaan(){
        System.out.println("Menghitung luas permukaan bangun " + this.name);
    }

    public void volume(){
        System.out.println("Menghitung volume bangun " + this.name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
