package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.ShootAble;

public class Tank extends Kendaraan implements ShootAble{
    
        // Nama : Wahyu andika 
        // Nim : 202310370311075 
        // Kelas : 2B

    @Override
    public void Start() {
        System.out.println("Menyalakan " + this.getName() + " tank");
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan tank " + this.getName());
    }

    @Override
    public void Brake() {
        System.out.println("Tank berhenti");
    }

    @Override
    public void Shoot(String vehicle) {
        System.out.println("Tank menembak " + vehicle);
    }
}
