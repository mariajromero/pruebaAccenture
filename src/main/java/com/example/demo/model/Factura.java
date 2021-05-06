package com.example.demo.model;

public class Factura {
    private double valorIVA;
    private double precioFinal;
    private double valorDomicilio;
    public Factura(double valorIVA,double precioFinal,double valorDomicilio){
        this.valorIVA=valorIVA;
        this.precioFinal=precioFinal;
        this.valorDomicilio=valorDomicilio;
    }

    public double getValorDomicilio() {
        return valorDomicilio;
    }

    public double getValorIVA() {
        return valorIVA;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setValorDomicilio(double valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }

    public void setValorIVA(double valorIVA) {
        this.valorIVA = valorIVA;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
