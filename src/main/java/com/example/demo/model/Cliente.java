package com.example.demo.model;

public class Cliente {
    private String direccion;
    private int cedula;



    public Cliente(String direccion,  int cedula){
        this.direccion=direccion;
        this.cedula=cedula;


    }
    public void update(Cliente cliente ){
        this.direccion=cliente.direccion;
        this.cedula=cliente.cedula;

    }
    public String getDireccion(){
        return direccion;
    }


    public int getCedula(){

        return cedula;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }


}

