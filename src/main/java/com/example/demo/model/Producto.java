package com.example.demo.model;

public class Producto {
    private double precio;
    private int id;
    private String nombre;



    public Producto(double precio,  int id, String nombre){
        this.precio=precio;
        this.id=id;
        this.nombre=nombre;


    }
    public void update(Producto producto){
        this.precio=producto.precio;
        this.id=producto.id;
        this.nombre=producto.nombre;

    }



    public String getNombre() {
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }


    public int getId(){

        return id;
    }


    public void setPrecio(double precio) {
        this.precio= precio;
    }

    public void setId(int id) {
        this.id=id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
