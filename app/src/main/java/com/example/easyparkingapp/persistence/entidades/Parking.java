package com.example.easyparkingapp.persistence.entidades;

public class Parking {
    private String nombre;
    private String address;
    private int imageId;

    public Parking(){}

    public Parking(String name, String address) {
        this.nombre = name;
        this.address = address;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
