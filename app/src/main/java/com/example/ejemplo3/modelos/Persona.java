package com.example.ejemplo3.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private String nombre;
    private String apellidos;
    private int edad;
    private float altura;
    private float peso;
    private boolean casado;

    public Persona(String nombre, String apellidos, int edad, float altura, float peso, boolean casado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.casado = casado;
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        edad = in.readInt();
        altura = in.readFloat();
        peso = in.readFloat();
        casado = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeInt(edad);
        dest.writeFloat(altura);
        dest.writeFloat(peso);
        dest.writeByte((byte) (casado ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                ", casado=" + casado +
                '}';
    }


}
