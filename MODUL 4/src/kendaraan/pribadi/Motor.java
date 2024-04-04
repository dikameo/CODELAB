package kendaraan.pribadi;

import kendaraan.Kendaraan;

public class Motor extends Kendaraan {
    
        // Nama : Wahyu andika 
        // Nim : 202310370311075 
        // Kelas : 2B

    @Override
    public void Start() {
        System.out.println("Motor " + this.getName() + " dinyalakan");
    }

    @Override
    public void Stop() {
        System.out.println("Motor " + this.getName() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Motor berhenti");
    }
}
