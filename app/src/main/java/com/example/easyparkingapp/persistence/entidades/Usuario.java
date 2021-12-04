package com.example.easyparkingapp.persistence.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Usuario {
    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String nombre;
    @NonNull
    private String correo;

    private  String phoneNumber;

    public Usuario() {
    }

    public Usuario(@NonNull String nombre, @NonNull String correo,@NonNull String phoneNumber) {

        this.nombre = nombre;
        this.correo = correo;
        this.phoneNumber= phoneNumber;

    }
    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @NonNull
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(@NonNull String correo) {
        this.correo = correo;
    }


}