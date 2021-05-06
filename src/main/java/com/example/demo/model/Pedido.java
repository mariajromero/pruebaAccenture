package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private List<Integer> idProductosPedidos;
    private int id;
    private LocalDateTime fecha;

    public Pedido(List<Integer> idProductosPedidos, int id, LocalDateTime fecha){
        this.idProductosPedidos=idProductosPedidos;
        this.id=id;
        this.fecha=fecha;
    }
    public void update(Pedido pedido){
        this.idProductosPedidos=pedido.idProductosPedidos;
        this.id=pedido.id;
        this.fecha=fecha;
    }

    public List<Integer> getIdProductosPedidos() {
        return idProductosPedidos;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setIdProductosPedidos(List<Integer> idProductosPedidos) {
        this.idProductosPedidos = idProductosPedidos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
