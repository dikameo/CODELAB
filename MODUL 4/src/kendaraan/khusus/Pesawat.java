package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.Flyable;

public class Pesawat extends Kendaraan implements Flyable {


    
        // Nama : Wahyu andika 
        // Nim : 202310370311075 
        // Kelas : 2B

    @Override
    public void Start() {
        System.out.println("Mennyalakan pesawat " + this.getName());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getName());
    }

    @Override
    public void fly() {
        System.out.println("Pesawat " + this.getName() + " lepas landas");
    }

    @Override
    public void Brake() {
        System.out.println("Pesawat berhenti");
    }
    // public void Brake() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'Brake'");
    // }
}
