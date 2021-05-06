package com.example.demo.service;

import com.example.demo.model.Factura;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;
import repository.ProductoRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {
    public Pedido getPedido(int id){
        return PedidoRepository.getInstance().getPedido(id);
    }
    public Factura deletePedido (int id){
        Pedido pedidoGuardado=PedidoRepository.getInstance().getPedido(id);
        LocalDateTime horaActual=LocalDateTime.now();
        LocalDateTime horaGuardada=pedidoGuardado.getFecha();
        Duration duration=Duration.between(horaGuardada,horaActual);
        if(duration.toHours()<12){
            PedidoRepository.getInstance().borrarPedido(id);
        }
        else{
            double diezPorciento=getTotalPrecioPedidos(pedidoGuardado.getIdProductosPedidos())*0.1;
            PedidoRepository.getInstance().borrarPedido(id);
            return new Factura(0,diezPorciento,0);



        }
        return  null;
    }
    public Factura postPedido(Pedido pedido){
        List<Integer> idsProductos = pedido.getIdProductosPedidos();
        double precioTotal= getTotalPrecioPedidos(idsProductos);
        LocalDateTime horaGuardada=LocalDateTime.now();
        pedido.setFecha(horaGuardada);
        PedidoRepository.getInstance().agregarPedido(pedido);
        if(precioTotal>70000 && precioTotal<100000){
            Factura factura=new Factura(0.19,precioTotal+precioTotal*0.19,5000);
            return factura;
        }
        else if(precioTotal>100000){
            return new Factura(0.19,precioTotal+precioTotal*0.19,0);
        }

        return new Factura(0,precioTotal,5000);

    }
    public Factura putPedido(Pedido pedido){
        Pedido pedidoGuardado=PedidoRepository.getInstance().getPedido(pedido.getId());
        LocalDateTime horaActual=LocalDateTime.now();
        LocalDateTime horaGuardada=pedidoGuardado.getFecha();
        Duration duration=Duration.between(horaGuardada,horaActual);

        if(duration.toHours()<5){
            double totalNuevo = getTotalPrecioPedidos(pedido.getIdProductosPedidos());
            double totalViejo=getTotalPrecioPedidos(pedidoGuardado.getIdProductosPedidos());
            if(totalNuevo>=totalViejo){
                PedidoRepository.getInstance().modificarPedido(pedido);
            }
            if(totalNuevo>100000){
                return new Factura(0.19,totalNuevo,0);
            }
        }
        return null;
    }
    public List<Pedido> getAllPedidos(){
        return PedidoRepository.getInstance().getListaPedidos();
    }

    private double getTotalPrecioPedidos(List<Integer> idsProductos){
        double precioTotal=0;
        for (int i=0;i<idsProductos.size();i++){
            Integer idCogido=idsProductos.get(i);
            Producto productoCogido=ProductoRepository.getInstance().getProducto(idCogido);
            double precioProducto=productoCogido.getPrecio();
            precioTotal=precioTotal+precioProducto;
        }
        return precioTotal;
    }
}
